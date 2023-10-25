package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            baseballGame.inputUserNumber();

            baseballGame.countAndShow();

            if (!baseballGame.checkAndRestart()) {
                break;
            }
        }
    }
}
