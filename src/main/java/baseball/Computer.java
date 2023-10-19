package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import javax.swing.*;

public class Computer {
    private ArrayList<Integer> numbers= new ArrayList<>(); //컴퓨터가 뽑은 숫자 조합
    Computer(){
        while(this.numbers.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }

    ArrayList<Integer>getNumbers(){
        return this.numbers;
    }
}
