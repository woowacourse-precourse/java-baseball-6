package baseball;

public class Game {
    public void start() {
        boolean replay = true;
        boolean restart = false;
        Player player = new Player();
        Computer computer = new Computer();

        Output.printStartMessage();

        do {
            computer.setRandomNumber();
            while (replay) {
                replay = play(computer, player);
            }
            Output.printWinMessage();
            Output.printRestartMessage();
            restart = Restart.inputRestartMenu();
            replay = true;
        } while (restart);
    }

    public boolean play(Computer computer, Player player) {
        Output.printInputMessage();
        player.inputPlayerNumber();
        Score score = new Score(computer.number, player.number);
        Output.printScoreMessage(score.printScore());
        if (score.strike == 3) return false;
        return true;
    }
}
