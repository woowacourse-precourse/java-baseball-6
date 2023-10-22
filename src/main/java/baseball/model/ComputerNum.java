package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    private static final int MAX_Length = 3;
    private final List<Integer> computerNum = new ArrayList<>();

    public ComputerNum(){
        initComputerNum();
    }

    public void initComputerNum() {
        computerNum.clear();
    }

    public void createComputerNum() {
        while(this.computerNum.size() < MAX_Length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!this.computerNum.contains(randomNumber)) {
                this.computerNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNum() {
        return this.computerNum;
    }
}
