package baseball;

public class Game {
    private final Pitcher input = new Pitcher();
    private final Referee referee = Referee.enter();
    private Game() {}

    public static Game generate() { return new Game(); }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            matchStart(0, 0, 0);
        } while (input.restart());
    }

    private void matchStart(int a, int b, int c) {
        referee.playBall(a, b, c);
        int[] pitch, judge;
        do {
            pitch = input.pitch();
            judge = referee.judge(pitch);
        } while (judge[1] != 3);
    }
}
