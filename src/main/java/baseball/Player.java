package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Player {
    /*
        플레이어의 숫자를 입력 받는 메서드
     */
    public int[] inputPlayerNums() {
        String inputNum = Console.readLine();
        isValidNumber(inputNum);
        return getNumArray(inputNum);
    }

    private int[] getNumArray(String num) {
        int[] numArray = new int[num.length()];
        for (int i = 0; i < 3; i++) {
            numArray[i] = getUnitNum(num, i);
        }
        return numArray;
    }

    /*
        플레이어의 입력에 대한 유효성을 검사한다.
     */
    private void isValidNumber(String num) {
        // 길이가 3이 아니면 IllegalArgumentException 발생 시킨다.
        if (num.length() != 3) {
            throw new IllegalArgumentException();
        }
        // 중복된 수가 존재 해도 IllegalArgumentException 발생
        if (isDuplicateNumber(num)) {
            throw new IllegalArgumentException();
        }
    }

    // 중복된 숫자를 확인하기 위해
    // 숫자의 유효성을 단위 숫자가 등장한 횟수로
    // 중복을 확인 한다.
    private boolean isDuplicateNumber(String num) {
        Map<Character, Integer> countNumMap = getPlayerNumCountingMap(num);
        for (Character inPlayerNum : countNumMap.keySet()) {
            if (countNumMap.get(inPlayerNum) != 1) {
                return true;
            }
        }
        return false;
    }

    private Map<Character, Integer> getPlayerNumCountingMap(String num) {
        Map<Character, Integer> countNumMap = new HashMap<>();
        char[] nums = num.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            countNumMap.put(nums[i],
                    countNumMap.getOrDefault(nums[i], 1));
        }
        return countNumMap;
    }

    private static int getUnitNum(String num, int i) {
        return num.charAt(i) - '0';
    }

}
