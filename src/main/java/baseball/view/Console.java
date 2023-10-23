package baseball.view;

import baseball.view.constant.GameResult;

import java.text.MessageFormat;

public class Console {

    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return input.read();
    }

    public String getRestartCode() {
        return input.read();
    }

    public void printStartMessage() {
        output.print("숫자 야구 게임을 시작합니다.");
    }

    public void printEndMessage() {
        output.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartMessage() {
        output.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGameResult(int strikeCount, int ballCount) {
        GameResult result = GameResult.from(strikeCount, ballCount);

        switch (result) {
            case NOTHING -> output.print("낫싱");
            case BALL -> output.print(ballCount + "볼");
            case STRIKE -> output.print(strikeCount + "스트라이크");
            case OTHER -> output.print(MessageFormat.format("{0}볼 {1}스트라이크", ballCount, strikeCount));
        }
    }

}
