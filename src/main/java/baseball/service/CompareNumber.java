package baseball.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompareNumber {

    public void checkNothing(List<Integer> computer, List<Integer> player) {
        List<Integer> result = computer.stream()
                .filter(val -> player.stream().anyMatch(Predicate.isEqual(val)))
                .collect(Collectors.toList());
        if (result.size() == 0) {
            System.out.println("낫싱");
        }
    }
}
