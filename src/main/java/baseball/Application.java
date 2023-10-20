package baseball;


public class Application {
    public static void main(String[] args) {
        int exitNumber;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Game game = new Game();
            Input input = new Input();

            try {
                game.playGame();
            } catch (IllegalArgumentException e) {
                break;
            }

            try {
                exitNumber = input.ExitInput();
            } catch (IllegalArgumentException e) {
                break;
            }
        } while (exitNumber == 1);
    }
}
