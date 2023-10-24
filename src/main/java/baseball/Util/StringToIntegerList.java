package baseball.Util;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerList {

    /**
     * 문자열 형태의 사용자 입력을 숫자 리스트로 변환한다.
     *
     * @param userInput 문자열 형태의 입력값
     * @return 숫자 리스트
     */
    public List<Integer> stringToIntegerList(String userInput) {
        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            int number = userInput.charAt(i) - '0';
            userNumber.add(number);
        }

        return userNumber;
    }
}
