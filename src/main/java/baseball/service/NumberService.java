package baseball.service;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberService {

    public Number generate(){
        Number computer = new Number();
        while (computer.size() < Number.getGameSize()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
