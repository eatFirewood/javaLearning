import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Author : eatfi
 * @Date : 2024/12/11 14:28
 */
public class ATM {
    private static final Account noUserAccount = new Account("000000", "a", "male");
    //不能使用未初始化的对象内部类中的方法，所以先定义了一个noUserAccount，防止编译通不过
    private static Account LoginUserAccount = noUserAccount;
    public static ATM anATM = null;
    private ATM(){
        printStartupScreen();
    };
    LinkedList<Account> accountArr = new LinkedList<>();

    //单例获取atm系统对象
    public static ATM getAnATM(){
        if(Objects.isNull(anATM)){
            anATM = new ATM();
        }
        return anATM;
    }

    public void printStartupScreen(){
        String welcomePage = """
                  *********************************************
                  *                                           *
                  *              Welcome to ATM               *
                  *                                           *
                  *********************************************
                  *                                           *
                  *        Please select an option below:     *
                  *                                           *
                  *        1. User Login (login)              *
                  *        2. Open an Account (open_account)  *
                  *        3. Show All Accounts (show)        *
                  *        4. Exit ATM (exit)                 *
                  *                                           *
                  *********************************************
                  *        Enter your choice to continue...   *
                  *********************************************
                """;
        System.out.println(welcomePage);
    }

    public void userLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter you credit number:");
        String number = sc.next();

        boolean findOrNot = false;

        for(Account i : accountArr){
            if(i.getCardNumber().equals(number)){
                findOrNot = true;
                Account.AfterLoginOption methodClassOfAnAccount = i.new AfterLoginOption();
                try {
                    //密码验证通过后才将当前对象赋值到LoginUserAccount
                    LoginUserAccount = methodClassOfAnAccount.passwordValidation();
                    if(Objects.nonNull(LoginUserAccount)) {
                        break;
                    }
                }catch(UserOperationException e){
                    System.err.println(e.getMessage());
                }
            }
        }

        if(!findOrNot){
            try{
                throw new UserOperationException("check you card number or creat an account");
            }catch(UserOperationException e){
                System.err.println(e.getMessage());
            }
        }
        if(noUserAccount != LoginUserAccount) {
            String memuList = """
                     1.deposit
                     2.withdraw
                     3.closeAccount
                     4.transfer
                     6.updatePassword
                     5.exit
                    """;
            System.out.println("login success, please select next option below:");
            System.out.println(memuList);
            String enterOption = sc.next();
            switch(enterOption){
                case "deposit" -> LoginUserAccount.new AfterLoginOption().deposit();
                case "withdraw" -> LoginUserAccount.new AfterLoginOption().withdraw();
                case "closeAccount" -> LoginUserAccount.new AfterLoginOption().closeAccount();
                case "transfer" -> LoginUserAccount.new AfterLoginOption().transfer();
                case "updatePassword" -> LoginUserAccount.new AfterLoginOption().updatePasswd();
                case "exit" -> System.out.println("exit");
                default -> System.out.println("default");
            }
        }


        //退出前重新把LoginUserAccount改回来
        LoginUserAccount = noUserAccount;
    }

    public void openAnAccount(){
        System.out.println("please enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("please enter 6 character to create your password");

        int failureCount = 0;

        String passwd = sc.next();
        while(passwd.length() != 6){
            failureCount++;
            try {
                throw new AccountCreateException("the lenth of password is not equal to 6 word, please enter 6 char");
            }catch (AccountCreateException e){
                System.err.println(e.getMessage());
            }
            passwd = sc.next();
            if(failureCount == 3){
                break;
            }
        }

        if(failureCount == 3){
            System.out.println("network error");
            return;
        }
        System.out.println("success!");
        accountArr.add(new Account(passwd, name, "male"));
    }

    public void showAllAccounts(){
        for(Account i : accountArr){
            System.out.println(i);
        }
    }
}
