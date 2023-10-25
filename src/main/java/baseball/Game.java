package baseball;

import java.util.List;

public class Game {
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

    public void process(Computer computer, Player player) {
        boolean replay = true;
        while (replay) {
            replay = play(computer, player);
        }
    }

    public boolean play(Computer computer, Player player) {
        String result;
        Output.printInputMessage();
        player.inputPlayerNumber();
        result = setResult(computer, player);
        Output.printScoreMessage(result);
        return !result.equals("3스트라이크");
    }

    public String setResult(Computer computer, Player player) {
        List<Integer> answer = computer.number;
        Score score = new Score(answer, player.number);
        return score.printScore();
    }
}
