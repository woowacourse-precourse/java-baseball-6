package baseball.view;
import baseball.model.GameResult;
public class UserOutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int NOTHING_COUNT = 0;
    private GameResult gameResult;
    public UserOutputView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public static void startGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void finishGame() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    public void printDescription(){
        strike();
        ball();
        ballAndStrike();
        nothing();
    }

    private void strike(){
        if(gameResult.ballCount == NOTHING_COUNT && gameResult.strikeCount != NOTHING_COUNT){
            System.out.println(gameResult.strikeCount + STRIKE_MESSAGE);
        }
    }
    private void ball(){
        if(gameResult.ballCount != NOTHING_COUNT && gameResult.strikeCount == NOTHING_COUNT) {
            System.out.println(gameResult.ballCount + BALL_MESSAGE);
        }
    }
    private void ballAndStrike(){
        if(gameResult.ballCount != NOTHING_COUNT && gameResult.strikeCount != NOTHING_COUNT){
            System.out.println(gameResult.ballCount + BALL_MESSAGE +" " + gameResult.strikeCount + STRIKE_MESSAGE);
        }
    }
    private void nothing() {
        if(gameResult.ballCount == NOTHING_COUNT && gameResult.strikeCount == NOTHING_COUNT) {
            System.out.println(NOTHING_MESSAGE);
        }
    }
}
