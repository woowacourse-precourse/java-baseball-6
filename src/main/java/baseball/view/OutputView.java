package baseball.view;

public record OutputView() {
    private static final String ALL_CLEAR_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER = "게임 종료";

    public void notifyStart() {
        System.out.println(GAME_START);
    }

    public void notifyGameResult(String result) {
        if (result == "3스트라이크") {
            System.out.println(result);
            System.out.println(ALL_CLEAR_GAME_OVER);
            return;
        }

        System.out.println(result);
    }

    public void notifyEnd() {
        System.out.println(GAME_OVER);
    }
}
