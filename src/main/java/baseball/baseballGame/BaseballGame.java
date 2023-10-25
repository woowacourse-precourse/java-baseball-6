package baseball.baseballGame;

import static baseball.define.Define.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer = new ArrayList<>();

    public void run() {
        System.out.println(START_MESSAGE);
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame(){
        makeRandomAnswer();
        int[] userInputIntArr;
        do {
            System.out.print(INPUT_MESSAGE);
            String userInputStr = Console.readLine();
            userInputIntArr = getUserNumber(userInputStr);
        } while (!guessCorrectAnswer(userInputIntArr));
    }

    private void makeRandomAnswer(){
        answer.clear();
        while(answer.size() < ANSWER_LEN){
            int randomNum = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if(!answer.contains(randomNum)){
                answer.add(randomNum);
            }
        }
        for (Integer integer : answer) {
            System.out.println(integer.toString());
        }
    }

    private boolean restartGame(){
        System.out.println(RESTART_MESSAGE);
        String inputStr = Console.readLine();
        if (inputStr.equals(RESTART_GAME)) {
            return true;
        } else if (inputStr.equals(END_GAME)) {
            return false;
        } else {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean guessCorrectAnswer(int[] userInput) {
        int strike = countStrike(userInput);
        int ball = countBall(userInput);
        ball -= strike;
        printResult(strike, ball);

        return strike == 3;
    }

    private int[] getUserNumber(String userInputStr) throws IllegalArgumentException {
        if(userInputStr.length() != ANSWER_LEN)
            throw new IllegalArgumentException(ERROR_MESSAGE);
        int[] userInputIntArr = new int[ANSWER_LEN];
        for (int i = 0; i < 3; i++) {
            if (userInputStr.charAt(i) < (char)(START_RANGE + '0') || userInputStr.charAt(i) > (char)(END_RANGE + '0'))
                throw new IllegalArgumentException(ERROR_MESSAGE);
            for (int j = 0; j < i; j++) {
                if (userInputStr.charAt(i) == userInputStr.charAt(j))
                    throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            userInputIntArr[i] = Integer.parseInt(userInputStr.substring(i, i + 1));
        }
        return userInputIntArr;
    }

    private int countStrike(int[] userInput) {
        int strike = 0;
        for (int i = 0; i < ANSWER_LEN; i++) {
            if (userInput[i] == answer.get(i))
                strike++;
        }
        return strike;
    }

    private int countBall(int[] userInput) {
        int ball = 0;
        for (int i : userInput) {
            if (answer.contains(i))
                ball++;
        }
        return ball;
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else if (strike == ANSWER_LEN) {
            System.out.println(ANSWER_LEN + STRIKE);
            System.out.println(ANSWER_LEN + END_MESSAGE);
        } else {
            System.out.println(ball + BALL + strike + STRIKE);
        }
    }
}
