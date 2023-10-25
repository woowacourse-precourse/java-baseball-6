package baseballgame;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseballgame.Constant.*;


public class Play {
    List<Integer> result = new ArrayList<>();

    public Play() {
        // 컴퓨터의 숫자 생성
        while (result.size() < RESULT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void run() {
        //객체 선언
        Play play;
        do {
            //컴퓨터 숫자생성
            play = new Play();
            //게임 1회 시행
            play.playOnce();
        } while (play.restart());
    }

    //게임 1회 시행
    public void playOnce() {
        String inputString;
        do {
            System.out.print(INPUT_NUMBER_STRING);
            inputString = Console.readLine();
        } while (checkGameResult(inputString) != SUCCESS_BOOLEAN);
    }

    //게임 결과 확인
    private boolean checkGameResult(String inputNumberString) {
        int[] inputNumberArray = changeInputStringToIntArray(inputNumberString);
        int strike = getStrike(inputNumberArray);
        int ballWithStrike = getBall(inputNumberArray);
        printResult(strike, ballWithStrike);

        //스트라이크개수 3개면 반복 종료
        if (strike == SUCCESS_STRIKE) {
            return true;
        } else {
            return false;
        }
    }

    //string을 int배열로 변환
    private int[] changeInputStringToIntArray(String inputString) {
        int[] intArray = new int[NORMAL_INPUT_LENGTH];
        verifyInputStringLength(inputString, NORMAL_INPUT_LENGTH);
        for (int i = 0; i < inputString.length(); i++) {
            // 숫자 아닌 입력 예외던지기
            if (inputString.charAt(i) < '0' || inputString.charAt(i) > '9') {
                throw new IllegalArgumentException(wrongTypeInputError);
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i + 1));
        }
        return intArray;
    }

    //입력받은 숫자의 길이 3자리 확인
    private void verifyInputStringLength(String inputString, int correctLength) {
        if (inputString.length() != correctLength) {
            throw new IllegalArgumentException(wrongLengthInputError);
        }
    }

    //재시작 여부 확인
    private boolean restart() {
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if (inputString.equals(RESTART_INPUT_STRING)) {
            return true;
        } else if (inputString.equals(TERMINATE_INPUT_STRING)) {
            return false;
        } else {
            throw new IllegalArgumentException(wrongInputError);
        }
    }

    private int getStrike(int[] inputNumber) {
        int strike = 0;
        for (int i = 0; i < result.size(); i++) {
            if (inputNumber[i] == result.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(int[] inputNumber) {
        int ball = 0;
        for (int i : inputNumber) {
            if (result.contains(i)) {
                ball++;
            }
        }
        return ball;
    }

    //결과 출력
    private void printResult(int strike, int ballWithStrike) {
        int ball = ballWithStrike - strike;
        if (ballWithStrike == NOTHING) {
            System.out.println(NOTHING_STRING);
        } else {
            printBall(ball);
            printStrike(strike);
            System.out.println();
        }
        printSuccess(strike);
    }

    private void printNothing(){
        System.out.println(NOTHING_STRING);
    }
    private void printBall(int ball) {
        if (ball != 0) {
            System.out.print(ball + BALL_STRING);
        }
    }

    private void printStrike(int strike) {
        if (strike != 0) {
            System.out.print(strike + STRIKE_STRING);
        }
    }

    private void printSuccess(int strike) {
        if (strike == SUCCESS_STRIKE) {
            System.out.println(SUCCESS_STRING);
        }
    }


}
