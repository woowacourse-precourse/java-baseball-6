package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final CreateNumber createNumber;
    private final InputNumber inputNumber;
    private final Calculate calculate;

    public BaseBallGame(CreateNumber createNumber, InputNumber inputNumber, Calculate calculate) {
        this.createNumber = createNumber;
        this.inputNumber = inputNumber;
        this.calculate = calculate;
    }

    public void play() {
        while (true) {
            List<Integer> answer = createNumber.generate();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = Console.readLine();

                if (!inputNumber.isValidGuess(guess)) {
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }

                List<Integer> guessNumbers = convertToIntegerList(guess);
                int[] score = calculate.calculate(guessNumbers, answer);
                int strike = score[0];
                int ball = score[1];

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.printf("%d볼 %d스트라이크%n", ball, strike);
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();

            if ("2".equals(restart)) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (!"1".equals(restart)) {
                System.out.println("잘못된 값을 입력하셨습니다.");
            }
        }
    }



    private List<Integer> convertToIntegerList(String str) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : str.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}
