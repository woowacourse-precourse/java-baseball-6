package baseball.validation;

import baseball.constants.constants;

import java.util.List;

public class validationPlayerNumber {
    public static boolean validatePlayerNumber(List<Integer> input){ // 플레이어가 입력한 값이 옳은지 검증하는 메서드
        if (input.size() != constants.INPUT_LENGTH) {
            return true; // 입력된 숫자가 3자리가 아닐 경우에 true 반환 --> 오류를 발생시키기 위함
        }

        if (input.get(0) == input.get(1) || input.get(0) == input.get(2) || input.get(1) == input.get(2)){
            return true; // 입력된 값에 중복된 숫자가 있을 경우 true 반환 --> 오류를 발생시키기 위함
        }

        if (input.get(0) == 0 || input.get(1) == 0 || input.get(2) == 0){
            return true; // 입력한 숫자에 0이 있으면 true 반환 --> 오류를 발생시키기 위함
        }
        return false;
    }

}
