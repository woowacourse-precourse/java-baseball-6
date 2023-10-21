package output;

public class OutputModule {

    private final String startGame = "숫자 야구 게임을 시작합니다.";
    private final String ball = "볼";
    private final String strike = "스트라이크";
    private final String out = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String oneMoreTime = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public OutputModule() {
    }

    public String getStartGame() {
        return startGame;
    }

    public String getBall() {
        return ball;
    }

    public String getStrike() {
        return strike;
    }

    public String getOut() {
        return out;
    }

    public String getOneMoreTime() {
        return oneMoreTime;
    }
}
