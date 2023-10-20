package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    public void run() {
        boolean programInProgress = true;
        while (programInProgress) {
            List<Integer> answer = getAnswer();
            noticeGameStart();

            boolean isGameInProgress = true;

            while (isGameInProgress) {
                String input = requestNumbers();
                checkValidation(input);
                List<BaseballType> types = checkTypes(input, answer);

                BaseballGameResult gameResult = new BaseballGameResult(types);
                String resultText = gameResult.makeResultText();
                noticeGameResult(resultText);

                if (gameResult.isEnded()) {
                    noticeGameEnd();
                    isGameInProgress = false;

                    String restartFlag = askRestart();
                    if (restartFlag.equals("2")) {
                        programInProgress = false;
                    }
                }
            }
        }
    }

    private void noticeGameStart() {
        View.printText("숫자 야구 게임을 시작합니다.\n");
    }

    private String requestNumbers() {
        View.printText("숫자를 입력해주세요 : ");
        String input = View.readLine();
        return input;
    }

    private void noticeGameResult(String resultText) {
        View.printText(resultText);
    }

    private void noticeGameEnd() {
        View.printText("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    private String askRestart() {
        View.printText("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = View.readLine();
        return input;
    }

    private void checkValidation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException();
            }

            if (set.contains(c)) {
                throw new IllegalArgumentException();
            }

            set.add(c);
        }
    }

    private List<BaseballType> checkTypes(String input, List<Integer> answer) {
        List<BaseballType> types = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int number = Character.getNumericValue(c);
            BaseballType type = checkType(number, i, answer);
            types.add(type);
        }

        return types;
    }

    private BaseballType checkType(int number, int index, List<Integer> answer) {
        boolean isExist = answer.contains(number);

        if (!isExist) {
            return BaseballType.OUT;
        }

        boolean isStrike = answer.get(index) == number;
        if (isStrike) {
            return BaseballType.STRIKE;
        }

        return BaseballType.BALL;
    }

    private List<Integer> getAnswer() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
