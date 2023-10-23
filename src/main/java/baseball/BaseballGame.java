package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String continueBaseball = "1";
        while (continueBaseball.equals("1")) {
            List<Integer> answerNumberList = createBaseballAnswerNumberList();
            playBaseball(answerNumberList);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueBaseball = Console.readLine();
        }

        System.out.println("게임 종료");
    }

    private List<Integer> createBaseballAnswerNumberList() {
        List<Integer> answerNumberList = new ArrayList<>();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        return answerNumberList;
    }

    private void playBaseball(List<Integer> answerNumberList) {
        while (true) {
            List<Integer> inputNumberList = inputBaseballNumberList();
            BaseballCount baseballCount = checkBaseballResult(answerNumberList, inputNumberList);
            printBaseballResult(baseballCount);
            if (baseballCount.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> inputBaseballNumberList() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validateBaseballNumbers(inputString);
        return parseIntegerList(inputString);
    }

    private void validateBaseballNumbers(String inputString) {
        validateInputLength(inputString);
        validateInputContentRange(inputString);
    }

    private void validateInputLength(String inputString) {
        if (inputString == null || inputString.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리 숫자만 가능합니다.");
        }
    }

    private void validateInputContentRange(String inputString) {
        for (int i = 0; i < 3; i++) {
            char c = inputString.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("각 자리는 1~9사이의 숫자로 입력해야 합니다.");
            }
        }
    }

    private List<Integer> parseIntegerList(String inputString) {
        List<Integer> baseballNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            baseballNumberList.add(inputString.charAt(i) - '0');
        }

        return baseballNumberList;
    }

    private BaseballCount checkBaseballResult(List<Integer> answerNumberList, List<Integer> inputNumberList) {
        int strike = checkStrikeCount(answerNumberList, inputNumberList);
        int ball = checkBallCount(answerNumberList, inputNumberList);
        return new BaseballCount(strike, ball);
    }

    private int checkStrikeCount(List<Integer> answerNumberList, List<Integer> inputNumberList) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answerNumberList.get(i).equals(inputNumberList.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int checkBallCount(List<Integer> answerNumberList, List<Integer> inputNumberList) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if(answerNumberList.get(i).equals(inputNumberList.get(j))) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private void printBaseballResult(BaseballCount baseballCount) {
        if (baseballCount.getStrike() == 0 && baseballCount.getBall() == 0) {
            System.out.println("낫싱");
        } else if (baseballCount.getStrike() > 0 || baseballCount.getBall() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if (baseballCount.getBall() != 0) {
                stringBuilder.append(baseballCount.getBall()).append("볼 ");
            }
            if (baseballCount.getStrike() != 0) {
                stringBuilder.append(baseballCount.getStrike()).append("스트라이크");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }
}
