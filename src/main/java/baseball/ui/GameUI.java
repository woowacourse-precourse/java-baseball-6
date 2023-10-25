package baseball.ui;

import baseball.game.NumberBaseballGame;
import baseball.util.GuessValidator;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
public class GameUI {
    private NumberBaseballGame numberBaseballGame;
    private GuessValidator guessValidator;
    private Scanner scanner;

    public GameUI(NumberBaseballGame numberBaseballGame, GuessValidator guessValidator) {
        this.numberBaseballGame = numberBaseballGame;
        this.guessValidator = guessValidator;
        scanner = new Scanner(System.in);
    }

    public String getUserGuess() {
        String guess;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            guess = Console.readLine();
            if (guessValidator.isValidGuess(guess)) {
                break;
            } else {
                throw new IllegalArgumentException("invalid input");
            }
        }
        return guess;
    }

    public void displayResult(int[] result) {
        if(result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }else if(result[0] == 0 && result[1] != 0){
            System.out.println(result[1] + "볼");
        }else if(result[0] != 0 && result[1] == 0){
            System.out.println(result[0] + "스트라이크");
        }else {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
    }

    public int askForRestart() {
        //System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        //System.out.println();
        //scanner.nextLine();
        int choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("not valid, just 2 or 1.");
            //throw new IllegalArgumentException("invalid input");
            return askForRestart();
        }
        return choice;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
