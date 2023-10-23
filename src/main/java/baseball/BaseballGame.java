package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BaseballGame {

    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String INPUT_MESSAGE = "숫자를 입력해주세요: ";
    static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private int strike;
    private int ball;
    private final Computer computer;

    public BaseballGame(){
        computer = new Computer();
    }

    public void play() {
        List<Integer> userNumber;
        System.out.println(START_MESSAGE);
        computer.generationRandomNumber();
        while(strike < Computer.NUMBER_SIZE) {
            System.out.print(INPUT_MESSAGE);
            String userInput = Console.readLine();
            changeNumber(userInput);
            userNumber = changeIntegerList(userInput);
            numberVaildation(userNumber);
            duplicateValidation(userNumber);
            sizeVaildation(userNumber);

            strike = computer.strikeCount(userNumber);
            ball = computer.ballCount(userNumber);

            totalCount();

        }
        System.out.println(END_MESSAGE);
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

    public void totalCount(){
        StringBuilder stringBuilder = new StringBuilder();
        if(ball != 0) {
            stringBuilder.append(ball).append("볼 ");
        }
        if(strike != 0) {
            stringBuilder.append(strike).append("스트라이크");
        }
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(stringBuilder);
    }

}