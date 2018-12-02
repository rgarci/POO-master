package bank.Exceptions;

public class AccountNotExistentException extends RuntimeException{
    public AccountNotExistentException(){
        super("La cuenta solicitada no existe");
    }
}
