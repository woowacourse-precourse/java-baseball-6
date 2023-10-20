package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.Application.NUMBER_LENGTH;

public class GenerateRandomNumber {

    public List generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (CorrectNumberLength(computer)) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!duplicationNumber(computer, randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean CorrectNumberLength(List<Integer> computer) {
        return computer.size() < NUMBER_LENGTH;
    }

    private static boolean duplicationNumber(List<Integer> computer, int randomNumber) {
        return computer.contains(randomNumber);
    }
}
