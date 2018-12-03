package bank.Exceptions;

public class CouldNotReadBankTextException extends RuntimeException {
    public CouldNotReadBankTextException(){
        super("Ha ocurrido un problema al leer el archivo Bank");
    }
}
