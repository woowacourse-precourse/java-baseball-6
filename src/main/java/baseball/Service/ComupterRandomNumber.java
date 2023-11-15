package baseball.Service;

import baseball.Model.BaseballMember;
import camp.nextstep.edu.missionutils.Randoms;

public class ComupterRandomNumber {
    //computer가 랜덤으로 숫자를 생성함
    BaseballMember bm = new BaseballMember();
    public void computerRandom() {
        while ((bm.getComputer().size()) < 3) {   //리스트에 들어있는 원소 수
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1~9까지의 수 랜덤으로 집어넣음
            if (!bm.getComputer().contains(randomNumber)) { //중복방지
                bm.getComputer().add(randomNumber);
            }
        }
    }
    public static void main(String args[]){}
}
