package baseball;

import java.util.List;

public class Game {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private InputValue inputValue = new InputValue();
    private boolean exit = false;

    public void Game() {}

    public void gameStart() {

        Number computerNumber = new Number();
        computerNumber.randomNumberGenerator();
        Number userNumber = new Number();

        startMessage();

        while(!exit) {
            String inputNumber = inputValue.inputAnswer();
            userNumber.userNumberGenerator(inputNumber);

            return;
        }
    }

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

}
