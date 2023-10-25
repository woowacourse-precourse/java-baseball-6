package baseball.controller;

import baseball.model.TargetNum;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateTargetNumImpl implements GenerateTargetNum{

    public TargetNum getTargetNum(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        TargetNum targetNum= new TargetNum(computer);

        return targetNum;
    }

}
