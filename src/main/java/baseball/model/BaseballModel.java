package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {

    private int[] targetNumber;

    // 난수에는 생성자로만 접근 가능
    public BaseballModel(){
        generateRandomNumber();
    }

    // 1~9의 서로 다른 3자리 수 생성 , 캡슐화
    private void generateRandomNumber() {
        targetNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (containsNumber(targetNumber, randomNumber));
            targetNumber[i] = randomNumber;
        }
    }

    // 난수 결과 반환
    public int[] getTargetNumber() {
        return targetNumber;
    }

    // 생성되는 난수의 중복 확인
    private boolean containsNumber(int[] array, int number) {
        for (int item : array) {
            if (item == number) {
                return true;
            }
        }
        return false;
    }



}
