package baseball.controller;


import baseball.model.Game;
import baseball.model.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class GameController {
    private final Validator validator;
    private final Game game;

    public GameController() {
        this.validator = new Validator();
        this.game = new Game();
    }

    public void gameModule() {
        System.out.println("게임 시작");
        List<Integer> computer = game.generateComputersNumber(); // 게임이 시작할 때마다 컴퓨터의 숫자를 생성
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            String userInput = Console.readLine();
            validator.validateUserInput(userInput);

            List<Integer> userGuess = validator.splitNumbersByDigits(Integer.parseInt(userInput));
            List<Integer> result = game.calculateResult(userGuess, computer);

//            System.out.println("Result: " + result + ", User Guess: " + userGuess + ", Computer: " + computer);

            if (result.get(1) == 3) {
                System.out.println("3스트라이크");
                isThreeStrike = true;
            } else if (!result.contains(0)) {
                System.out.printf("%d볼 %d스트라이크\n", result.get(0), result.get(1));
            } else if (result.contains(0) && result.get(0) != 0) {
                System.out.printf("%d볼\n", result.get(0));
            } else if (result.contains(0) && result.get(1) != 0) {
                System.out.printf("%d스트라이크\n", result.get(1));
            } else {
                System.out.println("낫싱");
            }
        }
    }


    public void run() {
        boolean isContinue = true;
        do {
            gameModule();
            isContinue = game.retryHandler();
        } while (isContinue);

        System.out.println("게임 종료");
    }


}
