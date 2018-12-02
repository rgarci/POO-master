package bank.Exceptions;

public class NotEnoughBalanceException extends RuntimeException{
    public NotEnoughBalanceException(){
        super("El cliente no puede retirar más de lo que tiene la cuenta");
    }
}
