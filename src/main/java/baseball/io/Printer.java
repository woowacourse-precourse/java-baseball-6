package baseball.io;

import baseball.model.Result;

public class Printer {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGetNumbersFromPlayer() {
        System.out.println("숫자를 입력해주세요: ");
    }

    public void printResult(Result result) {
        System.out.println(result.getMessage());
    }

    public void printStrikeMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printKeepPlayingMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printEndMessage() {
        System.out.println("게임을 종료합니다.");
    }
}
