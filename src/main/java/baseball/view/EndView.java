package baseball.view;

public class EndView {
    private static final String NUMBER_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_DESCRIPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printNumberCorrect(){
        System.out.println(NUMBER_CORRECT_MESSAGE);
    }

    public static void printGameRestartDescription(){
        System.out.println(GAME_RESTART_DESCRIPTION);
    }
}
