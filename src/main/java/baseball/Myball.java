package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Myball {
    private int[] numbers = new int[3];

    public void input() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();

        if (input.length() != 3 ) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException();
            }
            numbers[i] = c - '0';
        }
        
        if (DuplicationCheck.hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
        
    }

    public int[] getNumbers() {
        return numbers;
    }
}