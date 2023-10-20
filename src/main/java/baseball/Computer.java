package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers = new ArrayList<>();

    //생성자 : 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
    Computer(){
        while(numbers.size() < 3){
            int randomNumb = Randoms.pickNumberInRange(1,9);
            if(!numbers.contains(randomNumb)){
                numbers.add(randomNumb);
            }
        }
    }

    //생성한 수 반환 함수
    public List<Integer> getNumbers(){
        return numbers;
    }
}
