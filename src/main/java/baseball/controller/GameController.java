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

    public void gameModule(Scanner sc) {
        System.out.println("게임 시작");
        List<Integer> computer = game.generateComputersNumber(); // 게임이 시작할 때마다 컴퓨터의 숫자를 생성
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            String userInput = sc.nextLine();
            validator.validateUserInput(userInput);

            List<Integer> userGuess = validator.splitNumbersByDigits(Integer.parseInt(userInput));
            List<Integer> result = game.calculateResult(userGuess, computer);

//            System.out.println("Result: " + result + ", User Guess: " + userGuess + ", Computer: " + computer);

            if (result.get(1) == 3) {
                System.out.println("3스트라이크");
                isThreeStrike = true;
            } else if (result.contains(0) == false) {
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
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
        do {
            gameModule(sc);
            isContinue = game.retryHandler(sc);
        } while (isContinue == true);

//        boolean isContinue = true;
//        Scanner sc = new Scanner(System.in);
//        Validator validator = new Validator();
//
//        while (isContinue) {
//            List<Integer> computer = game.generateComputersNumber(); // 게임이 시작할 때마다 컴퓨터의 숫자를 생성
//
//            boolean roundFinished = false;
//            while (!roundFinished) {
//                try {
//                    String userInput = sc.nextLine();
//                    validator.validateUserInput(userInput);
//                    List<Integer> userGuess = validator.splitNumbersByDigits(Integer.parseInt(userInput));
//                    List<Integer> result = game.calculateResult(userGuess, computer);
//
////                    System.out.println("Result: " + result + ", User Guess: " + userGuess + ", Computer: " + computer);
//
//                    if (result.get(1) == 3) {
//                        System.out.println("3스트라이크");
//                        roundFinished = true; // 이 라운드를 끝내고 사용자에게 게임을 계속할지 묻는다.
//                    } else if (result.contains(0) == false) {
//                        System.out.printf("%d볼 %d스트라이크\n", result.get(0), result.get(1));
//                    } else if (result.contains(0) && result.get(0) != 0) {
//                        System.out.printf("%d볼\n", result.get(0));
//                    } else if (result.contains(0) && result.get(1) != 0) {
//                        System.out.printf("%d스트라이크\n", result.get(1));
//                    } else {
//                        System.out.println("낫싱");
//                    }
//
//                } catch (IllegalArgumentException e) {
//                    System.out.println(e);
//                    isContinue = false;
//                    throw e;
//                }
//            }
//
//            if (!game.retryHandler()) { // 사용자가 다시 시작을 원하지 않으면 게임을 종료한다.
//                isContinue = false;
//            }
//        }

        System.out.println("게임 종료");
    }


}
