package baseball;

import java.util.List;

public class Game {

    private InputValue inputValue = new InputValue();
    private OutputValue outputValue = new OutputValue();

    private List<Integer> computerNumber;
    private List<Integer> userNumber;
    private Number computer;
    private Number user;

    private boolean exit = false;
    private int strike = 0;
    private int ball = 0;

    public void Game() {}

    public void gameStart() {

        computer = new Number();
        computer.randomNumberGenerator();
        computerNumber = computer.getNumber();

        user = new Number();

        outputValue.startMessage();

        while(!exit) {
            String inputNumber = inputValue.inputAnswer();
            user.userNumberGenerator(inputNumber);
            userNumber = user.getNumber();

            resetScore();
            calculateScore();

            outputValue.resultMessage(strike, ball);

            clearCheck();

        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void calculateScore() {
        for(int i = 0; i < 3; i++) {
            int selectNumber = userNumber.get(i);
            if(computerNumber.get(i) == selectNumber) {
                strike++;
                continue;
            }

            if(computerNumber.contains(selectNumber)) {
                ball++;
            }
        }
    }

    private void clearCheck() {
        if(strike == 3) {
            if(inputValue.restartCheck()) {
                computer.randomNumberGenerator();
                computerNumber = computer.getNumber();
            } else {
                exit = true;
            }
        }
    }

}
