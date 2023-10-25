package baseball.domain;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class Player {

    private final List<BaseballNumber> playNumber;

    public Player(){
        playNumber = new ArrayList<>();
        InputNumber();
    }

    public List<BaseballNumber> getPlayer(){

        return playNumber;
    }

    private void InputNumber(){
        String inputNum = Console.readLine();
        checkNumber(inputNum);
        for(int input = 0; input < inputNum.length(); input++) {
            playNumber.add(new BaseballNumber(inputNum.charAt(input)- '0'));
        }

        checkToDuplicate(playNumber);
    }

    private void checkNumber(String inputNum) {
        checkSize(inputNum);
        for (int digit = 0; digit < inputNum.length(); digit++) {
            if (!Character.isDigit(inputNum.charAt(digit))) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }

    private void checkToDuplicate(List<BaseballNumber> playNumber){
        Set<BaseballNumber> check = new HashSet<>(playNumber);
        if(check.size() != 3){
            throw new IllegalArgumentException("중복된 입력값 입니다.");
        }

    }
    
    private void checkSize(final String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("3개의 수만 입력하세요.");
        }
    }



}
