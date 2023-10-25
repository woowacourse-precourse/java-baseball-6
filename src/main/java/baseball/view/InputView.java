package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    /**
     * 사용자로부터 입력받은 문자열을 List<Integer>로 변환시킴
     *
     * @param numbers : 사용자로부터 입력받은 문자열
     * @return : 입력받은 수를 List<Integer> 형식으로 반환
     */
    private List<Integer> numberInput(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length(); ++i) {
            list.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
        return list;
    }
}
