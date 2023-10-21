package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public static int[] getInputNumber(int[] answer) {
        int [] inputNum = new int[3];
        String input = Console.readLine();
        for(int i=0; i<answer.length; i++) {
            inputNum[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return inputNum;
    }
}
