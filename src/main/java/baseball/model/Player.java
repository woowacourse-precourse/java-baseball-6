package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class Player extends Number {
    private String input;

    public Player() {
        super();
        setInput();
        isSizeCorrect();
        putNumber();
    }

    private String getInput() {
        return this.input;
    }

    private void setInput() {
        input = Console.readLine().trim();
    }

    public void putNumber() {
        for (char i : getInput().toCharArray()) {
            int num = changeToInt(i);
            if (isContained(num)) {
                throw new IllegalArgumentException("중복 없는 숫자로 골라주세요.");
            }
            numbers.add(num);
        }
    }

    private int changeToInt(char num) {
        if (!isBetween1And9()) {
            throw new IllegalArgumentException("1-9 사이 숫자만 입력해주세요.");
        }
        return Integer.valueOf(num);
    }

    private boolean isBetween1And9() {
        return getInput().matches("^[1-9]*$");
    }

    private void isSizeCorrect() {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }


}
