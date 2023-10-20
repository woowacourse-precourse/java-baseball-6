package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    private static final String LENGTH_EXCEPTION_MSG = "3자리의 수를 입력해주세요.";
    private static final String DUPLICATE_EXCEPTION_MSG = "각 자리 수는 중복이 불가합니다.";
    private static final String RANGE_EXCEPTION_MSG = "각 자리 수는 1~9 사이의 숫자만을 사용 가능합니다.";
    private static final String OPTION_EXCEPTION_MSG = "재실행을 하려면 1을, 종료하려면 2를 입력해주세요.";

    //사용자가 입력한 3개의 수에 대한 입력 처리
    public static void validateNumbers(List<Integer> input){
        if(input.size() != 3){
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MSG);
        }else {
            Set<Integer> removeDuplicate = new HashSet<>(input);
            if(removeDuplicate.size() != 3){
                throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MSG);
            }
        }
        for(int i=0; i<input.size(); i++){
            if(input.get(i) == 0){
                throw new IllegalArgumentException(RANGE_EXCEPTION_MSG);
            }
        }
    }

    //사용자가 입력한 게임 재실행 여부에 대한 입력 처리
    public static void validateOption(String input){
        if(input.equals(1) || input.equals(2)){
            throw new IllegalArgumentException(OPTION_EXCEPTION_MSG);
        }
    }

}
