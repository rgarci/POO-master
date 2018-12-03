package bank.Exceptions;

public class FullAccountsCapacityException extends RuntimeException {
    public FullAccountsCapacityException(){
        super("La capacidad el banco para almacenar cuentas está a tope");
    }
}
