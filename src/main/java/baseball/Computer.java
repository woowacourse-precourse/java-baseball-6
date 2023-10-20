package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private ArrayList<Integer> numbers; //컴퓨터가 선택한 서로 다른 숫자 조합
    Computer(){
        this.numbers = new ArrayList<>();
    }

    public void setNumbers(){ //서로 다른 3개의 난수를 생성하는 setter 메소드
        while(this.numbers.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }

    public ArrayList<Integer>getNumbers(){
        return this.numbers;
    }
}
