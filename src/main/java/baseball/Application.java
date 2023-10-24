package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        Computer computer = new Computer();

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.startGame();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> numbers;
            try {
                numbers = listResolver(Console.readLine().split(""));
            } catch (Exception exception) {
                throw new IllegalArgumentException();
            }
            boolean finishQuestion = computer.hint(numbers);
            if (finishQuestion) {
                boolean finish = computer.endGame();
                if (!finish) {
                    break;
                }
            }
        }
    }

    /**
     * make it String[] to List<Integer> and validate input
     * @param guessNumberString: input string from user
     * @return make it to Integer List
     */
    private static List<Integer> listResolver(String[] guessNumberString) {
        List<Integer> guessNumber = new ArrayList<>();
        if (guessNumberString.length != 3) {
            throw new IllegalArgumentException();
        }
        for (String number : guessNumberString) {
            int parsedNumber;
            try {
                parsedNumber = Integer.parseInt(number);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            guessNumber.add(parsedNumber);
        }
        return guessNumber;
    }
}
