package baseball.numGame.baseballGame;

import baseball.game.Printer;

public class BaseballPrinter implements Printer {
    @Override
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    @Override
    public void printReplayMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGuessNumMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

}
