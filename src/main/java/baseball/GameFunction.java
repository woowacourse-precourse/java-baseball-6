package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameFunction {
    public static List<Integer> createRandomnumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
        //System.out.println(computer);
    }

    public static void gametry(String num) throws IllegalArgumentException{
        List<Integer> computerNum = createRandomnumber();
        if(num.length() != 3) throw new IllegalArgumentException();
        int firstNum = num.indexOf(0);
        int SecondNum = num.indexOf(1);
        int ThirdNum = num.indexOf(2);
        int firstComputerNum = computerNum.get(0);
        int secondComputerNum = computerNum.get(1);
        int thirdComputerNum = computerNum.get(2);
        //System.out.println(firstNum  + SecondNum + ThirdNum + firstComputerNum + secondComputerNum + thirdComputerNum);
    }
}
