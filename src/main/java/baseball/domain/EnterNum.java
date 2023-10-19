package baseball.domain;

import java.util.HashSet;

public class EnterNum {
    private String enterNum;

    public void setEnterNum(String enterNum) {
        this.enterNum = enterNum;
    }

    public void validation() {
        checkLength();
        checkContainZero();
        duplicateNumCheck();
    }

    private void checkLength() {
        if (enterNum.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkContainZero() {
        if (enterNum.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumCheck() {
        HashSet<Character> checkSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            checkSet.add(enterNum.charAt(i));
        }

        if (checkSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
