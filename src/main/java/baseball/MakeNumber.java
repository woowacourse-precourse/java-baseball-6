package baseball;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MakeNumber {

    private List<Integer> makeNumberByRamdom() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size()<3){
            numbers.add(pickNumberInRange(1,9));
        }

        return numbers;
    }

    public List<Integer> getComputerNumbers(){
        //todd: 컴퓨터 랜던값 확인용
        System.out.println(makeNumberByRamdom());
        return makeNumberByRamdom();
    }

}
