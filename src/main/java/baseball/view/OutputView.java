package baseball.view;

public class OutputView {
    private static final String GAME_START ="숫자 야구 게임을 시작합니다.";
    private static final String GAME_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void startGame(){
        System.out.println(GAME_START);
    }
    public static void endGame(){System.out.println(GAME_EXIT_MESSAGE);};

    public static void nowBallCount(String ballCount){
        System.out.println(ballCount);
    }
}
