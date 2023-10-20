package baseball.View;

public class GameView {
    public void displayWelcomeMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayResult(int ball, int strike) {
        String returnString = "";
        if (ball != 0)
            returnString = ball + "볼 ";
        if (strike != 0)
            returnString += strike + "스트라이크";
        if (ball == 0 && strike == 0)
            returnString = "낫싱";
        System.out.println(returnString);
    }

    public void displayGameOverMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void displayPrompt() {
        System.out.println("숫자를 입력해주세요 : ");
    }

}
