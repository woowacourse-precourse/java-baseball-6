package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class BaseballGame {
    static final int MAX_NUMBER = 9;
    static final int MIX_NUMBER = 1;

    public void GameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        List<Integer> userNumber;
        GameStart();
        System.out.print("숫자를 입력해주세요: ");
        String userInput = Console.readLine();
        changeNumber(userInput);
        userNumber = changeIntegerList(userInput);


    }

    public void changeNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
    }

    public List<Integer> changeIntegerList(String userInput){
        String[] strList = userInput.split("");
        List<Integer> userNumber = new ArrayList<>();

        for(String digitStr : strList) {
            try{
                int digit = Integer.parseInt(digitStr);
                userNumber.add(digit);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
            }
        }
        return userNumber;
    }

}