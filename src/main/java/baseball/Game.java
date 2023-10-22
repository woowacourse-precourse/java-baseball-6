package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static baseball.Constant.*;

public class Game {
    List<Integer> answerList = new ArrayList<>();

    public Game() {
        while (answerList.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!isContainedNumber(randomNumber))
                answerList.add(randomNumber);
        }
        // 정답 확인용
        for (Integer x : answerList) {
            System.out.print(x+" ");
        }
    }

    public void play() {
        String inputString;
        boolean isResultWin = false;
        do {
            System.out.println(GET_NUMBER_MESSAGE);
            inputString = Console.readLine();
            if (isValidNumber(inputString)) {
                isResultWin = checkResult(inputString);
            }
        } while (!isResultWin);
    }

    private boolean isContainedNumber(int randomNumber) {
        for (Integer x : answerList) {
            if (x == randomNumber) return true;
        }
        return false;
    }

    private boolean isValidNumber(String inputString) {
        if (checkNumberLength(inputString) && checkIsDigit(inputString) && checkNumberDuplicate(inputString)) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkNumberLength(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (3자리 자연수만 가능)");
        }
        return true;
    }

    private boolean checkIsDigit(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            int number = inputString.charAt(i);
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (1~9의 자연수만 가능)");
            }
        }
        return true;
    }

    private boolean checkNumberDuplicate(String inputString) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            set.add(inputString.charAt(i));
        }
        if (set.size() != inputString.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (중복된 숫자 불가능)");
        }
        return true;
    }

    private boolean checkResult(String inputString) {
        int[] inputIntArray = changeStringToIntArray(inputString);
        int strike= getStrike(inputIntArray);
        int ball = getBall(inputIntArray);
        Result result = new Result(strike, ball-strike);
        System.out.println(result.getResultString());

        if (strike == NUMBER_COUNT) {
            System.out.println(SUCCESS_MESSAGE);
            return true;
        }
        else {
            return false;
        }
    }

    private int[] changeStringToIntArray(String inputString) {
        int[] intArray = new int[NUMBER_COUNT];
        for (int i = 0; i < inputString.length(); i++) {
            intArray[i] = Integer.parseInt(inputString.substring(i,i+1));
        }

        return intArray;
    }

    private int getStrike(int[] inputIntArray) {
        int strike = 0;
        for (int i = 0; i < inputIntArray.length; i++) {
            if (inputIntArray[i] == answerList.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(int[] inputIntArray) {
        int ball = 0;
        for (int i = 0; i < inputIntArray.length; i++) {
            if (answerList.contains(inputIntArray[i])) {
                ball++;
            }
        }
        return ball;
    }
}