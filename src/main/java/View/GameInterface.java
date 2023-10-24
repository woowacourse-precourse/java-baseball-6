package View;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

import Constant.ExceptionHandling;
import Constant.Ment;

public class GameInterface {
    //수정
    public static void PrintResult(int strike, int ball, boolean judge) {
        if (judge) {
            System.out.println(Ment.Nothing);
            return;
        }
        System.out.println(ball + Ment.Ball + strike + Ment.Strike);
    }

    public static void PrintGameStart() {
        System.out.println(Ment.MentStart);
    }

    public static boolean GameClear(int strike) {
        if (strike == 3) {
            System.out.println(Ment.MentClear);
            return true;
        }
        return false;
    }

    public static boolean GameRestart() {
        System.out.println(Ment.MentRestart);
        int choice = Integer.valueOf(readLine());
        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            return false;
        }
        ExceptionHandling.ExceptionNotOneTwo();
        return false;
    }

    public static String InputNumbers() {
        System.out.printf(Ment.MentInput);
        String Tempnumbers = readLine();
        ExceptionHandling.ExceptionNotNumber(Tempnumbers);
        return Tempnumbers;
    }
}
