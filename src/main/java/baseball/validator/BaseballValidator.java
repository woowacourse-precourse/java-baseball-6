package baseball.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballValidator {
    //stream을 최대한 사용해서 구현하기
    private static final Integer BASEBALL_SIZE = 3;
    private static final Integer START_BASEBALL = 1;
    private static final Integer END_BASEBALL = 9;

    private static final String GAP ="";

    private static final String SIZE_EXCEPTION ="3개의 숫자를 입력해야 합니다.";
    private static final String DUPLICATE_EXCEPTION ="중복된 숫자를 입력할 수 없습니다.";
    private static final String RANGE_EXCEPTION ="1부터 9까지의 숫자만 입력할 수 있습니다.";
    private static final String NUMBER_EXCEPTION ="숫자만 입력할 수 있습니다.";


    protected boolean validator(List<Integer> baseball){
        return sizeValidator(baseball) && duplicateValidator(baseball) && rangeValidator(baseball);
    }
    //3개의 숫자인지 검증하는 메소드
    private boolean sizeValidator(List<Integer> baseball) {
        if(baseball.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
        return true;
    }

    //중복되는 숫자가 있는지 검증하는 메소드
    private boolean duplicateValidator(List<Integer> baseball){
        if(baseball.stream().distinct().count() != BASEBALL_SIZE){
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
        return true;
    }

    //1~9까지인지 확인 anyMatch는 적어도 하나의 요소만 일치하는지 확인
    private boolean rangeValidator(List<Integer> baseball){
        if(baseball.stream().anyMatch(ball -> ball < START_BASEBALL || ball > END_BASEBALL)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION);
        }
        return true;
    }


}
