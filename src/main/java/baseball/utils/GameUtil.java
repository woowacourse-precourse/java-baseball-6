package baseball.utils;

import baseball.view.UserInPut;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class GameUtil {
    public ArrayList<Integer> ComputerChoiceNumber(int randomNumberLength, int start, int end) {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < randomNumberLength) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }



}
