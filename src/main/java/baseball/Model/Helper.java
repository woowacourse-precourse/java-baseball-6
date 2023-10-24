package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    /**
     * Model은 Controller와 View에 관련된 코드가 있으면 안된다!!!!!!
     */
    private static final int BASEBALL_NUM_SIZE = 3;

    public List<Integer> generatorComputerNumber(int baseballNumSize) {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < baseballNumSize) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
        return computerNumber;
    }

    public List<Integer> parseUserInput(String input) {
        List<Integer> parsedInput = new ArrayList<>();

        if (input.length() != BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("입력 자릿 수 오류");
        }

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            char c = input.charAt(i);
            if (c == '0') {
                throw new IllegalArgumentException("허가되지 않은 문자열");
            }
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                parsedInput.add(digit);
            }
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("허가되지 않은 문자열");
            }

        }

        return parsedInput;
    }


}