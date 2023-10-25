package baseball;

import static baseball.BaseballGameConstant.GAME_BALL_STRING;
import static baseball.BaseballGameConstant.GAME_ENDED_MESSAGE;
import static baseball.BaseballGameConstant.GAME_NOTHING_STRING;
import static baseball.BaseballGameConstant.GAME_RESTART_MESSAGE;
import static baseball.BaseballGameConstant.GAME_START_MESSAGE;
import static baseball.BaseballGameConstant.GAME_STRIKE_STRING;
import static baseball.BaseballGameConstant.NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    private List<Integer> answer;
    private List<Integer> attempt;
    private int restartFlag = 1;
    private boolean isGameEnded = false;

    public void play() {
        System.out.println(GAME_START_MESSAGE);

        while (restartFlag == 1) {
            isGameEnded = false;
            answer = getRandomNumbers();

            while (!isGameEnded) {
                attempt = getUserNumbers();

                ArrayList<Byte> ballAndStrike = countBallAndStrike(attempt);
                printHint(ballAndStrike);
                if (ballAndStrike.get(1) == NUMBER_LENGTH) {
                    isGameEnded = true;
                    System.out.println(GAME_ENDED_MESSAGE);
                }
            }

            System.out.println(GAME_RESTART_MESSAGE);
            restartFlag = Integer.parseInt(Console.readLine());
        }
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private List<Integer> getUserNumbers() {
        List<Integer> numbers = new ArrayList<>();

        String userInputNumber = Console.readLine();
        for (int i = 0; i < userInputNumber.length(); i++) {
            numbers.add(Character.getNumericValue(userInputNumber.charAt(i)));
        }

        return numbers;
    }

    private void printHint(List<Byte> hint) {
        if (hint.get(0) > 0) {
            System.out.print(hint.get(0) + GAME_BALL_STRING);
        }
        if (hint.get(1) > 0) {
            System.out.print(hint.get(1) + GAME_STRIKE_STRING);
        }
        if (hint.get(0) == 0 && hint.get(1) == 0) {
            System.out.print(GAME_NOTHING_STRING);
        }
        System.out.println();
    }

    private ArrayList<Byte> countBallAndStrike(List<Integer> attempt) {
        byte strike = 0;
        byte ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < attempt.size(); j++) {
                if (answer.get(i) == attempt.get(j) && i == j) {
                    strike++;
                } else if (answer.get(i) == attempt.get(j)) {
                    ball++;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(ball, strike));
    }
}