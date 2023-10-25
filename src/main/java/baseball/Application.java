package baseball;

import baseball.models.Computer;
import baseball.models.Game;
import baseball.models.Hint;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Computer computer = new Computer();

        game.init();

        while(game.isStatus()) {
            computer.chooseNumber(game.NUM_LENGTH);

            boolean isCorrect = false;
            while(!isCorrect) {
                String playerGuess = game.askForGuess();
                Hint hint = computer.giveHint(playerGuess);
                System.out.println(hint.toString());

                if (hint.getStrikeCnt() == game.NUM_LENGTH) {
                    isCorrect = true;
                    game.askForRestart();
                }
            }
        }

        game.exit();
    }
}
