package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> numbers = new ArrayList<>();

    public User() {
    }

    public void addNumber(int num){
        this.numbers.add(num);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static String input(){
        return Console.readLine();
    }
}
