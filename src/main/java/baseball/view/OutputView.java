package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE ="숫자 야구 게임을 시작합니다.";
    private static final String GAME_COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void startGame(){
        System.out.println(GAME_START_MESSAGE);
    }
    public static void gameComplete(){
        System.out.println(GAME_COMPLETE_MESSAGE);
    };
    public static void printBallCount(String ballCount){
        System.out.println(ballCount);
    }
}
