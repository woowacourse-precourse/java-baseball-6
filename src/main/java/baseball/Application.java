package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> makeRandomAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void vaildUserTrialInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하세요.");
        }

        for (char c : userInput.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
            }
        }

        for (int i = 0; i < userInput.length() - 1; i++) {
            for (int j = i + 1; j < userInput.length(); j++) {
                if (userInput.charAt(i) == userInput.charAt(j)) {
                    throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요.");
                }
            }
        }
    }

    public static List<Integer> getUserTrialInput() {
        String userInput = camp.nextstep.edu.missionutils.Console.readLine(); // 항상 올바른 입력값이라고 가정함
        vaildUserTrialInput(userInput);

        List<Integer> userInputList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userInputList.add(c - '0');
        }

        return userInputList;
    }

    public static GameResult playGame(List<Integer> computer, List<Integer> userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userInput.get(i))) {
                strike++;
            } else if (computer.contains(userInput.get(i))) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }

    public static int getUserRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = camp.nextstep.edu.missionutils.Console.readLine(); // 항상 올바른 입력값이라고 가정함
        // todo: 유저 입력값 검사

        return Integer.parseInt(userInput);
    }

    public static void main(String[] args) {
        boolean gameState = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameState) {
            List<Integer> answerList = makeRandomAnswer();
            System.out.println(answerList); // debug

            while (true) {
                List<Integer> userInputList = getUserTrialInput();
                GameResult gameResult = playGame(answerList, userInputList);
                System.out.println(gameResult);

                if (gameResult.getStrike() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    if (getUserRestartInput() == 2) {
                        gameState = false;
                    }
                    break;
                }
            }
        }
        camp.nextstep.edu.missionutils.Console.close();
    }
}
