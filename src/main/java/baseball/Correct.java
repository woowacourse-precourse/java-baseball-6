package baseball;

import java.util.ArrayList;
import java.util.List;

/*  -> (1) 상대방의 수 만들기: generateComputerNumber() OK,
    -> (2) 사용자의 입력을 받는 기능: inputUserNumber() OK,
        2-1) 스트라이크인지 확인하는 기능 isStrike(),
        2-2) 볼인지 확인하는 기능 isBall(),
        2-3) 결과를 출력하는 기능 outputResult()
    -> (3) 게임을 시작하고 종료하는 기능 startEndGame(),
        3-1) 종료 후 재시작 여부를 확인하는 기능 isRestart() OK
    -> (4) 사용자의 입력이 숫자인지 확인하는 기능 isDigit() OK,
        4-1) 사용자의 입력이 3자리 숫자인지 확인하는 기능 isThree() OK,
        4-2) 사용자가 입력한 숫자 중 동일한 숫자가 없는지 확인하는 기능
             isDupilcate() OK */
public class Correct {
    Correct () {};
    public boolean isDigit(String userInput) {
        try {
            List<Integer> integerList = new ArrayList<>();
            String[] userInputArray = userInput.split("");
            for(String s : userInputArray) {
                if(Integer.parseInt(s) < 1 || Integer.parseInt(s) > 9) {
                    return false;
                }
                integerList.add(Integer.parseInt(s));
            }
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
    public boolean isThree(String userInput) {
        return userInput.length() == 3;
    }
    public boolean isDuplicate(List<Integer> userInput) {
        for (Integer original : userInput) {
            int duplicateCount = 0;
            for (Integer compare : userInput) {
                if(original.equals(compare)) {
                    duplicateCount++;
                }
            }
            if(duplicateCount > 1) {
                return false;
            }
        }
        return true;
    }
    public boolean isRestart(int number) {
        return number == 1;
    }
}
