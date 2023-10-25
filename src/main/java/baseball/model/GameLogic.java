package baseball.model;

import java.util.*;

public class GameLogic {
    private Map<String, Integer> compareResult = new HashMap<>();

    /**
     * Player의 입력 숫자를 검증하고 List에 반환하는 메서드
     *
     * @param playerGuess Player의 input을 담은 String
     * @return Player의 input을 담은 Integer 리스트
     * throws IllegalArgumentException 사용자 input이 내부 규칙에 유효하지 않을 시 발생
     */
    public List<Integer> validateAndReturnBaseBallNumber(String playerGuess) throws IllegalArgumentException {
        vaildateInputLength(playerGuess);

        List<Integer> playerGuessNumbers = new ArrayList<>();
        char[] charArr = playerGuess.toCharArray();
        for (char c: charArr) {
            validateIsNumber(c);
            int number = Character.getNumericValue(c);
            validateIsNotZero(number);
            validateNotDuplicated(number,playerGuessNumbers);
            playerGuessNumbers.add(number);
        }

        return playerGuessNumbers;
    }

    public void vaildateInputLength(String playerGuess) throws IllegalArgumentException {
        if (playerGuess.length() != 3) {
            throw new IllegalArgumentException("유효하지 않은 입력 : 3자리 숫자 입력 필요합니다.");
        }
    }

    public void validateIsNumber(char c) throws IllegalArgumentException {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("유효하지 않은 입력 : 1부터 9까지의 자연수만 입력해야 합니다.");
        }
    }

    public void validateIsNotZero(int number) throws IllegalArgumentException {
        if (number == 0) {
            throw new IllegalArgumentException("유효하지 않은 입력 : 0은 입력이 불가합니다. 1부터 9까지의 자연수만 입력해야 합니다.");
        }
    }

    public void validateNotDuplicated(int number, List<Integer> playerGuessNumbers) {
        if (playerGuessNumbers.contains(number)) {
            throw new IllegalArgumentException("유효하지 않은 입력 : 중복된 숫자 입력은 불가합니다.");
        }
    }

    /**
     * Player와 Computer의 숫자와 자리를 비교하고, 비교 결과를 Map에 반환하는 메서드
     *
     * @param playerNumbers
     * @param computerNumbers
     * @return 비교 결과를 담은 Map
     */
    public Map compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        compareResult.put("strike", 0);
        compareResult.put("balls", 0);

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (Objects.equals(playerNumbers.get(i), computerNumbers.get(i))) {
                compareResult.put("strike", compareResult.get("strike") + 1);
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                compareResult.put("balls", compareResult.get("balls") + 1);
            }
        }

        return compareResult;
    }
}
