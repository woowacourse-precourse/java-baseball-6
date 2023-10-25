package baseball;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Comparison {

    private final List<Integer> matchValue;

    public Comparison(List<Integer> computer, List<Integer> player) {

        int duplicationValue = (int) computer.stream()
                .filter(o -> player.stream().anyMatch(Predicate.isEqual(o)))
                .count();

        matchValue = IntStream.range(0, computer.size())
                        .filter(i -> computer.get(i).equals(player.get(i)))
                        .mapToObj(computer::get)
                        .toList();

        if (duplicationValue == 0 && matchValue.size() == 0)
            System.out.println("낫싱");

        else if (matchValue.size() > 0 && duplicationValue == matchValue.size())
            System.out.println(matchValue.size() + "스트라이크");

        else if (matchValue.size() == 0)
            System.out.println(duplicationValue + "볼");

        else
            System.out.println(duplicationValue - matchValue.size() + "볼 " + matchValue.size() + "스트라이크");
    }

    public List<Integer> getMatchValue() {
        return matchValue;
    }
}
