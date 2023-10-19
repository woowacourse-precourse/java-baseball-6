package baseball;

public class Application {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.play();


    }

}
