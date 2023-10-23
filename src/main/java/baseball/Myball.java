package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Myball {
    private int[] numbers = new int[3];

    public void input() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();

        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
    }

    public int[] getNumbers() {
        return numbers;
    }
}