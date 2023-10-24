package baseball.game;

public class Game {

    private Player player;
    private Computer computer;
    private State state;

    public Game(Computer c, Player p) {
        computer = c;
        player = p;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        state = State.PROGRESS;
        playGame();
    }

    public void playGame() {
        // TODO: 숫자 야구 게임 로직 추가
    }

    public void end() {
        // TODO: 숫자 야구 게임 종료 로직 추가
    }

    public void restart() {
        // TODO: 게임 재시작 로직 추
    }
}
