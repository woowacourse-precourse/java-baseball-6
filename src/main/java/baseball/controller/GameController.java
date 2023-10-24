package baseball.controller;


import baseball.model.Game;
import baseball.model.Validator;
import java.util.List;
import java.util.Scanner;


public class GameController {
    private final Validator validator;
    private final Game game;

    public GameController() {
        this.validator = new Validator();
        this.game = new Game();

    }

    public void run() {
        boolean isContinue = true;
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();
        List<Integer> computer = game.generateComputersNumber();

        while (isContinue) {
            try {
                String userInput = sc.nextLine();
                validator.validateUserInput(userInput);
                List<Integer> userGuess = validator.splitNumbersByDigits(Integer.parseInt(userInput));
                List<Integer> result = game.calculateResult(userGuess, computer);

                System.out.println("Result: " + result + ", User Guess: " + userGuess + ", Computer: " + computer);

                if (result.get(1) == 3) {
                    isContinue = !isContinue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

}