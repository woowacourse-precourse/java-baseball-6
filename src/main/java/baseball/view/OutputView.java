package baseball.view;

public class OutputView {
    private final static String ALL_CLEAR_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void notifyEnd(String result) {
        System.out.println(result);
        System.out.println(ALL_CLEAR_GAME_OVER);
    }
}
