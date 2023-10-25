package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class Player extends Number {
    private String input;

    public Player() {
        super();
        setInput();
        validateInput();
        setNumbers();
    }

    private void validateInput() {
        isSizeCorrect();
        isBetween1And9();
    }

    private void setNumbers() {
        for (char i : getInput().toCharArray()) {
            int num = changeToInt(i);
            putNumber(num);
        }
    }

    private String getInput() {
        return this.input;
    }

    private void setInput() {
        System.out.println("숫자를 입력해주세요 : ");
        input = Console.readLine().trim();
    }

    @Override
    public boolean isContained(int number) {
        if (super.isContained(number)) {
            throw new IllegalArgumentException("중복 없는 숫자로 골라주세요.");
        }
        return super.isContained(number);
    }

    private int changeToInt(char i) {
        if (!isBetween1And9()) {
            throw new IllegalArgumentException("1-9 사이 숫자만 입력해주세요.");
        }
        return Integer.valueOf(i);
    }

    private boolean isBetween1And9() {
        return getInput().matches("^[1-9]*$");
    }

    private void isSizeCorrect() {
        if (getInput().length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
}
