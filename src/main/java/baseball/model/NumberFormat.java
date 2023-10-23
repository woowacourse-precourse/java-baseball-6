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

     public static NumberFormat createNumberFormat(int num) throws IllegalArgumentException {
          List<Integer> numberList = new ArrayList<>();
          while (num > 0){
               numberList.add(num%10);
               num/=10;
          }

          if (!validateFormat(numberList)) throw new IllegalArgumentException();

          Collections.reverse(numberList);
          return new NumberFormat(numberList);
     }

     private static boolean validateFormat(List<Integer> list){
          return list.size() == DIGIT_CONSTRAINT;
     }

     public List<Integer> getNumberList() {
          return numberList.stream().collect(Collectors.toUnmodifiableList());
     }
}
