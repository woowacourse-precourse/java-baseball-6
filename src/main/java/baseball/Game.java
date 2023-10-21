package baseball;

public class Game {
    private final Pitcher input = new Pitcher();
    private Referee referee = Referee.enter();
    private Game() {}

    public static Game generate() { return new Game(); }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            int[] numbers = input.pitch();


        } while (input.restart());
    }
}
