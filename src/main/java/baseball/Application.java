package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int startInclusive = 1;
    public static final int endInclusive = 9;

    private static final int numLength = 3;

    public static List<Integer> splitDigitsFromRandomNumber = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        initComputerNumber();
    public static void initComputerNumber() {
        splitDigitsFromRandomNumber.clear();
        while (splitDigitsFromRandomNumber.size() < numLength) {
            //여기서 IllegalArgumentException 고려해봐야 한다.
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!splitDigitsFromRandomNumber.contains(randomNumber)) {
                splitDigitsFromRandomNumber.add(randomNumber);
            }
        }
    }
}
