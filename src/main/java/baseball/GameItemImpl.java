package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class GameItemImpl implements GameItem {

    @Override
    public List<Integer> computer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public void showStrikeAndBall(int strikes, int balls) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean checkForStrikes(List<Integer> numList, List<Integer> computer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDuplicated(List<Integer> numList) {
        Set<Integer> number = new HashSet<Integer>(numList);
        return number.size() != numList.size();
    }

    @Override
    public boolean validateLength(String input) {
        return input.length() != 3;
    }

}
