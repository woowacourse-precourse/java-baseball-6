package baseball.game;

import baseball.util.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Inning inning;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void startGame() {
        inning = new Inning();
        inning.startInning();
    }

    public boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = inputNumber();

        int inputNumber = NumberValidator.convertToNumber(input).number();
        NumberValidator.validateInput(inputNumber);

        return isRestart(inputNumber);
    }

    private boolean isRestart(int inputNumber) {
        return inputNumber == GameCommand.RESTART.getCommandValue();
    }

    private String inputNumber() {
        return Console.readLine();
    }

    public void endGame() {
        System.out.println("게임 종료");
    }
}
