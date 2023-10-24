package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    private String computerNum = "";

    public String getComputerNum() {
        return computerNum;
    }

    public void setComputerNum(String computerNum) {
        this.computerNum = computerNum;
    }

    public ComputerNum() {
        CreateRandomNum();
    }

    private void CreateRandomNum() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (String item : computer) {
            this.computerNum += item;
        }
    }
}
