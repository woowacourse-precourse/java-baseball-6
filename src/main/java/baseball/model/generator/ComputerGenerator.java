package baseball.model.generator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerGenerator extends NumberGenerator {

    @Override
    public List<Integer> generateList() {
        return convertToList();
    }

    @Override
    protected List<Integer> convertToList() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < LIST_SIZE) {
            int number = pickNumberInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE);
            if (!isDuplicatedNumber(list, number)) {
                list.add(number);
            }
        }
        System.out.println("ComputerGenerator " + list);
        return list;
    }

    private boolean isDuplicatedNumber(final List<Integer> randomNumberList, final int number) {
        return randomNumberList.contains(number);
    }
}
