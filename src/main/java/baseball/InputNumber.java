package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
public class InputNumber {
    private List<Integer> numbers;
    enum Type {
        None, Ball, Strike
    }
    private boolean correct;
    private String result;

    public InputNumber(String input) {
        checkInput(input);
        setNumbers(Integer.parseInt(input));
        result = "";
    }

    private void checkInput(String input) {
        if (input.length() != 3 || !input.matches("\\d+"))
            throw new IllegalArgumentException("Invalid input");
        int number = Integer.parseInt(input);
        HashSet<Integer> set = new HashSet<>();
        while (number > 0) {
            set.add(number % 10);
            number /= 10;
        }
        if (set.contains(0) || set.size() != 3)
            throw new IllegalArgumentException("Invalid input");
    }

    private void setNumbers(int input) {
        numbers = new ArrayList<>();
        while (input > 0) {
            numbers.add(input % 10);
            input /= 10;
        }
        Collections.reverse(numbers);
    }

    public boolean getCorrect() {
        return correct;
    }

    public void makeResult(List<Integer> answer) {
        HashMap<Type, Integer> map = new HashMap<>();

        map.put(Type.None, 0);
        map.put(Type.Ball, 0);
        map.put(Type.Strike, 0);
        for (int idx = 0; idx < numbers.size(); idx++) {
            Type type = getResultType(idx, numbers.get(idx), answer);
            map.put(type, map.get(type) + 1);
        }
        if (map.get(Type.None) == 3) {
            result = "낫싱";
            return ;
        }
        result = map.get(Type.Ball) > 0 ? map.get(Type.Ball).toString() + "볼 " : "";
        result += map.get(Type.Strike) > 0 ? map.get(Type.Strike).toString() + "스트라이크" : "";
        if (map.get(Type.Strike) == 3)
            correct = true;
    }

    private Type getResultType(int index, Integer number, List<Integer> answer) {
        if (isStrike(index, number, answer))
            return Type.Strike;
        if (isBall(index, number, answer))
            return Type.Ball;
        return Type.None;
    }

    private boolean isStrike(int index, Integer number, List<Integer> answer) {
        return answer.indexOf(number) == index;
    }
    private boolean isBall(int index, Integer number, List<Integer> answer) {
        return answer.contains(number) && answer.indexOf(number) != index;
    }

    public void displayResult() {
        System.out.println(result);
        if (correct)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
