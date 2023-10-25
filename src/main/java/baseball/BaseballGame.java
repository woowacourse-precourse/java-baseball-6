package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGame {

    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        return computer;
    }

    public static List<Integer> stringToList(String inputString) {
        int inputNumber = Integer.parseInt(inputString);
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            resultList.add(inputNumber % 10);
            inputNumber /= 10;
        }
        Collections.reverse(resultList);

        System.out.println("stringToList : "+resultList);
        return resultList;

    }

}
