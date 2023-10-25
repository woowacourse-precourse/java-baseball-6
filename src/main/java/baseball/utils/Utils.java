package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    // 각 자리 수가 서로 다른 랜덤 숫자를 생성하는 메소드
    public static List<Integer> generateRandomNumber(int length) {
        List<Integer> result = new ArrayList<>();

        while(result.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    // 사용자 입력이 유효한지 확인하는 메소드
    public static void validateInputValue(String inputValue, int length) {
        // 1. 길이가 length인가?
        if (inputValue.length() != length) {
            throw new IllegalArgumentException();
        }

        // 2. 숫자가 맞는가?
        try {
            Integer.parseInt(inputValue);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        // 3. 모두 다른 숫자인가?
        char[] charArr = inputValue.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char c : charArr) {
            if (charSet.contains(c)) {
                throw new IllegalArgumentException();
            }
            charSet.add(c);
        }
    }

    // 게임 재시작 여부 요청의 입력을 검증하는 메소드
    public void validateRestartInput(String playerInput) {
        if (!playerInput.equals("1") && !playerInput.equals("2")) {
            throw new IllegalArgumentException("입력이 잘못되어 게임을 종료합니다.");
        }
    }

    // 볼 개수를 반환하는 메소드
    public int checkBallCnt(String answerNumber, String inputValue) {
        int result = 0;

        for (int idx=0; idx<answerNumber.length(); idx++) {
            char charAtIdx = inputValue.charAt(idx);
            if (answerNumber.charAt(idx) != charAtIdx && answerNumber.contains(Character.toString(charAtIdx))) {
                result++;
            }
        }

        return result;
    }

    // 스트라이크 개수를 반환하는 메소드
    public int checkStrikeCnt(String answerNumber, String inputValue) {
        int result = 0;

        for (int idx=0; idx<answerNumber.length(); idx++) {
            if (answerNumber.charAt(idx) == inputValue.charAt(idx)) {
                result++;
            }
        }

        return result;
    }

}
