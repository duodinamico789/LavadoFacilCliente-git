package Entidades.Exceptions;

public class StoredProcedureException extends Exception {
    
    public StoredProcedureException() {
    }

    public StoredProcedureException(String string) {
        super(string);
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
