package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application{

    private static List<Integer> computer = new ArrayList<>();

    public static void main(String[] args){
        startGame();
        computer = createComputerRandomNumber();
    }

    private static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> createComputerRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)){
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

}
