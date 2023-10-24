package baseball;

import java.util.HashMap;

public class Error extends Throwable {
    final public static int numLength = 3;

    final public static int GAME_STATE_CONTINUE = 1;
    final public static int GAME_STATE_END = 2;
    
    final public static int INVALID_INPUT = 10;
    final public static int INVALID_GAME_STATE = 11;

    final public static int INVALID_LENGTH = 21;
    final public static int INVALID_DIGIT = 22;
    final public static int DUPLICATED_NUMBER = 23;

    final static HashMap<Integer, String> errors = new HashMap<>(){{
        put(INVALID_INPUT, "숫자만 입력 가능합니다.");
        put(INVALID_GAME_STATE, "1과 2의 숫자만 입력 가능합니다.");
        put(INVALID_LENGTH, "입력의 길이는 " + numLength + "입니다.");
        put(INVALID_DIGIT, "숫자 1 ~ 9까지만 입력 가능합니다.");
        put(DUPLICATED_NUMBER, "중복된 숫자는 입력 불가능합니다.");
    }};

    public static void throwError(int errorCode){
        throw new IllegalArgumentException(errors.get(errorCode));
    }
}
