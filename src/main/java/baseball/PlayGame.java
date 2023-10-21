package baseball;

import java.util.Scanner;

import static baseball.NumberBaseball.baseballGame;
import static baseball.StartGame.createThreeNums;
import static baseball.UserInput.userInput;

public class PlayGame {
    public static void playGame(Scanner sc) {
        String answer = createThreeNums();
        System.out.println("answer : " + answer);

        String message = "";
        while (!message.equals("3스트라이크") ){
            String input = userInput(sc);
            message = baseballGame(input,answer);
            System.out.println(message);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");


    }
}
