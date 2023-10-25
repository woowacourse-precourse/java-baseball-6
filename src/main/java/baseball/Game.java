package baseball;

import baseball.player.Opponent;
import baseball.player.User;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Game {

    private Opponent opponent;
    private User user;
    private Score score;
    InputValidator inputValidator;
    StringPrinter stringPrinter;
    InputReader inputReader;

    public Game(Opponent opponent, User user, Score score) {
        this.opponent = opponent;
        this.user = user;
        this.score = score;
        inputValidator = InputValidator.getInstance();
        stringPrinter = StringPrinter.getInstance();
        inputReader = InputReader.getInstance();
    }

    public void newGame() throws IllegalArgumentException{
        while(true){
            // empty each lists instead of creating new object on new game
            user.emptyList();
            opponent.emptyList();
            play();

            // below process start upon user's win
            stringPrinter.printEndOfGame();
            int endInput = inputReader.getInput();

            // end loop on input number 2
            if (endInput == 2) {
                break;
            }
            // wrong input exception
            inputValidator.validateEndInput(endInput);
        }
    }

    private void play() {
        while (true) {
            setUserNumbers();
            setOpponentNumbers();
            score.setScore(user, opponent);

            int ballCounter = score.getBallCounter();
            int strikeCounter = score.getStrikeCounter();

            stringPrinter.printGuessResult(ballCounter, strikeCounter);

            if (isOver()) {
                break;
            }
        }
    }

    // set opponent's numbers
    private void setOpponentNumbers(){
        List<Integer> numbers = opponent.getNumbers();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // avoid duplicates
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        opponent.setNumbers(numbers);
    }

    // set user's numberList
    private void setUserNumbers(){
        List<Integer> numbers = user.getNumbers();
        stringPrinter.printPlayerInput();
        int inputNumber = inputReader.getInput();

        // validate 3-digit
        inputValidator.validateThreeDigit(inputNumber);

        numbers.clear();
        while (inputNumber > 0) {
            int extractedNumber = inputNumber % 10; // extract number from 1's up to 100's
            numbers.add(extractedNumber);
            inputNumber /= 10; // remove last digit
        }

        // reverse arrange list for correct order (above logic adds 1s digit first)
        Collections.reverse(numbers);
        user.setNumbers(numbers);
    }

    private boolean isOver(){
        int strikeCounter = score.getStrikeCounter();
        return strikeCounter == 3;
    }

}
