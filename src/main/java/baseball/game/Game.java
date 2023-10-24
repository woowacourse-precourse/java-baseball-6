package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Player player;
    private Computer computer;
    private State state;

    public Game(Computer c, Player p) {
        computer = c;
        player = p;
    }

    public void start(boolean isStart) {
        if (isStart) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            start(false);
        } else if (input.equals("2")) {

        } else {
            throw new IllegalArgumentException("입력 받은 값이 유효하지 않습니다.");
        }
    }
}
