package baseballgame;

import static constant.Constant.ANSWER_SIZE;
import static constant.Constant.BALL_STRING;
import static constant.Constant.END_RANGE;
import static constant.Constant.INPUT_NUMBER_STRING;
import static constant.Constant.NORMAL_INPUT_LENGTH;
import static constant.Constant.NOTHING;
import static constant.Constant.NOTHING_STRING;
import static constant.Constant.RESTART_INPUT_STRING;
import static constant.Constant.RESTART_MESSAGE;
import static constant.Constant.START_RANGE;
import static constant.Constant.STRIKE_STRING;
import static constant.Constant.SUCCESS_BOOLEAN;
import static constant.Constant.SUCCESS_STRIKE;
import static constant.Constant.SUCCESS_STRING;
import static constant.Constant.TERMINATE_INPUT_STRING;
import static constant.StringError.wrongInputError;
import static constant.StringError.wrongLengthInputError;
import static constant.StringError.wrongTypeInputError;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> answer = new ArrayList<>();

    public Game() {
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);

            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

    }

    //game 시작
    public static void run() {
        Game game;
        do {
            game = new Game();
            game.playGameOnce();
        } while (game.restart());
    }

    private void playGameOnce() {
        String inputString;
        do {
            System.out.print(INPUT_NUMBER_STRING);
            inputString = Console.readLine();

            //changeInputStringToIntArray(inputString);
        } while (checkGameResult(inputString) != SUCCESS_BOOLEAN);
    }

    private boolean checkGameResult(String inputNumberString) {
        int[] inputNumberArray = changeInputStringToIntArray(inputNumberString);

        //strike, ball 계산
        int strike = getStrike(inputNumberArray);
        int ballWithStrike = getBall(inputNumberArray);

        //결과 출력
        printResult(strike, ballWithStrike);

        //3 스트라이크(=정답)인 경우 playGameOnce 중지
        if (strike == SUCCESS_STRIKE) {
            return true;
        } else {
            return false;
        }
    }

    //결과 출력 전체
    private void printResult(int strike, int ballWithStrike) {
        int ball = ballWithStrike - strike;
        if (ballWithStrike == NOTHING) {
            printNothing();
        } else {
            printBall(ball);
            printStrike(strike);
            System.out.println();
        }
        printSuccess(strike);

    }

    //결과 출력 1
    private void printNothing() {
        System.out.println(NOTHING_STRING);
    }

    //결과 출력2
    private void printBall(int ball) {
        if (ball != 0) {
            System.out.print(ball + BALL_STRING);
        }
    }

    //결과 출력3
    private void printStrike(int strike) {
        if (strike != 0) {
            System.out.print(strike + STRIKE_STRING);
        }
    }

    //결과 출력4
    private void printSuccess(int strike) {
        if (strike == SUCCESS_STRIKE) {
            System.out.println(SUCCESS_STRING);
        }
    }

    //입력 확인1
    private int[] changeInputStringToIntArray(String inputString) { //
        int[] intArray = new int[NORMAL_INPUT_LENGTH];
        verifyInputStringLength(inputString, NORMAL_INPUT_LENGTH);
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) < '0' || inputString.charAt(i) > '9') {
                throw new IllegalArgumentException(wrongTypeInputError);
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i + 1));
        }
        return intArray;
    }

    //입력 확인2: 입력 길이
    private void verifyInputStringLength(String inputString, int correctLength) {
        if (inputString.length() != correctLength) {
            throw new IllegalArgumentException(
                    wrongLengthInputError + "\nExpect : " + correctLength + "\nInput : " + inputString.length());
        }
    }

    //다시 game 진행할지 유무
    private boolean restart() {
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if (inputString.equals(RESTART_INPUT_STRING)) {
            return true;
        } else if (inputString.equals(TERMINATE_INPUT_STRING)) {
            return false;
        } else {
            throw new IllegalArgumentException("[Game.restart()]:" + wrongInputError);
        }
    }

    private int getStrike(int[] inputNumber) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (inputNumber[i] == answer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(int[] inputNumber) {
        int ball = 0;
        for (int i : inputNumber) {
            if (answer.contains(i)) {
                ball++;
            }
        }
        return ball;
    }

}
