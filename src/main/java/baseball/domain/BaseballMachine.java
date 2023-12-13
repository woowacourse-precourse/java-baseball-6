package baseball.domain;

import baseball.util.NumberGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballMachine {
    private static List<Integer> machine;

    private BaseballMachine(List<Integer> machine) {
        this.machine = machine;
    }

    public static BaseballMachine of(List<Integer> machine) {
        return new BaseballMachine(machine);
    }

    public static void printMachineNumber() {
        System.out.println(machine.toString());
    }

    public int strikeCount(final List<Integer> numbers) {
        return (int) IntStream.range(0, Math.min(machine.size(), numbers.size()))
                .filter(i -> machine.get(i).equals(numbers.get(i)))
                .count();
    }

    public int ballCount(final List<Integer> numbers) {
        return (int) machine.stream()
                .filter(num -> numbers.contains(num) && machine.indexOf(num) != numbers.indexOf(num))
                .count();
    }

    public boolean hasAllMatched(final List<Integer> numbers) {
        return IntStream.range(0, Math.min(machine.size(), numbers.size()))
                .allMatch(i -> machine.get(i).equals(numbers.get(i)));
    }

    public void updateNumber() {
        this.machine = NumberGenerator.generateRandomNumbers();
    }
}
