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
            playnum.add(promp.charAt(i)-48);
        }
        //수를 받으면서 스트라이크와 볼 카운트
        for (int i = 0; i < promp.length(); i++) {
            if (playnum.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(playnum.get(i))){
                ball++;
            }
        }
    }

    public void printresult() {
        if (this.strike == 0 && this.ball == 0) {
            System.out.println("낫싱");
        } else if (this.strike == 3) {
            System.out.println(this.strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히였습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if (this.strike == 0) {
            System.out.println(this.ball + "볼");
        } else if (this.ball == 0) {
            System.out.println(this.strike + "스트라이크");
        } else {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }
}
