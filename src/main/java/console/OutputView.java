package console;

public class OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String USER_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void gameStart(){
        System.out.println(GAME_START);
    }

    public void inputNumber(){
        System.out.print(INPUT_NUMBER);
    }

    public void checkCount(int strikeCount, int ballCount){
        if (strikeCount == 0 && ballCount == 0){
            System.out.println(NOTHING);
            return;
        }
        if (strikeCount == 0){
            System.out.println(ballCount + BALL);
            return;
        }
        if (ballCount == 0){
            System.out.println(strikeCount + STRIKE);
            return;
        }
        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE );
    }

    public void userCorrect(){
        System.out.println(USER_CORRECT);
        System.out.println(NEW_GAME_OR_EXIT);
    }
}