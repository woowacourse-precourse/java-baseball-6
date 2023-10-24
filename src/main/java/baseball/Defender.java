package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Defender {
    private static final StringBuilder target = new StringBuilder();

    // 정답 생성 - 3자리 숫자
    public static void reroll() {
        target.setLength(0);
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        for (int i = 0; i < 3; i++) {
            target.append(temp.get(i));
        }
    }

    public static boolean isBall(String answer, int i) {
        char currentChar = answer.charAt(i);
        String number = String.valueOf(currentChar);
        int indexOfTargetChar = target.indexOf(number);

        return (indexOfTargetChar != -1 && indexOfTargetChar != i);
    }

    public static boolean isStrike(String answer, int i) {
        return (answer.charAt(i) == target.charAt(i));
    }
}
