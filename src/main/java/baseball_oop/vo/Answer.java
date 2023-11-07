package baseball_oop.vo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Answer implements Comparable<Answer> {
    List<Integer> values;
    private final int LENGTH_LIMIT = 3;

    public Answer() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < LENGTH_LIMIT) {
            set.add(pickNumberInRange(1, 9));
        }
        this.values = set.stream().toList();
    }


    public Answer(String input) {
        this.values = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Answer o) {
        return 0;
    }
}
