package baseball.model;

import java.util.*;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int COMPUTER_NUMBERS_SIZE = 3;
    private final List<Integer> computer;

    public Computer(List<Integer> computer) {
        validateSize(computer);
        validateDuplicate(computer);
        validateIsNumber(computer);
        this.computer = computer;
    }
    public List<Integer> getComputer() {
        return Collections.unmodifiableList(computer);
    }

    private void validateSize(List<Integer> computer){
        if (computer.size() != COMPUTER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("컴퓨터는 3가지 숫자만 받아야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> computer) {
        Set<Integer> duplicateNumbers = new HashSet<>(computer);
        if (duplicateNumbers.size() != COMPUTER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("컴퓨터가 선택한 숫자는 중복될 수 없습니다.");
        }
    }

    private void validateIsNumber(List<Integer> computer) {
        String pattern = "^[0-9]*$";
        boolean containsNonNumber = computer.stream()
                .map(val -> Pattern.matches(pattern, val.toString()))
                .anyMatch(matchResult -> !matchResult);
        if (containsNonNumber) {
            throw new IllegalArgumentException("숫자들만 선택할 수 있습니다.");
        }
    }
}
