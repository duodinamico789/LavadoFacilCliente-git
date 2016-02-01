package Entidades.Exceptions;

public class DataAccessException extends Exception {
    
    public DataAccessException() {
    }

    public DataAccessException(String string) {
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
