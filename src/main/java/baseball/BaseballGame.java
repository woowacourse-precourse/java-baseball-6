package baseball;

import baseball.Computer.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BaseballGame {

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
        numberVaildation(userNumber);
        duplicateValidation(userNumber);
        sizeVaildation(userNumber);
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

    public void numberVaildation(List<Integer> userNumber){
        for(Integer number : userNumber) {
            if(number > Computer.MAX_NUMBER || number < Computer.MIX_NUMBER){
                throw new IllegalArgumentException("숫자가 범위를 벗어났습니다.");
            }
        }
    }

    public void duplicateValidation(List<Integer> userNumber){
        Set<Integer> numberSet = new HashSet<>(userNumber);

        if(numberSet.size() != userNumber.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void sizeVaildation(List<Integer> userNumber){
        if(userNumber.size() != Computer.NUMBER_SIZE){
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

}