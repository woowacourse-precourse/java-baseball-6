package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Human {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void setNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        this.numbers = numbers;
    }
}
