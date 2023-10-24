package baseball;

public class Shell {
    private Shell() {

    }

    public static void run() {
        Game game = new Game();

        Logs.start();

        while (!game.isTerminated()) {
            game.setComputerNumbers();

            while (!game.isEnded()) {
                Logs.inputNumbers();
                game.inputPersonNumbers();
                game.playball();
                Logs.result(game.getResult());
            }

            Logs.end(game.getResult()[1]);
            Logs.checkTermination();
            game.inputTermination();
        }

        Logs.terminate();
    }
}
