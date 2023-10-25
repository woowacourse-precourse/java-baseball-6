package baseball.view;

public class OutputView {

    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }
    public static void printInputNumberMessage(){
        System.out.println(INPUT_PLAYER_NUMBER_MESSAGE);
    }

    public static void printRestartMessage(){
        System.out.println(INPUT_RESTART_MESSAGE);
    }

}
