package bank.Exceptions;


public class CustomerNotExistentException extends RuntimeException{
    public CustomerNotExistentException(){
        super("El cliente solicitado no existe");
    }
}
