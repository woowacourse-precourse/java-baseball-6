package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    //1에서 9까지 서로 다른 임의의 수 3개 생성 및 반환
    public List<Integer> getNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 3){
            int randomNumb = Randoms.pickNumberInRange(1,9);
            if(!numbers.contains(randomNumb)){
                numbers.add(randomNumb);
            }
        }
        return numbers;
    }
}
