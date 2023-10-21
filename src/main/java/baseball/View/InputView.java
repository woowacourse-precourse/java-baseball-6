package baseball.View;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHECK_RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printNumberRequest(){
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printGameEnd(){
        System.out.println(GAME_END_MESSAGE);
        System.out.println(CHECK_RESTART_GAME_MESSAGE);
    }
}
