package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.BaseballGameCounts;
import baseball.model.BaseballGameCountsMessage;
import baseball.model.ComputerNumber;
import baseball.model.UserNumber;

public class BaseballGame {
    private final ComputerNumber computer;
    private UserNumber user;

    protected BaseballGame() {
        this.computer = new ComputerNumber();
    }

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            this.getUserInput();

            BaseballGameCounts baseballGameCounts = BaseballGameCounts.createBaseballGameCounts(computer, user);

            new BaseballGameCountsMessage(baseballGameCounts).printMessage();

            if (baseballGameCounts.isWinCondition()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return;
            }

            baseballGameCounts.resetCounts();

            user.resetUserNumber();
        }
    }

    private void getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        this.user = new UserNumber(userInput);
    }
}