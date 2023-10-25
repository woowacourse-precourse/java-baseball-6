package baseball;

import baseball.player.Opponent;
import baseball.player.User;
import java.util.List;

public class Game {

    private final Opponent opponent;
    private final User user;
    private final Score score;
    InputValidator inputValidator;
    StringPrinter stringPrinter;
    InputReader inputReader;
    NumbersManager numbersManager;

    public Game() {
        opponent = new Opponent();
        user = new User();
        score = new Score();
        inputValidator = InputValidator.getInstance();
        stringPrinter = StringPrinter.getInstance();
        inputReader = InputReader.getInstance();
        numbersManager = NumbersManager.getInstance();
    }

    public void newGame(){
        while(true){
            // empty each lists instead of creating new object on new game
            user.emptyList();
            opponent.emptyList();
            play();

            // below process start upon user's win
            stringPrinter.printEndOfGame();
            int endInput = inputReader.getFinishedGameInput();

            // end loop on input number 2
            if (endInput == 2) {
                break;
            }
        }
    }

    private void play() {
        do {
            setUserNumbers();
            setOpponentNumbers();
            score.setScore(user, opponent);

            int ballCounter = score.getBallCounter();
            int strikeCounter = score.getStrikeCounter();

            stringPrinter.printGuessResult(ballCounter, strikeCounter);
        } while (!isOver());
    }

    // set opponent's numbers
    private void setOpponentNumbers(){
        List<Integer> numbers = opponent.getNumbers();
        opponent.setNumbers(numbersManager.setOpponentNumbers(numbers));
    }

    // set user's numbers
    private void setUserNumbers(){
        List<Integer> numbers = user.getNumbers();
        stringPrinter.printPlayerInput();
        int inputNumber = inputReader.getGuessInput();
        numbers.clear();
        user.setNumbers(numbersManager.setUserNumbers(numbers, inputNumber));
    }

    // game ending condition
    private boolean isOver(){
        int strikeCounter = score.getStrikeCounter();
        return strikeCounter == 3;
    }
}