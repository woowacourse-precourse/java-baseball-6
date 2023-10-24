package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Player player;
    private Computer computer;
    private GameState gameState; // 게임 상태

    private enum GameState {
        PROGRESS,
        END,
    }

    public Game(Computer _computer, Player _player) {
        computer = _computer;
        player = _player;
    }


    // 게임을 시작한다.
    public void startGame(boolean isFirst) {

        if (isFirst) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        gameState = GameState.PROGRESS;
        progressGame();
    }

    // 게임을 진행한다.
    private void progressGame() {
        // 서로 다른 임의의 수 3개를 선택한다.
        computer.setNumber();

        // 게임을 진행한다.
        while (gameState == GameState.PROGRESS) {

            // 플레이어 : 서로 다른 3자리의 수를 입력 받는다.
            String playerNumber = player.inputNumber();

            // 컴퓨터 : 플레이어에게 입력 받은 숫자에 대해서 힌트를 출력 한다.
            if (computer.printResult(playerNumber)) {
                // 플레이어의 숫자와 컴퓨터의 숫자가 일치하면 게임을 종료한다.
                endGame();
            }
        }

        // 게임이 종료되면 게임 재시작 여부를 입력 받는다.
        inputToRetry();
    }

    // 게임을 종료한다.
    private void endGame() {
        gameState = GameState.END;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    // 게임 재시작 여부를 입력 받는다.
    private void inputToRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            startGame(false);
        } else if (input.equals("2")) {
        } else {
            throw new IllegalArgumentException("입력 받은 값이 유효하지 않습니다.");
        }
    }
}
