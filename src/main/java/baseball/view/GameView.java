package baseball.view;

public class GameView {
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼";
    private static final String STARTING_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_STRING = "숫자를 입력해 주세요 : ";
    private static final String GAME_SET_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startBoot() {
        System.out.println(STARTING_STRING);
    }


    public void inputMessage() {
        System.out.print(INPUT_STRING);
    }

    public void gameSetView() {
        System.out.println(String.format(STRIKE, 3));
        System.out.println(GAME_SET_STRING);
        System.out.println(RESTART_STRING);
    }

    public void strikeBallView(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(BALL, ball))
                .append(" ")
                .append(String.format(STRIKE, strike));

        System.out.println(sb);
    }

    public void strikeView(int strike) {
        System.out.println(String.format(STRIKE, strike));
    }

    public void ballView(int ball) {
        System.out.println(String.format(BALL, ball));
    }

    public void nothing() {
        System.out.println("낫싱");
    }
}
