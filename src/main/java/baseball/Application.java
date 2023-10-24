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
        if (!validation(stringNumber)) {
            throw new IllegalArgumentException();
        }
        if (stringNumber.equals("2")){
            return false;
        }
        return true;
    }

    private static boolean validation(String stringNumber) {
        boolean isNumeric = (stringNumber.length() == 1 && stringNumber.matches("[0-9]"));
        return isNumeric;
    }

}
