package baseball.view;

public class OutputView {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void displayStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void displayResult(int balls, int strikes) {

        if (balls > 0 && strikes > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        } else if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        } else if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
        } else if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
        }
    }

    public void displayWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }

}
