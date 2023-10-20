package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Computer computerNumbers = new Computer();

        Print.printGameStart();
        boolean threeStrike;
        do {
            Print.printInputNumber();
            String input = Console.readLine();
            Player playerNumbers = new Player(input);

            Hint hint = new Hint(computerNumbers.getComputer(), playerNumbers.getPlayerNumbers());
            Print.printHint(hint);
            threeStrike = isThreeStrike(hint.getStrike());
        } while(!threeStrike);

        Print.printGameWin();
    }

    private static boolean isThreeStrike(int strike) {
        return strike == 3;
    }
}
