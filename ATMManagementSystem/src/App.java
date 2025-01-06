import java.util.Scanner;

/**
 * @Author : eatfi
 * @Date : 2024/12/11 14:29
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM anATM = ATM.getAnATM();
        OptionEnum enterOption = OptionEnum.EXIT;

        //Account.AccountBuilder anAccountBuilder = new Account.AccountBuilder();

        while(true){
            System.out.println("enter your option");

            try {
                //异常抛出信息不能修改
                enterOption = OptionEnum.valueOf(sc.nextLine().toUpperCase());
                switch(enterOption){
                    case LOGIN -> anATM.userLogin();
                    case OPEN_ACCOUNT ->anATM.openAnAccount();
                    case SHOW -> anATM.showAllAccounts();
                    case EXIT -> System.out.println("exit");
                    default -> System.out.println("default out");
                }
            }catch(RuntimeException e){
                System.err.println(e.getMessage());
            }
            //写这里会有运行错误，因为enterOption可能会因为异常而获取不到更新
//            switch(enterOption){
//                case LOGIN -> anATM.userLogin();
//                case OPEN_ACCOUNT ->anATM.openAnAccount();
//                case SHOW -> anATM.showAllAccounts();
//                case EXIT -> System.out.println("exit");
//                default -> System.out.println("default out");
//            }
        }
    }
}
