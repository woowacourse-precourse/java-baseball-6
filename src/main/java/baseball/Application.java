package baseball;

public class Application {
    private static final String START_COMMENT = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_COMMENT);

        Game.playGame();
    }
}
