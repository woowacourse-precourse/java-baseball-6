package baseball;

import java.util.List;

public class GameRunner {

    private Computer computer;
    private Player player;

    GameRunner() {
        player = new Player();
        computer = new Computer();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startNewGame();

        while (askToStartNewGame()) {
            startNewGame();
        }
    }

    private void startNewGame() {
        computer.generateAnswer();

        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> answer = player.answer();

            if (computer.isCorrect(answer)) {
                break;
            }
        }

    }

    private boolean askToStartNewGame() {
        return switch (player.askToStartNewGame().intValue()) {
            case 1 -> true;
            case 2 -> false;
            // TODO Exception 처리
            default -> false;
        };
    }
}
