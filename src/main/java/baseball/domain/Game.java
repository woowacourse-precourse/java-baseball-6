package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;


public class Game {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }
    public void initBaseball(){ //스트라이크 와 볼의 수 0으로 초기화
        strikeCount = 0;
        ballCount = 0;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
    public int getBallCount() {
        return ballCount;
    }

    public static int[] getGameNumbers() {
        int[] computerNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            computerNumber[i] = getUniqueRandomNumber(computerNumber, i);
        }
        return computerNumber;
    }

    private static int getUniqueRandomNumber(int[] computerNumber, int i) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (!isUnique(computerNumber, i, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] computerNumber, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (computerNumber[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }

    public void incStrikeCount() {
        strikeCount += 1;
    }

    public void incBallCount() {
        ballCount += 1;
    }


}