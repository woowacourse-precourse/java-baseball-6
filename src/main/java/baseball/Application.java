package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    private Console console;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_FOR_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    /**
     * 사용자의 입력을 받아 list<integer>로 변환하는 함수
     */
    public List<Integer> inputNumber() {

        System.out.println(START_MESSAGE);
        System.out.print(ASK_FOR_NUMBER_MESSAGE);
        String input = console.readLine();
        int number = parseInt(input);

        return getDigit(number);
    }

    /**
     * int -> list<integer> 변환 함수
     */
    private List<Integer> getDigit(int number) {

        List<Integer> digits = new ArrayList<>();

        int digit1 = number / 100;
        int digit2 = (number % 100) / 10;
        int digit3 = number % 10;

        digits.add(digit1);
        digits.add(digit2);
        digits.add(digit3);

        return digits;
    }

    /**
     * string -> int 변환 함수
     */
    private int parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 정수를 입력해주세요.)");
        }
    }
}
