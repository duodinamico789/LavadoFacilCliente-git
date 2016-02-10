package Entidades.Exceptions;

public class PersistenciaException extends Exception {
    private Exception innerException;
    
    public PersistenciaException() {
    }

    public PersistenciaException(String string, Exception inner) {
        super(string);
        innerException = inner;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
}
