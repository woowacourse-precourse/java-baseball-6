package baseball.domain;

import baseball.view.InputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.consts.NumberConst.BASEBALL_SIZE;
import baseball.view.InputView;

public class UserInputNum {
    InputView inputView = new InputView();
    public List<String> getUserInput(){
        List<String> userInput = inputView.playerInputNumber();
        validatePlayerNumber(userInput);
        return userInput;
    }

    public static void validatePlayerNumber(List<String> playerNum){
        isDigitNumbers(playerNum);
        isThreeNumbers(playerNum);
        isRepeatedNumbers(playerNum);
        checkZero(playerNum);
    }

    //세 자리 숫자임을 검증 함수
    private static void isThreeNumbers(List<String> playerNum){
        if(playerNum.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다. 게임을 종료합니다");
        }
    }

    //중복된 값이 있는지 검증 함수
    private static void isRepeatedNumbers(List<String> playerNum){
        Set<String> numset = new HashSet<>();
        for(String num : playerNum){
            numset.add(num);
        }
        if(numset.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException("중복된 값이 존재합니다. 게임을 종료합니다.");
        }
    }

    //입력 값이 숫자인지 검증 함수
    private static void isDigitNumbers(List<String> playerNum){
        try{
            for(String number : playerNum){
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 게임을 종료합니다.");
        }
    }

    //입력 값에 0이 있는지 검증 함수
    private static void checkZero(List<String> playerNum){
        for(String number : playerNum){
            int num = Integer.parseInt(number);
            if(num == 0){
                throw new IllegalArgumentException("입력된 값에 0이 포함되어 있습니다. 게임을 종료합니다.");
            }
        }
    }
}
