package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        InputAndOutput text = new InputAndOutput();
        NumberBaseball baseball = new NumberBaseball();

        text.gameStart();

        boolean isGame = true;

        while (isGame) {
            int[] computerNumber = computer.computerCreateNumber();

            boolean isThreeStrike;
            do {
                text.scanInputNumber();

                String inputNum = Console.readLine();
                int[] userNumber = baseball.create(inputNum);
                isThreeStrike = baseball.playGame(computerNumber, userNumber);
            } while (isThreeStrike);

            text.gameEnd();

            String isNum = Console.readLine();
            isGame = Integer.parseInt(isNum) == 1;
        }
    }
}
