/**
 * @Author : eatfi
 * @Date : 2024/12/11 16:54
 */
public class UserOperationException extends RuntimeException{
    public UserOperationException(){super();}
    public UserOperationException(String message){
        super(message);
    }
}
