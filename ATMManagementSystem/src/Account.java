import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author : data
 * @Date : 2024/12/11 14:28
 */
public class Account {

    private static int nextId = 0;
    private String cardNumber;
    private String passwd;
    private String name;
    private String gender;
    private BigDecimal balance = BigDecimal.ZERO;

    {
        nextId++;
        cardNumber = String.format("%016d", nextId);
    }

    /**
     * 可以使用构造器直接构造对象，也可以用内部的建造者类完成对象的初始化
     * @param cardNumber  a
     * @param passwd a
     * @param name a
     * @param gender a
     * @param balance a
     */
    public Account(String cardNumber, String passwd, String name, String gender, BigDecimal balance){
        this.cardNumber = cardNumber;
        this.passwd = passwd;
        this.name = name;
        this.gender = gender;
        this.balance = balance;
    }

    public Account(String passwd, String name, String gender){
        this.passwd = passwd;
        this.name = name;
        this.gender = gender;
    }

    /**
     * 静态内部类
     * 登录及登陆后相关操作
     * 登录包括密码比对方法
     * 后续相关操作有
     *  1.用户存钱
     *  2.用户取钱
     *  3.注销账户
     *  4.用户转账
     *  6.修改密码
     *  5.退出登录(System.exit(0))
     */
    public class AfterLoginOption{
        public Account passwordValidation(){
            Scanner sc = new Scanner(System.in);
            System.out.println("please enter you six-digit passwd");
            String passwd = sc.next();
            if(!passwd.equals(getPasswd())){
                    throw new UserOperationException("password is incorrect");
            }
            return Account.this;
        }

        public void deposit(){
            Scanner sc = new Scanner(System.in);
            int amount;
            System.out.println("Please enter the amount to deposit(The entered amount must be a multiple of one hundred.):");
            amount = sc.nextInt();
            if(amount % 100 ==0 && amount != 0){
                Account.this.setBalance(Account.this.getBalance().add(new BigDecimal(String.valueOf(amount))));
                System.out.println("success");
                System.out.println("balance: " + Account.this.getBalance());
            }
            else{
                try{
                    throw new UserOperationException("deposit failure");
                }catch (UserOperationException e){
                    System.err.println(e.getMessage());
                }
            }
        }

        public void withdraw(){
            Scanner sc = new Scanner(System.in);
            int amount;
            System.out.println("Please enter the amount to withdraw(The entered amount must be a multiple of one hundred.):");
            amount = sc.nextInt();
            try {
                if ((new BigDecimal(String.valueOf(amount)).compareTo(Account.this.balance)) == -1)
                    throw new UserOperationException("Insufficient Balance");
                if (amount % 100 == 0 && amount != 0) {
                    Account.this.setBalance(Account.this.getBalance().add(new BigDecimal(String.valueOf(amount))));
                    System.out.println("success");
                    System.out.println("balance: " + Account.this.getBalance());
                }
                else{
                    Account.this.setBalance(Account.this.getBalance().add(new BigDecimal(String.valueOf(amount))));
                    System.out.println("success");
                    System.out.println("balance: " + Account.this.getBalance());
                }
            }catch(UserOperationException e){
                System.err.println(e.getMessage());
            }
        }

        public void closeAccount(){

        }

        public void transfer(){

        }

        public void updatePasswd(){

        }

        public void exit(){

        }
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static class AccountBuilder{
        private String cardNumber;
        private String passwd;
        private String name;
        private String gender;
        private BigDecimal balance = BigDecimal.ZERO;

        public AccountBuilder cardNumber(String cardNumber){
            this.cardNumber = cardNumber;
            return this;
        }
        public AccountBuilder passwd(String passwd){
            this.passwd = passwd;
            return this;
        }
        public AccountBuilder name(String name){
            this.name = name;
            return this;
        }
        public AccountBuilder gender(String gender){
            this.gender = gender;
            return this;
        }
        public AccountBuilder balance(BigDecimal balance){
            this.balance = balance;
            return this;
        }

        public Account build(){
            return new Account(cardNumber, passwd, name, gender, balance);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNumber='" + cardNumber + '\'' +
                ", passwd='" + passwd + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", balance=" + balance +
                '}';
    }
}
