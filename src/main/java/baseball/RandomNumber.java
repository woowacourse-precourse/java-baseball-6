package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class RandomNumber {
    public ArrayList<Integer> ComputerNumber () {
        ArrayList<Integer> computernumber = new ArrayList<>();


        while (computernumber.size() < 3) {
            int randoms = Randoms.pickNumberInRange(1,9);
            if (!computernumber.contains(randoms)) {
                computernumber.add(randoms);
            }
        }

        return computernumber;
    }

}