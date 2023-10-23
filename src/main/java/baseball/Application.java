package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
//      List<Integer> computer = createComputerNumber();
//      System.out.println(computer);
    }

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BASEBALL_SIZE = 3;

    //랜덤 숫자 생성 기능
    private static List<Integer> createComputerNumber(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < BASEBALL_SIZE){
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
            if(!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
        return numbers;
    }

    private static List<Integer> playerInputNum(){
        return Arrays.stream(Console.readLine().split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
