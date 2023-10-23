package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        startBaseball();

        System.out.println("게임 종료");
    }

    public static void startBaseball() {
        String continueBaseball = "1";

        while (continueBaseball.equals("1")) {
            List<Integer> answerNumberList = createBaseballAnswerNumberList();
            playBaseball(answerNumberList);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueBaseball = Console.readLine();
        }
    }

    private static List<Integer> createBaseballAnswerNumberList() {
        List<Integer> answerNumberList = new ArrayList<>();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        return answerNumberList;
    }

    private static void playBaseball(List<Integer> answerNumberList) {
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

    private static List<Integer> inputBaseballNumberList() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validateBaseballNumbers(inputString);
        return parseIntegerList(inputString);
    }

    private static void validateBaseballNumbers(String inputString) {
        validateInputLength(inputString);
        validateInputContentRange(inputString);
    }

    private static void validateInputLength(String inputString) {
        if (inputString == null || inputString.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리 숫자만 가능합니다.");
        }
    }

    private static void validateInputContentRange(String inputString) {
        for (int i = 0; i < 3; i++) {
            char c = inputString.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("각 자리는 1~9사이의 숫자로 입력해야 합니다.");
            }
        }
    }

    private static List<Integer> parseIntegerList(String inputString) {
        List<Integer> baseballNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            baseballNumberList.add(inputString.charAt(i) - '0');
        }

        return baseballNumberList;
    }

    private static BaseballCount checkBaseballResult(List<Integer> answerNumberList, List<Integer> inputNumberList) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean isCorrect = answerNumberList.get(i) == inputNumberList.get(j);
                if (isCorrect) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        return new BaseballCount(strike, ball);
    }

    private static void printBaseballResult(BaseballCount baseballCount) {
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
