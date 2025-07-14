package model.exceptions;

public class DomainException extends Exception {
    private static final long serializableUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }
}
