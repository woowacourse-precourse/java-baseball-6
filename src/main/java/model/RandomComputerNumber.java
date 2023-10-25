package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomComputerNumber {
    private final ArrayList<Integer> computerPick = new ArrayList<>();

    public void setComputerPick() {
        computerPick.clear();
        initComputerPickList();
    }

    public ArrayList<Integer> getComputerPickList() {
        return this.computerPick;
    }

    public void initComputerPickList() {
        while (computerPick.size() < 3) {
            int computerRandomPick = Randoms.pickNumberInRange(1, 9);
            if (!computerPick.contains(computerRandomPick)) {
                computerPick.add(computerRandomPick);
            }
        }
    }


}
