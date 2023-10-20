package baseball;

import java.util.List;

public class Game {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private InputValue inputValue = new InputValue();
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    private boolean exit = false;
    private int strike = 0;
    private int ball = 0;

    public void Game() {}

    public void gameStart() {

        Number computer = new Number();
        computer.randomNumberGenerator();
        computerNumber = computer.getNumber();

        Number user = new Number();

        startMessage();

        while(!exit) {
            String inputNumber = inputValue.inputAnswer();
            user.userNumberGenerator(inputNumber);
            userNumber = user.getNumber();

            resetScore();
            calculateScore();

            return;
        }
    }

    private void startMessage() {
        System.out.println(START_MESSAGE);
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void calculateScore() {
        for(int i = 0; i < 3; i++) {
            int selectNumber = userNumber.get(i);
            if(computerNumber.get(i) == selectNumber){
                strike++;
                continue;
            }

            if(computerNumber.contains(selectNumber)){
                ball++;
            }
        }
    }
}
