package baseball.view;

import java.text.MessageFormat;

public class ConsoleOutput implements Output{

    @Override
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void printGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        }
        if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        System.out.println(MessageFormat.format("{0}볼 {1}스트라이크", ballCount, strikeCount));
    }

}
