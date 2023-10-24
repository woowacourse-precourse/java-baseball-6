package baseball.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public static String getNumber(int size){
        String input=Console.readLine();
        if(!isValidNumberInput(input,size)){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        return input;
    }
    private static boolean isValidNumberInput(String input, int size) {
        String regex = "^[1-9]{" + size + "}$";
        return input.matches(regex);
    }
}
