package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static int askToContinue() {
        int choice = Integer.parseInt(Console.readLine());
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
        return choice;
    }

    public static void main(String[] args) {
        int choice;
        do {
            playBaseBall();
            choice = askToContinue();
        } while(choice == 1);
    }
}
