package baseball.member;

import baseball.controller.BaseballGameController;
import baseball.view.InputView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumbers {
    private final List<Integer> playerNumbers;

    public PlayerNumbers() {
        this.playerNumbers = createPlayerNumbers();
    }

    public List<Integer> getPlayerNumbers() {
        List<Integer> clonedPlayerNumbers = new ArrayList<>(playerNumbers);
        return Collections.unmodifiableList(clonedPlayerNumbers);
    }

    public Integer getPlayerNumberAtIndex(int index) {
        return getPlayerNumbers().get(index);
    }

    private List<Integer> createPlayerNumbers() {
        String inputValue = InputView.inputPlayerNumbers();
        checkValidValue(inputValue);
        return convertStringToIntegerList(inputValue);
    }

    private void checkValidValue(String inputValue) {
        if(!(isNumeric(inputValue) && isZeroNotIncluded(inputValue)
        && isValidDigit(inputValue) && isNotDuplicate(inputValue))) {
            throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
        }
    }

    private boolean isNumeric(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }

    private boolean isZeroNotIncluded(String inputValue) {
        return !inputValue.contains("0");
    }

    private boolean isValidDigit(String inputValue) {
        return inputValue.length() == BaseballGameController.GAME_NUMBER_DIGIT;
    }

    private boolean isNotDuplicate(String inputValue) {
        return inputValue.chars()
                .distinct()
                .count() == inputValue.length();
    }

    private List<Integer> convertStringToIntegerList(String inputValue) {
        return inputValue.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
