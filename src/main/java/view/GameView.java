package view;

public class GameView {

    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String REGANE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameView() {

    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputNumbersMessage() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
    }

    public void printEndMessage() {
        String message = String.join("\n",END_MESSAGE,REGANE_MESSAGE);
        System.out.println(message);
    }

    public void printCountMessage(int[] ballStrike) {
        String ball = ballStrike[0] + BALL;
        String strike = ballStrike[1] + STRIKE;
        if(ballStrike[0] > 0 && ballStrike[1] > 0) {
            System.out.println(String.join(" ",ball,strike));
        }else if(ballStrike[0] == 0 && ballStrike[1] > 0) {
            System.out.println(strike);
        }else if(ballStrike[0] > 0 && ballStrike[1] == 0) {
            System.out.println(ball);
        }else if(ballStrike[0] == 0 && ballStrike[1] == 0) {
            System.out.println(NOTHING);
        }
    }


}
