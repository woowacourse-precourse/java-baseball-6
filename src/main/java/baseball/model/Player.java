package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;
    private int strikeCount = 0;
    private int ballCount = 0;


    public void init() {
        this.numbers = null;
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String number) {
        validateNumberWithPattern(number);
        validateUniqueNumber(number);

        this.numbers = stringToIntegerList(number);
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }


    public String createHintMessage() {
        StringBuilder gameResult = new StringBuilder();

        if (isNothing()) {
            return "낫싱";
        }

        if (isStrike()) {
            return strikeCount + "스트라이크";
        }

        if (isBall()) {
            gameResult.append(ballCount + "볼");
        }
        if (isStrikeWithBall()) {
            gameResult.append(" " + strikeCount + "스트라이크");
        }

        return gameResult.toString();
    }

    public boolean isCompleted() {
        return strikeCount == Rule.MAX_LENGTH;
    }

    public boolean isNothing() {
        return ballCount + strikeCount == 0;
    }

    public boolean isStrike() {
        return isCompleted() || strikeCount > 0 && ballCount == 0;
    }

    public boolean isStrikeWithBall() {
        return strikeCount > 0 && ballCount > 0;
    }

    public boolean isBall() {
        return ballCount > 0;
    }

    private void validateNumberWithPattern(String stringNumber) {
        String pattern = "^["
                + Rule.START_NUMBER
                + "-"
                + Rule.END_NUMBER
                + "]{" + Rule.MAX_LENGTH + "}$";

        if (!stringNumber.matches(pattern)) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 3개 입력해주세요.");
        }
    }

    private void validateUniqueNumber(String stringNumber) {
        int[] digitCounts = new int[10];

        for (char c : stringNumber.toCharArray()) {
            int digit = Character.getNumericValue(c);
            digitCounts[digit]++;
            if (digitCounts[digit] > 1) {
                throw new IllegalArgumentException("각 숫자는 한 번만 나와야 합니다.");
            }
        }
    }

    private List<Integer> stringToIntegerList(String stringNumber) {
        List<Integer> numberList = stringNumber.chars()
                .map(Character::getNumericValue).boxed()
                .collect(Collectors.toList());

        return numberList;
    }
}

