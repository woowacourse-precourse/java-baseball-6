package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private BaseBall baseBall;
    public Computer(){
        int first = Randoms.pickNumberInRange(0,9);
        int second = Randoms.pickNumberInRange(0,9);
        int third = Randoms.pickNumberInRange(0,9);
        baseBall = new BaseBall(first,second,third);
    }

    /***
     * 유저가 가진 BaseBall을 반환하는메소드
     * @return  BaseBall은 index3짜리 배열이다.
     */
    public int[] getPossessionBaseBall() {
        return baseBall.getNumbers();
    }
}
