package baseball.validation;

import baseball.constants.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationPlayerNumber {

    public List<Integer> changeListNumber(String playerNumberString) { // 플레이어가 입력한 문자열을 숫자로 바꿔주는 메서드
        List<Integer> playerNumber = Arrays.stream(playerNumberString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return playerNumber;
    }

    private boolean isNumber(String str) { // 입력한 문자열이 숫자인지 아닌지 검증하는 메서드. 숫자면 true, 아니면 false
        boolean result = true;
        // null, 공백일시
        if (str == null || str.isEmpty()) {
            result = false;
        }
        // null이나 공백이 아닐시
        else if (!str.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                int c = (int) str.charAt(i); // 아스키 변환
                // 숫자가 아니라면
                if (c < 48 || c > 57) {
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean validatePlayerNumber(String stringInput) { // 플레이어가 입력한 값이 옳은지 검증하는 메서드
        List<Integer> input = changeListNumber(stringInput);

        if (!isNumber(stringInput)) { // 숫자가 아니라면
            return true;
        }
        if (input.size() != Constants.INPUT_LENGTH) {
            return true; // 입력된 숫자가 3자리가 아닐 경우에 true 반환 --> 오류를 발생시키기 위함
        }

        if (input.get(0).equals(input.get(1)) || input.get(0).equals(input.get(2)) || input.get(1)
                .equals(input.get(2))) {
            return true; // 입력된 값에 중복된 숫자가 있을 경우 true 반환 --> 오류를 발생시키기 위함
        }

        if (input.get(0).equals(0) || input.get(1).equals(0) || input.get(2).equals(0)) {
            return true; // 입력한 숫자에 0이 있으면 true 반환 --> 오류를 발생시키기 위함
        }
        return false;
    }
}
