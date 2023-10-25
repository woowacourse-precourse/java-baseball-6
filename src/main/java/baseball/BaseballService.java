package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    private BaseballException baseballException = new BaseballException();

    public String getComputerNum() {
        // 컴퓨터가 1~9까지의 서로 다른 임의의 수 3개 선택
        String computer = "";
        for (int i=0;i<3;i++) {
            computer+= Integer.toString(Randoms.pickNumberInRange(1, 9));
        }
        return computer;
    }

    public int countStrikeOrBall(String computer, String randomNum, BaseballEnum baseballEnum){
        // 컴퓨터가 임의로 뽑은 수 3개와 플레이어가 입력한 숫자 3개 비교
        int count=0;
        for (int i=0; i<3; i++) {
            String number = Character.toString(computer.charAt(i));

            if (randomNum.contains(number)) {
                int index = randomNum.indexOf(number);
                count+=addStrikeOrBall(i, index, baseballEnum);
            }
        }
        return count;
    }

    public int addStrikeOrBall(int i, int index, BaseballEnum baseballEnum) {
        if (baseballEnum==BaseballEnum.STRIKE) {
            if (i==index) return 1;
        } else if (baseballEnum==BaseballEnum.BALL) {
            if (i!=index) return 1;
        }
        return 0;
    }

    public int getStrike(String computer, String randomNum){
        return countStrikeOrBall(computer, randomNum, BaseballEnum.STRIKE);
    }

    public int getBall(String computer, String randomNum){
        return countStrikeOrBall(computer, randomNum, BaseballEnum.BALL);
    }

    public void verifyRandomInput(String randomNum) {
        baseballException.isLengthValid(randomNum);
        baseballException.isDuplicationExist(randomNum);
        baseballException.isCharinString(randomNum);
    }


}
