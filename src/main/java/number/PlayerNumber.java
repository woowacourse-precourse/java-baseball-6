package number;

import java.util.List;

public class PlayerNumber {
    private static final int PLAYER_NUMBER_SIZE = 3;

    private List<Integer> number;

    public PlayerNumber(List<Integer> number) {
        validateNumberSize(number);
        validateDuplicateNumber(number);
        this.number = number;
    }

    public List<Integer> getPlayerNumber() {
        return number;
    }

    private void validateNumberSize(List<Integer> number) {
        if(number.size() != PLAYER_NUMBER_SIZE) {
            throw new IllegalArgumentException("권장되는 자릿수의 숫자를 입력하지 않았습니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> number) {
        if(number.size() != number.stream().distinct().count()) {
            throw new IllegalArgumentException("입력한 숫자 중 중복되는 요소가 있습니다.");
        }
    }
}
