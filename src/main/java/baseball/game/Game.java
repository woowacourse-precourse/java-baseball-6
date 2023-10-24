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
        computer.setRandomNum();
        do {
            String playerNum = player.inputNumber();
        } while (state == State.PROGRESS);

        restart();
    }

    public void end() {
        state = State.END;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restart() {
        // TODO: 게임 재시작 로직 추
    }
}
