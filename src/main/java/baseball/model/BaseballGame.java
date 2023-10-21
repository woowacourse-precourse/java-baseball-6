package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {

    private int randomNum;

    protected BaseballGame() {}

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public void run() {
        this.generateRandomNum();
    }

    private void generateRandomNum() {
        while (true){
            int randomNum = pickNumberInRange(100, 999);
            // 유효한 RandomNum인지 검증 후 저장
            if (isValidRandomNum(randomNum)) {
                this.randomNum = randomNum;
                break;
            }
        }
    }

    private static boolean isValidRandomNum(int randomNum) {
        // 0 ~ 9 숫자들의 등장 여부를 저장할 배열
        boolean[] existingDigits = new boolean[10];
        // 파라미터로 받은 랜덤 수가 0보다 클 때까지 루프를 돌며 검사
        while (randomNum > 0) {
            // 가장 우측 자리의 수를 추출하고, 등장했던 적이 있는지 if문으로 검사
            int digit = randomNum % 10;
            if (existingDigits[digit]) {
                // 한번이라도 등장했다면 false
                return false;
            }
            // 처음 등장하는 경우,
            existingDigits[digit] = true;
            randomNum /= 10;
        }
        return true;
    }
}
