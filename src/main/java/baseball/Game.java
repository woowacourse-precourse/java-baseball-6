package baseball;

import java.util.List;

public class Game {
    private static final String WIN_MESSAGE = "3스트라이크";

    public void start() {
        boolean restart = false;
        Player player = new Player();
        Computer computer = new Computer();

        Output.printStartMessage();

        do {
            computer.setRandomNumber();
            process(computer, player);
            Output.printWinMessage();
            Output.printRestartMessage();
            restart = Restart.inputRestartMenu();
        } while (restart);
    }

    private void process(Computer computer, Player player) {
        boolean replay = true;
        while (replay) {
            replay = play(computer, player);
        }
    }

    private boolean play(Computer computer, Player player) {
        String result;
        Output.printInputMessage();
        player.inputPlayerNumber();
        result = setResult(computer, player);
        Output.printScoreMessage(result);
        return !result.equals(WIN_MESSAGE);
    }

    private String setResult(Computer computer, Player player) {
        List<Integer> answer = computer.number;
        Score score = new Score(answer, player.number);
        return score.printScore();
    }
}
