package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.validate.Compare;
import baseball.view.Input;
import baseball.view.Output;

public class GameController {
    private Compare compare;

    public void start() {
        Output.startMessage();

        do {
            Computer computer = new Computer();
            int[] result;  // 볼과 스트라이크 개수를 저장

            do {
                String userInput = Input.userNumber();
                Player player = new Player(userInput);

                compare = new Compare(computer, player);
                result = compare.compareNumbers();

                printResult(result[0], result[1]);

            } while (result[1] != 3);

            Output.displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (isRestartGame());
    }

    private boolean isRestartGame() {
        String input = Input.restartGame();

        if ("1".equals(input)) {   // 게임 재시작
            return true;
        } else if ("2".equals(input)) {   // 게임 종료
            return false;
        } else {   // 잘못된 입력 처리
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    private void printResult(int ballCount, int strikeCount) {
        StringBuilder resultMessage = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            resultMessage.append("낫싱");
        } else  {   // 스트라이크 카운트가 3 미만일 때만 결과를 출력합니다.
            if (ballCount > 0) {
                resultMessage.append(ballCount).append("볼");
            }

            if (ballCount > 0 && strikeCount > 0) {
                resultMessage.append(" ");
            }

            if (strikeCount > 0) {
                resultMessage.append(strikeCount).append("스트라이크");
            }
        }

        Output.displayMessage(resultMessage.toString());
    }
}
