package baseball.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compare {
    public String getGameResult(List<Integer> computerInput, String userInput) {
        if (!isValidInputThreeNumber(userInput)){
            throw new IllegalArgumentException("3자리의 양의 정수를 입력해야 됩니다. 사용자의 입력 : " + userInput);
        }

        if (!isValidInputDifferentNumbers(userInput)) {
            throw new IllegalArgumentException("서로 다른 양의 정수 3자리가 입력되어야 합니다. 사용자의 입력 : " + userInput);
        }

        int checkStrike = 0;
        int checkBall = 0;
        final String NOTHING = "낫싱";

        for (int i = 0; i < computerInput.size(); i++) {
            int computerNumber = computerInput.get(i);
            int userNumber = Integer.parseInt(String.valueOf(userInput.charAt(i)));

            if (computerNumber == userNumber) {
                checkStrike += 1;
            } else {
                for (int j = 0; j < computerInput.size(); j++) {
                    if (computerNumber == Integer.parseInt(String.valueOf(userInput.charAt(j)))) {
                        checkBall += 1;
                    }
                }
            }
        }
        String strikeResult = checkStrike + "스트라이크";
        String ballResult = checkBall + "볼";

        if (checkStrike == 0 && checkBall == 0) {
            return NOTHING;
        }

        if (checkStrike == 0) {
            return ballResult;
        }

        if (checkBall == 0) {
            return strikeResult;
        }

        return ballResult + " " + strikeResult;
    }

    // 3자리의 정수인지 확인
    private boolean isValidInputThreeNumber(String userInput) {
        return userInput.matches("\\d{3}");
    }

    // 서로 다른 양의 정수가 입력 되었는지 확인
    private boolean isValidInputDifferentNumbers(String userInput) {
        Stack<Integer> checkDuplication = new Stack<>();

        for (int i = 0; i < userInput.length(); i++) {
            if (!checkDuplication.contains(userInput.charAt(i))) {
                checkDuplication.push((int) userInput.charAt(i));
            }
        }

        return checkDuplication.empty();
    }
}
