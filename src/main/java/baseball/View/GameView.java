package baseball.View;

public class GameView {
    /**
     * Veiw는 Model에만 의존해야 하고, Controller에는 의존하면 안된다.
     * Model로 부터 데이터를 받을때는, 사용자마다 다르게 보여주어야하는 데이터에 대해서만 받아야한다.
     * 우리는근데 유저마다 다를게 없기에 의존하지 않는다는 원칙을 따른다.
     */
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
