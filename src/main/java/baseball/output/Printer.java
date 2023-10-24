package baseball.output;

public class Printer {
    public void printResult(String compareResultString) {
        System.out.println(compareResultString);
    }

    public void printGameStartingSentence() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGettingPlayerBallsSentence() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameEndingSentence() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printAskForNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
