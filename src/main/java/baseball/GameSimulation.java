package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameSimulation {

    private Integer StrikeCount;
    private Integer BallCount;
    private List<Integer> computer;
    private List<Integer> user;

    public GameSimulation(){
        init();
    }

    // 컴퓨터의 번호를 설정하는 함수
    void init(){
        while (computer.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

}
