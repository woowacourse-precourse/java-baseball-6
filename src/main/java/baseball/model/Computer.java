package baseball.model;

import baseball.message.Message;

import java.util.*;

import static baseball.message.Message.*;

public class Computer {

    private final List<Integer> computer;

    public Computer(List<Integer> computer) {
        validateSize(computer);
        validateDuplicate(computer);
        validateIsNumber(computer);
        this.computer = computer;
    }
    public List<Integer> getComputer() {
        for (Integer integer : computer) {
            System.out.println(integer);
        }
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
        boolean containsNonNumber = computer.stream()
                .map(val -> val < MIN_NUMBER || val > MAX_NUMBER)
                .anyMatch(Boolean::booleanValue);
        if (containsNonNumber) {
            throw new IllegalArgumentException("컴퓨터는 숫자 이외의 값을 선택할 수 없습니다.");
        }
    }
}
