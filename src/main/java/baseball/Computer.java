package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import javax.swing.*;

public class Computer {
    private ArrayList<Integer> numbers= new ArrayList<>(); //컴퓨터의 숫자 조합
    Computer(){
        //3개의 난수를 선택함
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
