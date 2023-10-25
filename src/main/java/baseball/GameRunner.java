package baseball;

import java.util.List;

public class GameRunner {

    private Computer computer;
    private Player player;

    GameRunner() {
        player = new Player();
        computer = new Computer();
    }

    public void start() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            startNewGame();
        } while (askToStartNewGame());
    }

    private void startNewGame() throws IllegalArgumentException {
        computer.generateAnswer();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> answer = player.answer();

            if (computer.isCorrect(answer)) {
                break;
            }
        }

    }

    private boolean askToStartNewGame() throws IllegalArgumentException {
        Integer userResponse = player.askToStartNewGame();

        return switch (userResponse) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalArgumentException(); // unreachable
        };
    }
}
