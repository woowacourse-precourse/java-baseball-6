package baseball;

import java.util.List;

public class Game {
    private Player player = new Player();
    private Computer computer = new Computer();

    public void start() {
        System.out.println(Constants.startState);
        game();
    }

    public void game() {
        computer.makeNumberSet();
        while (true) {
            System.out.print(Constants.inputState);
            List<Integer> input = player.getGameInput();
            String result = computer.makeResult(input);
            System.out.println(result);
            if (result.equals(Constants.gameClearState)) {
                end();
                break;
            }
        }
    }

    public void end() {
        System.out.println(Constants.endState);
        System.out.println(Constants.restartState);
        String input = player.getRestartInput();
        if (input.equals(Constants.gameEndState)) {
            return;
        }
        if (input.equals(Constants.gameRestartState)) {
            game();
        }
    }
}
