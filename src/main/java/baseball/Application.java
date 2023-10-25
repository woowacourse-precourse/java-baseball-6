package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // 랜덤 숫자를 생성.
        int uniqueRandomNumber = generateUniqueRandomNumber(1, 9, 3);
        System.out.println("상대방의 수: " + uniqueRandomNumber);
    }

    public static int generateUniqueRandomNumber(int start, int end, int count) {
        int result = 0;
        Set<Integer> uniqueNumbers = new HashSet<>();

        //set을 이용해 중복 제거
        while (uniqueNumbers.size() < count) {
            int uniqueNumber = Randoms.pickNumberInRange(start, end);
            uniqueNumbers.add(uniqueNumber);
        }
        for (int number : uniqueNumbers) {
            result = result * 10 + number;
        }

        return result;
    }
}
