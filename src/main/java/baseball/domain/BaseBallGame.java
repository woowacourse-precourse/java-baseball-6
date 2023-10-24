package baseball.domain;

import baseball.domain.computer.Computer;
import baseball.domain.number.Number;
import baseball.domain.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
    private Computer computer;
    private Player player;

    public BaseBallGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean playAgain = true;

        while (playAgain) {
            playRound();
            playAgain = askPlayAgain();
        }
    }

    private void playRound() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                numbers.add(digit);
            }
        }
        int[] result = checkGuess(numbers);
        System.out.println(Arrays.toString(result));
    }
    private int[] checkGuess(List<Integer> guess) {
        List<Number> computerNumbers = computer.getAnswerNumbers();
        System.out.println("computerNumbers : " + computerNumbers);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (guess.contains(computerNumbers.get(i).getNumber())) {
                list.add(computerNumbers.get(i).getNumber());
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean askPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        int choice = scanner.nextInt();
        return choice == 1;
    }

}
