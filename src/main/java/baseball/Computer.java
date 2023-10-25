package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    //정답 판별 변수
    boolean done;
    //정답
    List<Integer> computer;

    //생성자
    Computer(boolean done){
        this.done=done;
    }

    //판별 setter
    public void setDone(boolean done) {
        this.done = done;
    }
    //판별 getter
    public boolean isDone() {
        return done;
    }
    //정답 getter
    public List<Integer> getComputer() {
        return computer;
    }
    
    //정답 생성
    public void generateNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computer=computer;
    }
}
