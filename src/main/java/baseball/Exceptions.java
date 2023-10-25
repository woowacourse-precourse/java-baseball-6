package baseball;

import java.util.Arrays;
import java.util.List;

public class Exceptions {
    private static final String NONE_NUMBER_ERROR = "숫자만 입력하세요.";
    private static final String NONE_LENGTH_ERROR = "3개 숫자만 입력하세요.";
    private static final String DUPLICATE_ERROR = "중복되지 않는 3자리의 숫자만 입력하세요.";
    private static final String OUT_OF_RANGE_ERROR = "1-9까지의 숫자만 입력하세요.";
    private static final String RESTART_ERROR = "please answer 1 or 2.";
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;

    // 숫자인지 아닌지 오류 검출
    public static void noneNumberException(String number){
        try{
            Integer.parseInt(number);
        } catch(Exception e){
            throw new IllegalArgumentException(NONE_NUMBER_ERROR);
        }
    }
    // 숫자가 3자리 인지 아닌지 판단 후 오류 검출
    public static void noneLengthException(String number){
        if(number.length() != 3){
            throw new IllegalArgumentException(NONE_LENGTH_ERROR);
        }
    }

    // 중복된 숫자가 있는지 없는지 판단 후 오류 검출
    public static void duplicateException(String number){
        String[] changedNumber = number.split("");
        if(Arrays.stream(changedNumber).distinct().count() != 3){
            throw new IllegalArgumentException(DUPLICATE_ERROR);

        }
    }

    // 입력 받은 숫자가 1-9까지 인지 아닌지 판단 후 오류 검출
    public static void outOfRangeException(String number){
        String[] changedNumber = number.split("");
        for(String n : changedNumber){
            if(Integer.parseInt(n) < MIN_NUM || Integer.parseInt(n) > MAX_NUM){
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
            }
        }
    }

    public static void restartException(String num){
        List<String> resultList = Arrays.asList("1","2");
        boolean exceptionFlag = resultList.contains(num);
        if(!exceptionFlag){
            throw new IllegalArgumentException(RESTART_ERROR);
        }
    }
}
