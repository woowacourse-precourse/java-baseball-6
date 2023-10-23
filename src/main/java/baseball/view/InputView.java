package baseball.view;

import baseball.exception.InvalidExitException;
import baseball.exception.InvalidPickException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    InvalidPickException invalidPickException = new InvalidPickException();
    InvalidExitException invalidExitException = new InvalidExitException();

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printAskInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }
    public void printAskGameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public String[] inputNumber() {
        String picks = Console.readLine();
//        invalidPickException.checkValidInput(picks);
        String[] picksToArray = picks.split("");
        return picksToArray;
    }

    public String askGameEnd() {
        String gameRestart = Console.readLine();
//        invalidExitException.checkValidChoice(gameRestart);
        return gameRestart;
    }
}
