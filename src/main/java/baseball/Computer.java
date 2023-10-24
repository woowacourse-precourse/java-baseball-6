package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public Picks createRandomPicks() {
        Picks randomPicks = new Picks();
        while (!randomPicks.isFull()) {
            Pick newPick = new Pick(Randoms.pickNumberInRange(1, 9));
            if (!randomPicks.contains(newPick)) {
                randomPicks.add(newPick);
            }
        }
        return randomPicks;
    }
}
