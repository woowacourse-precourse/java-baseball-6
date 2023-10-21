package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.startMessage();
        while(true) {
            Game game = new Game();
            game.game();

            Scanner s = new Scanner(System.in);
            String retryCheckNumber = Console.readLine();
            if(retryCheckNumber.equals("2")) {
                break;
            }
        }
    }
}
