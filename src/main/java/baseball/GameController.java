
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameController {

    private List<Integer> computer;
    private String input;
    private boolean isStarted;
    private final GameView gameView;
    private final GameModel gameModel;
    public GameController() {

        this.gameView= new GameView();
        this.gameModel = new GameModel();
        gameView.printMessage(GameModel.START_MESSAGE);
    }
    public void run() {
        isStarted = true;

        do {
            generateComputerNumber();
            play();
        } while (isStarted);

        gameView.printMessage(GameModel.END_MESSAGE);
    }

    public void play() {
        gameView.printMessage(GameModel.ASK_NUMBERS);
        input = Console.readLine();
        checkAnswer(input);
    }

    public void isStarted(String input) {
        if (input.equals("1")) {
           isStarted = true;
        } else if (input.equals("2")) {
            isStarted = false;
        }
    }

    public void generateComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void checkAnswer(String input) {
        validateInput(input);

        List<Integer> answer = convertInputToList(input);

        int strike = calculateStrikes(answer);
        int ball = calculateBalls(answer);

        printResult(strike, ball);
    }

    private void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            answer.add(input.charAt(i) - '0');
        }
        return answer;
    }

    private int calculateStrikes(List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == computer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBalls(List<Integer> answer) {
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (!answer.get(i).equals(computer.get(i)) && computer.contains(answer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private void printResult(int strike, int ball) {
       displayResult(strike, ball);

        if (strike == 3) {
            endGame();
        } else {
            continueGame();
        }
    }

    private void displayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            gameView.printMessage(GameModel.NOTHING);
        } else if (strike == 0) {
            gameView.printMessage(ball + GameModel.BALL);
        } else if (ball == 0) {
            gameView.printMessage(strike + GameModel.STRIKE);
        } else {
            gameView.printMessage(ball + "볼 " + strike + "스트라이크");
        }
    }

    private void endGame() {
        isStarted = false;
        gameView.printMessage(GameModel.ASK_RESTART);
        input = Console.readLine();
        isStarted(input);
    }

    private void continueGame() {
        gameView.printMessage(GameModel.ASK_NUMBERS);
        input = Console.readLine();
        checkAnswer(input);
    }
}

