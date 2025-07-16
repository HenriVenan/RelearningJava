package exceptions;

public class DataException extends Exception {

    public DataException(String msg) {
        super("Error nas datas: " + msg);
    }
}
