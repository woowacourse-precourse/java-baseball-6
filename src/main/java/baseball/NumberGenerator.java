package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private List<Integer> computer;

    private NumberGenerator(List<Integer> computer){
        this.computer = computer;
    }

    //컴퓨터가 숫자 생성
    public static NumberGenerator generateComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //System.out.println(computer);

        return new NumberGenerator(computer);
    }

    public List<Integer> getComputer(){
        return computer;
    }
}
