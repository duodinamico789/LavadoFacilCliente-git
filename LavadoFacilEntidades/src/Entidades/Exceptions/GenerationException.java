package Entidades.Exceptions;

public class GenerationException extends Exception {
    
    public GenerationException() {
    }

    public GenerationException(String string) {
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
