package baseball.model;

import java.util.List;

public class Models {

    static final int VALID_INPUT_LENGTH =3;
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

    public static boolean countMatchingDigits(List<Integer> answerIntegerList,List<Integer> inputIntegerList) {
        // 입력받은 수가 정답에 포함되어 있는지 확인
        for (int i = 0; i < VALID_INPUT_LENGTH  ; i++) {
            if(answerIntegerList.contains(inputIntegerList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static int countStrike(List<Integer> answerIntegerList,List<Integer> inputIntegerList) {
        // 정답 리스트에서 비교해서 같은 위치라면 strike변수 증가
        int strikeCount = 0;

        for (int i = 0; i < VALID_INPUT_LENGTH ; i++) {
            if (answerIntegerList.get(i) == inputIntegerList.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }




}
