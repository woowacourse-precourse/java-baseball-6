package baseball;

public class Application {
    public static void main(String[] args) {
        String startPhrase = "숫자 야구 게임을 시작합니다.";
        System.out.println(startPhrase);

        boolean isFinished = false;

        while (!isFinished) {
            try {
                Game game = new Game();
                isFinished = true;
            } catch (IllegalArgumentException e) {
                break;
            }
        }
    }
}
