package baseball.controller;

import baseball.model.BaseballGameCounts;
import baseball.model.BaseballGameCountsMessage;
import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.GameView;
import baseball.view.InputView;

public class BaseballGame {
    private final ComputerNumber computer;

    protected BaseballGame() {
        this.computer = new ComputerNumber();
    }

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public void run() {
        // 게임 시작 전 게임 시작 메시지 출력
        GameView.printGameStartMessage();

        while (true) {
            // 유저 번호를 입력 받음
            UserNumber user = new UserNumber(InputView.getUserInput());
            // 입력받은 유저 번호를 컴퓨터 번호하고 비교하여 카운트 생성
            BaseballGameCounts baseballGameCounts = new BaseballGameCounts(computer, user);
            // 카운트에 기반한 메시지 출력
            GameView.printBaseballGameCountsMessage(new BaseballGameCountsMessage(baseballGameCounts));

            if (baseballGameCounts.isWinCondition()) {
                // 승리조건 달성 시 승리 메시지 출력
                GameView.printGameWinMessage();
                // 승리 시 반복문 종료
                break;
            }
        }
    }
}