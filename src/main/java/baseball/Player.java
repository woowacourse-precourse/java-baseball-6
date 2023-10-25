package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Player {
    public static String inputThreeNumbers() {
        String input = Console.readLine();
        int len = input.length();
        Exception.checkInputSize(len);
        Exception.checkOverlap(input, len);
        return input;
    }

    public static int inputRestartStatus() {
        String input = Console.readLine();
        int num = Utils.stringToInt(input,0);
        return num;
    }



}
