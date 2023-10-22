package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers;
    private final Computer computer;
    public Player() {
        numbers = new ArrayList<>();
        computer = null;
    }
    public Player(Computer computer) {
        numbers = new ArrayList<>();
        this.computer = computer;
    }
    public void addNumber() {
        numbers.clear();
        if(computer == null) {
            setNumberByInput(setInput());
            return;
        }
        computer.setAutoNumber(numbers);
    }
    public int getNumber(int index) {
        return numbers.get(index);
    }
    private void setNumberByInput(String input) {
        while (numbers.size() < 3) {
            int num = input.charAt(numbers.size()) - '0';
            numbers.add(num);
        }
    }
    private String setInput() {
        String input;

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        if(!checkInput(input))
            throw new IllegalArgumentException();
        return input;
    }
    private boolean checkInput(String input) {
        boolean[] checkedNumber = new boolean[10];
        if(input.length() != 3)
            return false;

        for(int i=0; i<3; i++) {
            if( '9' < input.charAt(i) || input.charAt(i) < '1')
                return false;
            if(checkedNumber[input.charAt(i)-'0'])
                return false;
            checkedNumber[input.charAt(i)-'0'] = true;
        }
        return true;
    }
}
