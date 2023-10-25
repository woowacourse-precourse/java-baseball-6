package baseball;

import baseball.hint.Hint;

public class Output {
    Hint strikeHint = Hint.STRIKE;
    Hint ballHint = Hint.BALL;
    Hint nothingHint = Hint.NOTHING;

    public void printStartingMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printNothingMessage() {
        System.out.print(nothingHint.getHint());
    }

    public void printBallMessage(int ballCount) {
        System.out.print(ballCount + ballHint.getHint() + " ");
    }

    public void printStrikeMessage(int strikeCount) {
        System.out.print(strikeCount + strikeHint.getHint());
    }

    public void printFinishMessage() {
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
