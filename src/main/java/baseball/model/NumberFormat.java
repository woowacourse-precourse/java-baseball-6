package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberFormat {
     public static final int DIGIT_CONSTRAINT = 3;

     private List<Integer> numberList;

     protected NumberFormat(){
          this.numberList = new ArrayList<>();
     }

     protected NumberFormat(List<Integer> numberList){
          this.numberList = numberList;
     }

     public static NumberFormat generateRandomNumber(){
          List<Integer> randomNumberList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
          return new NumberFormat(randomNumberList);
     }
}
