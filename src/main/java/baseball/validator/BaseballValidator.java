package baseball.validator;

import java.util.List;

public class BaseballValidator {
    private static final Integer BASEBALL_SIZE = 3;
    private static final Integer START_BASEBALL_NUMBER = 1;
    private static final Integer END_BASEBALL_NUMBER = 9;
    private static final String SIZE_EXCEPTION_MESSAGE ="3개의 숫자를 입력해야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE ="중복된 숫자를 입력할 수 없습니다.";
    private static final String RANGE_EXCEPTION_MESSAGE ="1부터 9까지의 숫자만 입력할 수 있습니다.";
    private static final String RETRY_EXCEPTION_MESSAGE ="1 또는 2를 입력할 수 있습니다.";
    public static boolean validator(List<Integer> baseball){
        return sizeValidator(baseball) && duplicateValidator(baseball) && rangeValidator(baseball);
    }

    public static boolean restartValidator(Integer number){
        if( number != 1 && number != 2){
            throw new IllegalArgumentException(RETRY_EXCEPTION_MESSAGE);
        }
        return true;
    }

     private static boolean sizeValidator(List<Integer> baseball) {
        if(baseball.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static boolean duplicateValidator(List<Integer> baseball){
        if(baseball.stream().distinct().count() != BASEBALL_SIZE){
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static boolean rangeValidator(List<Integer> baseball){
        if(baseball.stream().anyMatch(ball -> ball < START_BASEBALL_NUMBER || ball > END_BASEBALL_NUMBER)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
        return true;
    }



}
