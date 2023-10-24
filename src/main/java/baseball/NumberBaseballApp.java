package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballApp{

    private final RoundManager rm = new RoundManager();

    void run(){
        while (true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            ComputerNumbers computerNumber = new ComputerNumbers(createComputerRandomNumber());
            rm.playGame(computerNumber);
            if (terminate()){
                break;
            }
        }
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

    private static boolean terminate(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exitInput = readLine();
        throwIfInvalidExitInput(exitInput);
        return exitInput.equals("2");
    }

    private static void throwIfInvalidExitInput(String exitInput){
        if (!exitInput.equals("1") && !exitInput.equals("2")){
            throw new IllegalArgumentException();
        }
    }

}
