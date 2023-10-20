package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static void createComputerNum(List<Integer> computerNum){
        while(computerNum.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNumber)){
                computerNum.add(randomNumber);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Start Number Baseball Game!");

        List<Integer> computerNum = new ArrayList<>();
        String personNum;

        createComputerNum(computerNum);

    }
}
