package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    public String getComputerNum() {
        // 컴퓨터가 1~9까지의 서로 다른 임의의 수 3개 선택
        String computer = "";
        for (int i=0;i<3;i++) {
            computer+= Integer.toString(Randoms.pickNumberInRange(1, 9));
        }
        return computer;
    }
}
