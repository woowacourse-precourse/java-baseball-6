package baseball;

import java.util.Iterator;

public class Computer {
    private NumberArray computerNum = new NumberArray();

    public Computer() {

    }

    String checkBallorStrike(NumberArray userNum) {

        return "";
    }

    String checkIfExist(NumberArray userNum) {

        Iterator<Integer> iter = userNum.getNumList().iterator();
        while (iter.hasNext()) {
            if (!computerNum.getNumList().contains(iter.next())) {
                return "낫싱";
            }
        }
        return "";
    }


}
