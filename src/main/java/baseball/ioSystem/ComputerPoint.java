package baseball.ioSystem;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerPoint {
    private String computerPoint;

    public ComputerPoint() {
        setComputerPoint();

    }

    public String getComputerPoint() {
        return computerPoint;
    }

    public void setComputerPoint() {
        List<String> addComputerNum = new ArrayList<String>();
        while (addComputerNum.size() < 3) {
            String randomNumber  = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!addComputerNum.contains(randomNumber)) {
                addComputerNum.add(randomNumber);
            }
        }
        this.computerPoint = String.join("",addComputerNum);
    }
}