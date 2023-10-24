package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    List<Integer> computer; //수 셋팅
    List<Integer> playnum;
    int strike;
    int ball;
    int status; //1은 실행 2는 종료

    BaseBall(){this.status=1; this.setgame();}

    //난수생성, 1~9의 3자리 수, 중복된 수 x
    public void setgame() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void playgame(String promp){
        this.strike=0; this.ball=0;
        this.playnum = new ArrayList<>();
        for (int i = 0; i < promp.length(); i++) {
            playnum.add(promp.charAt(i)-50);
        }
        //수를 받으면서 스트라이크와 볼 카운트
        for (int i = 0; i < promp.length(); i++) {
            if (playnum.get(i) == computer.get(i)) {
                strike++;
            } else if (computer.contains(playnum.get(i))){
                ball++;
            }
        }
    }
}
