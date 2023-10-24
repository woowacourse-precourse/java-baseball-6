package baseball.controller;


import baseball.domain.Computer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LogicController {
    private Computer computer ;
    private static Map<String,Integer> scoreboard;
    public LogicController() {
        this.computer = Computer.getInstance();
    }
    public static Map<String,Integer> getScoreboard() {
        if (scoreboard == null) {
            scoreboard = new HashMap<>();
        }
        return scoreboard;
    }
    public Boolean judge(String userInput){
        scoreboard = getScoreboard();
        scoreboard.put("ball",0);
        scoreboard.put("strike",0);
        int[] computerNumber = convertStringToIntArray(computer.getComputerNumber());
//        System.out.println(Arrays.toString(computerNumber));
        int[] userNumber = convertStringToIntArray(userInput);
        for (int i = 0; i < computerNumber.length; i++) {
            if (computerNumber[i] == userNumber[i]) scoreboard.put("strike",scoreboard.get("strike")+1);
            for (int j = 0; j < computerNumber.length ; j++) {
                if ((i!=j) & (computerNumber[i] == userNumber[j])) scoreboard.put("ball",scoreboard.get("ball")+1);
            }
        }
        if(scoreboard.get("strike")==3)return true;
        return false;
    }
    public static int[] convertStringToIntArray(String numbersString) {
        int[] numbers = new int[numbersString.length()];
        for (int i = 0; i < numbersString.length(); i++) {
            char digitChar = numbersString.charAt(i);
            numbers[i] = Character.getNumericValue(digitChar);
        }
        return numbers;
    }
}
