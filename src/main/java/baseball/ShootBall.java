package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ShootBall {
    private int[] numbers;

    //TODO:생성자 구현 -23.10.22
    ShootBall() {
        numbers = new int[10];
    }

    //TODO:(2)번 구현 -23.10.22
    private void randomNumGenerator(){
        int randNum;
        for(int i=1; i<=3;i++) {
            randNum = Randoms.pickNumberInRange(1, 9);
            numbers[randNum] = i;
        }
    }

    //TODO:(3)번 구현 -23.10.22

}
