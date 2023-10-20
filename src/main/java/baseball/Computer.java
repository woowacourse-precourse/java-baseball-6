package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    // computeArr과 playerArr를 List 또는 배열 중 어떤 것을 선언하면 더 빠르게 조회할 수 있을까?
    List<Integer> computerBall = new ArrayList<>();

    // 컴퓨터 인스턴스가 생성되면 랜덤으로 번호 생성
    public void initComputerBall() {
        while(computerBall.size() < 3) {
            int newBall = Randoms.pickNumberInRange(1, 9);
            if(!computerBall.contains(newBall)) {
                computerBall.add(newBall);
            }
        }
    }

    public Computer() {
        initComputerBall();
    }

    public List<Integer> getComputerBall() {
        return computerBall;
    }

    /*
    public String compareNum(ArrayList<Integer> computerArr, ArrayList<Integer> playerArr) {
        int strikeCnt = 0;
        int ballCnt = 0;
        Map<Integer, Integer> enumerate = new HashMap<>();

        if(computerArr == playerArr) {
            return "3스트라이크\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }

        for(int i = 0; i < playerArr.size(); i++) {
            enumerate.put(playerArr.get(i), i);
        }

        for(int i = 0; i < computerArr.size(); i++) {
            if(computerArr.get(i) == playerArr.get(i)) {
                strikeCnt += 1;
            }
            int a = computerArr.indexOf(playerArr.get(i));
            if(a != -1 && a != enumerate.get(i)) {
                ballCnt += 1;
            }
        }
    }
     */

}
