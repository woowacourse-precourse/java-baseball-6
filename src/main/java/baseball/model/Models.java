package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Models {

    public static final int VALID_INPUT_LENGTH =3;

    public static void validateStringOneorTwo(String input) {
        if(input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하여 게임을 종료하겠습니다.");
    }

    public static void validateInputSize(String input) {
        if(input.length() == VALID_INPUT_LENGTH ) {
            return;
        }
        throw new IllegalArgumentException("입력값의 글자수가 유효한 크기가 아닙니다.");
    }

    public static boolean checkMatchingDigits(int index,List<Integer> answerIntegerList,List<Integer> inputIntegerList) {
        // 입력받은 수가 정답에 포함되어 있는지 확인
        if(answerIntegerList.contains(inputIntegerList.get(index))) {
            return true;
        }
        return false;
    }

    public static boolean isStrike(int index,List<Integer> answerIntegerList,List<Integer> inputIntegerList) {
        if(answerIntegerList.get(index) == inputIntegerList.get(index)) {
            return true;
        }
        return false;
    }

    public static boolean containsBothStrikeAndBall(int strike , int ball) {
        if( strike == 0 || ball== 0) {
            return false;
        }
        return true;
    }

    public static List<String> splitStringToList(String string) {
        String[] splitArray = string.split("");
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            stringList.add(splitArray[i]);
        }

        return stringList;
    }

    public static List<Integer> convertStringToInteger(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            String curString = stringList.get(i);
            integerList.add(Integer.parseInt(curString));
        }

        return integerList;
    }

    public static List<Integer> generateNumber() {
        // 정답 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static boolean askRestart(String input) {
        if(input.equals("1")) {
            return true;
        }
        return false;
    }








}
