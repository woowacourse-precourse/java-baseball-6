package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        List<Integer> copyList = new ArrayList<>(numbers);
        copyList = Collections.unmodifiableList(copyList);
        return copyList;
    }

    public void inputNums(){
        numbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            int number = Integer.parseInt(input);
            if (input.contains("0")){   // 0이 포함된 숫자를 가졌을 경우
                throw new IllegalArgumentException("contains '0'");
            }
            if (number < 100 || number > 999){  // 숫자가 세자리 수가 아닌 경우
                throw new IllegalArgumentException("not three digit number");
            }
            for (int i = 100; i > 0; i /= 10){
                int digit = number / i;
                number %= i;
                if (this.numbers.contains(digit)) {   // 서로 다른 세 자리의 수가 아닐 경우
                    throw new IllegalArgumentException("contains duplicate numbers");
                }
                this.numbers.add(digit);
            }
        } catch (NumberFormatException e){  // 숫자가 아닌 이상한 값일 경우
            throw new IllegalArgumentException("not number");
        }
    }

}
