package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import static baseball.model.Target.BALL_SIZE;

import java.util.LinkedHashSet;
import java.util.Set;


public class Input {

    public static String inputUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static int[] getIntegerArrayFromString(String userInput) {
        Set<Integer> userSet = new LinkedHashSet<>();

        for (int i = 0; i < userInput.length(); i++) {
            final String REGEX = "[1-9]+";

            if (!userInput.matches(REGEX)) {
                throw new IllegalArgumentException("숫자가 아님");
            }

            userSet.add(Character.getNumericValue(userInput.charAt(i)));
        }

        if (userSet.size() != BALL_SIZE) {
            throw new IllegalArgumentException("길이가 " + BALL_SIZE + "이(가) 아니거나 숫자가 중복됨");
        }

        int[] userNum = new int[BALL_SIZE];
        int idx = 0;
        for (int setValue : userSet) {
            userNum[idx] = setValue;
            idx++;
        }

        return userNum;
    }

    public static String inputIsExit() {
        Output.replayMessage();
        return Console.readLine();
    }

    public static void scannerClose() {
        Console.close();
    }
}
