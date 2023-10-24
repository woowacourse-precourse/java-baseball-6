package baseball.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public static String getNumber(int size){
        String input=Console.readLine();
        if(!isValidNumberInput(input,1,9,size)){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        return input;
    }
    public static boolean restart(String input, int restartNum, int exitNum){
        if(!isValidNumberInput(input,1,2,1)){
            throw new IllegalArgumentException("일력값이 유효하지 않습니다.");
        }
        int isRestart=Integer.parseInt(input);
        return isRestart==restartNum;
    }

    private static boolean isValidNumberInput(String input, int minNum, int maxNum, int size) {
        String pattern = "[" + minNum + "-" + maxNum + "]{" + size + "}";
        return input.matches(pattern);
    }
}
