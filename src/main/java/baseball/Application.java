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
//      validatePlayerNumber(playerNumber);
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


}
