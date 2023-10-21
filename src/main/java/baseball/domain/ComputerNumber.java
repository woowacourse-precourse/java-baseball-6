package baseball.domain;

import baseball.dto.NumDto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private int len;
    private List<Integer> numberList;

    public ComputerNumber(int len) {
        this.len = len;
    }

    public void createNewNum() {
        List<Integer> tempNumbers = new ArrayList<>();
        while (tempNumbers.size() < this.len) {
            int randomNum = Randoms.pickNumberInRange(1,9);
            if (!tempNumbers.contains(randomNum)) {
                tempNumbers.add(randomNum);
            }
        }
        this.numberList = tempNumbers;
    }

    public NumDto convert2Dto() {
        return new NumDto(this.numberList);
    }
}
