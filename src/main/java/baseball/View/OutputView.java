package baseball.View;

import java.util.List;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String COMPUTER_NUMBERS_MESSAGE = "컴퓨터 숫자: ";
    private static final String GAME_WON_MESSAGE = "3개의 숫자를 모두 맞혔습니다! 게임 종료";
    private static final String GAME_OVER_MESSAGE = "게임 종료";
    private static final String GAME_EXIT_MESSAGE = "게임을 종료합니다.";

    public void displayGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void displayComputerNumbers(List<Integer> computerNumbers) {
        System.out.print(COMPUTER_NUMBERS_MESSAGE);
        System.out.println(computerNumbers);
    }

    public void displayGameResult(int balls, int strikes) {
        StringBuilder resultMessage = new StringBuilder();

        if (balls > 0) {
            resultMessage.append(balls + "볼 ");
        }

        if (strikes > 0) {
            resultMessage.append(strikes + "스트라이크 ");
        }

        if (strikes == 0 && balls == 0) {
            resultMessage.append("낫싱");
        }

        System.out.println(resultMessage.toString());
    }

    public void displayGameEndMessage(boolean isGameWon) {
        System.out.println(isGameWon ? GAME_WON_MESSAGE : GAME_OVER_MESSAGE);
    }

    public void displayGameExitMessage() {
        System.out.println(GAME_EXIT_MESSAGE);
    }
}
