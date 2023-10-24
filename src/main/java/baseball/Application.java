package baseball;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final View view = new View();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            Game g = new Game(view);
            g.start();
        } while(isProgress());

    }

    private static boolean isProgress() {
        view.printRestartCheckMessage();
        String stringNumber = Console.readLine();
        validateOneOrTwo(stringNumber);
        if (stringNumber.equals("2")){
            return false;
        }
        return true;
    }

    private static void validateOneOrTwo(String stringNumber) {
        if (!(stringNumber.equals("1") || stringNumber.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

}
