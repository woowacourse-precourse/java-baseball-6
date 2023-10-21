package baseball;

public class Game {
    private final Input input = new Input();
    private Game() {}

    public static Game generate() { return new Game(); }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            int[] numbers = input.userInput();


        } while (input.restart());
    }
}
