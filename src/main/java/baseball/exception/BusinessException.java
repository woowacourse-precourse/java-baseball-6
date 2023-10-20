package baseball.exception;


public class BusinessException extends RuntimeException {
    private final ExceptionCode code;
    private final Class clazz;

    public BusinessException(ExceptionCode code, Class clazz) {
        super(code.getDescription());
        this.code = code;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", class=" + clazz +
                '}';
    }
}
