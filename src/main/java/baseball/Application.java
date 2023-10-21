package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumber randomNumber = new RandomNumber();
        System.out.println(randomNumber.number);
        PlayerInput playerInput = new PlayerInput();
        System.out.println(playerInput.inputNumber);
    }
}
