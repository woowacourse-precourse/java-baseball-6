package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {

    private List<Integer> numList;

    public Numbers() {
        this.numList = new ArrayList<>();
    }

    public void makeNumbersFromString(String data) {
        numList.clear();
        int numData = Integer.parseInt(data);
        while (numData > 0) {
            this.numList.add(numData % 10);
            numData /= 10;
        }
        Collections.reverse(numList);
    }

    public void makeRandomNumbers() {
        numList.clear();
        while (numList.size() < 3) {
            addUniqueRandomNum(1, 9);
        }
    }

    public NumbersDto toDto() {
        return new NumbersDto(
                numList
        );
    }

    public static int isContainNumWithDiffPos(NumbersDto oriDto, NumbersDto compDto, int pos) {
        int num = compDto.numList().get(pos);
        if (oriDto.numList().contains(num) && oriDto.numList().get(pos) != num) {
            return 1;
        }
        return 0;
    }

    public static int isContainNumWithSamePos(NumbersDto oriDto, NumbersDto compDto, int pos) {
        int num = compDto.numList().get(pos);
        if (oriDto.numList().contains(num) && oriDto.numList().get(pos) == num) {
            return 1;
        }
        return 0;
    }

    private void addUniqueRandomNum(int min, int max) {
        int tmp = Randoms.pickNumberInRange(min, max);
        if (!numList.contains(tmp)) {
            numList.add(tmp);
        }
    }
}
