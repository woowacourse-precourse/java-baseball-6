package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int[] randomNumber() {
        int[] randomNum = new int[3];
        int index = 0;

        int randomNumber = 0;
        while (index < randomNum.length) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            boolean contains = false;

            // 배열 내에서 중복을 확인
            for (int i = 0; i < index; i++) {
                if (randomNum[i] == randomNumber) {
                    contains = true;
                    break;
                }
            }

            if (!contains) {
                randomNum[index] = randomNumber;
                index++;
            }
        }

        return randomNum;
    }
}
