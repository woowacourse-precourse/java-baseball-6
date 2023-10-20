package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public List<Integer> createRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    
}
