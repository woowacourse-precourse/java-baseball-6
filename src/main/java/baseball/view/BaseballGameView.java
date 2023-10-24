package baseball.view;

public class BaseballGameView {

    private static final String START_GAME_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final String NOTHING_STRING = "낫싱";
    private static final String BALL_STRING = "볼 ";
    private static final String STRIKE_STRING = "스트라이크 ";
    private static final String GAME_END_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGamePrint(){
        System.out.println(START_GAME_STRING);
    }

    public void readNumPrint(){
        System.out.print(INPUT_STRING);
    }

    public void nothingResultPrint(){
        System.out.print(NOTHING_STRING);
    }

    public void ballResultPrint(int ball){
        System.out.print(ball + BALL_STRING);
    }

    public void strikeResultPrint(int strike){
        System.out.print(strike + STRIKE_STRING);
    }

    public void endGamePrint(){
        System.out.println(GAME_END_STRING + "\n" + GAME_RESTART_STRING);
    }
}
