package baseball.view;

public class ComputerView implements View {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Override
    public void renderView() {
        System.out.println(GAME_START_MESSAGE);
    }
}
