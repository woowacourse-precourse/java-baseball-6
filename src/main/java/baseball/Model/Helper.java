package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    /**
     * Model은 Controller와 View에 관련된 코드가 있으면 안된다!!!!!!
     */

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

    /**
     * 유저가 입력한 String형식의 Input을 List형식으로 파씽함
     */
    public List<Integer> parseUserInput(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}