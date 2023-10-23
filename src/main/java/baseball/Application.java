package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
//      List<Integer> computer = createComputerNumber();
//      System.out.println(computer);
        System.out.println("서로다른 숫자를 입력해 주세요 : ");
        List<String> playerNumber = playerInputNumber();
        validatePlayerNumber(playerNumber);
    }

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BASEBALL_SIZE = 3;

    //랜덤 숫자 생성 기능
    private static List<String> createComputerNumber(){
        List<String> numbers = new ArrayList<>();
        while(numbers.size() < BASEBALL_SIZE){
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER));
            if(!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
        return numbers;
    }

    private static List<String> playerInputNumber(){
        return Arrays.asList(
                Console.readLine()
                        .split("")
        );
    }

    private static void validatePlayerNumber(List<String> playerNum){
        isThreeNumbers(playerNum);
        isRepeatedNumbers(playerNum);
        isDigitNumbers(playerNum);
        checkZero(playerNum);
    }

    private static void isThreeNumbers(List<String> playerNum){
        if(playerNum.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다. 게임을 종료합니다");
        }
    }

    private static void isRepeatedNumbers(List<String> playerNum){
        Set<String> numset = new HashSet<>();
        for(String num : playerNum){
            numset.add(num);
        }
        if(numset.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException("중복된 값이 존재합니다. 게임을 종료합니다.");
        }
    }

    private static void isDigitNumbers(List<String> playerNum){
        try{
            for(String number : playerNum){
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 게임을 종료합니다.");
        }
    }

    private static void checkZero(List<String> playerNum){
        for(String number : playerNum){
            int num = Integer.parseInt(number);
            if(num == 0){
                throw new IllegalArgumentException("입력된 값에 0이 포함되어 있습니다. 게임을 종료합니다.");
            }
        }
    }
}
