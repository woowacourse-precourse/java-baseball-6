package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            //게임 시작
        } while (true); //게임 재시작 여부
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static void validPlayerNumbers(String playerNumbers) {
        if (playerNumbers.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리이어야 합니다.");
        }

        char[] charNumbers = playerNumbers.toCharArray();
        Set<Character> uniqueCharNumbers = new HashSet<>();
        for (char charNumber : charNumbers) {
            if (charNumber < '1' || charNumber > '9') {
                throw new IllegalArgumentException("각 자리 숫자는 1에서 9 사이의 정수이어야 합니다.");
            }
            if (uniqueCharNumbers.contains(charNumber)) {
                throw new IllegalArgumentException("각 자리 숫자는 서로 달라야 합니다.");
            }
            uniqueCharNumbers.add(charNumber);
        }
    }
}