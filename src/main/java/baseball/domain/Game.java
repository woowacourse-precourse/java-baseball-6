package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> computer = new ArrayList<>();

    public Game(int size, int start, int end){
        while(computer.size() != size){
            int num = Randoms.pickNumberInRange(start, end);
            if(!computer.contains(num)){
                computer.add(num);
            }
        }
    }

    public List<Integer> getComputer(){
        return this.computer;
    }

}
