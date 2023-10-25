package baseball.model;

import baseball.view.Messages;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Game {
    private static final int SIZE = 3;
    private static final int STRIKE_INDEX = 1;
    private static final int BALL_INDEX = 0;

    // 컴퓨터가 3개의 랜덤한 수를 뽑는 메서드

    public List<Integer> generateComputersNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < SIZE) {
            computer.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(computer);
    }

    public List<Integer> evaluateUserInput(List<Integer> userInput, List<Integer> computerNumbers) {
        int strikes = (int) IntStream.range(0, SIZE)
                .filter(i -> Objects.equals(userInput.get(i), computerNumbers.get(i)))
                .count();

        int balls = (int) userInput.stream()
                .filter(num -> computerNumbers.contains(num))
                .count() - strikes;

        return List.of(balls, strikes);
    }

    public boolean returnResult(List<Integer> result) {
        int ball = result.get(BALL_INDEX);
        int strike = result.get(STRIKE_INDEX);
        boolean gameOver = false;

        if (strike == SIZE) {
            Messages.printStrikesCount(SIZE);
            gameOver = true;
        } else if (ball > 0 && strike > 0) {
            Messages.printBallsAndStrikesCount(ball, strike);
        } else if (ball > 0) {
            Messages.printBallsCount(ball);
        } else if (strike > 0) {
            Messages.printStrikesCount(strike);
        } else {
            Messages.printNothing();
        }
        return gameOver;
    }

    public boolean retryHandler() {
        System.out.println("다시 시작하시겠습니까? (1: 재시작, 2: 종료)");
        String userInput = Console.readLine();

        return switch (userInput) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        };
    }


}