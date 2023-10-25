package baseball.controller;

import baseball.model.UserNumberDto;

import java.util.ArrayList;
import java.util.List;

import static baseball.controller.InputException.judgeValidNumberInput;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static baseball.utility.Constants.NUMBER_LIMIT_LENGTH;

public class User {
    private List<Integer> userNumbers;
    private String userInput;
    private UserNumberDto userNumberDto;

    //생성자
    public User(){
        userNumbers = new ArrayList<>(3);
        userNumberDto = new UserNumberDto();
    }

    public UserNumberDto readUserNumberInput(){
        clearUserNumbersList(); //사용자 입력 리스트 초기화

        userInput = readLine();
        judgeValidNumberInput(userInput); //입력값 적합성 판단

        for(int i = 0; i < NUMBER_LIMIT_LENGTH; i++){
            userNumbers.add(userInput.charAt(i) - '0'); //사용자가 입력한 숫자 문자열을 문자단위로 나누어 Integer 리스트에 대입
        }

        userNumberDto.setUserNumber(userNumbers); //model DTO에 담아 다른 클래스로 넘겨주기

        return userNumberDto;
    }

    private void clearUserNumbersList(){
        userNumbers.clear();
    }
}
