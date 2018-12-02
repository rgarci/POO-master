package bank.Exceptions;

public class FullCustomersCapacityException extends RuntimeException{
    public FullCustomersCapacityException(){
        super("La capacidad de clientes está al tope");
    }
}
