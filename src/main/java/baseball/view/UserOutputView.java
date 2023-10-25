package baseball.view;
import baseball.domain.GameResult;
public class UserOutputView {
    private static final String startGameMessage = "숫자 야구 게임을 시작합니다";
    private static final String strikeMessage = "스트라이크";
    private static final String ballMessage = "볼";
    private static final String nothingMessage = "낫싱";
    private static final String gameFinishMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int nothingCount = 0;
    private GameResult gameResult;
    public UserOutputView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public static void startGame() {
        System.out.println(startGameMessage);
    }

    public static void finishGame() {
        System.out.println(gameFinishMessage);
    }

    public void printDescription(){
        strike();
        ball();
        ballAndStrike();
        nothing();
    }

    private void strike(){
        if(gameResult.ballCount == nothingCount && gameResult.strikeCount != nothingCount){
            System.out.println(gameResult.strikeCount + strikeMessage);
        }
    }
    private void ball(){
        if(gameResult.ballCount != nothingCount && gameResult.strikeCount == nothingCount) {
            System.out.println(gameResult.ballCount + ballMessage);
        }
    }
    private void ballAndStrike(){
        if(gameResult.ballCount != nothingCount && gameResult.strikeCount != nothingCount){
            System.out.println(gameResult.ballCount +ballMessage +" " + gameResult.strikeCount + strikeMessage);
        }
    }
    private void nothing() {
        if(gameResult.ballCount == nothingCount && gameResult.strikeCount == nothingCount) {
            System.out.println(nothingMessage);
        }
    }
}
