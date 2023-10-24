package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberFormat {
     public static final int DIGIT_CONSTRAINT = 3;

     private List<Integer> numberList;

     protected NumberFormat(List<Integer> numberList){
          this.numberList = new ArrayList<>(numberList);
     }

     public static NumberFormat generateRandomNumber(){
          List<Integer> randomNumberList = new ArrayList<>();
          while (randomNumberList.size() < DIGIT_CONSTRAINT){
               int randomNumber = Randoms.pickNumberInRange(1, 9);
               if (!randomNumberList.contains(randomNumber))
                    randomNumberList.add(randomNumber);
          }
          return new NumberFormat(randomNumberList);
     }

     public static NumberFormat createNumberFormat(int num) {
          return new NumberFormat(convertIntToDigitList(num));
     }

     private static List<Integer> convertIntToDigitList(int num) {
          List<Integer> numberList = new ArrayList<>();
          while (num > 0){
               numberList.add(num%10);
               num/=10;
          }

          if (!validateFormat(numberList)) throw new NumberFormatException("자릿수 제약사향: " + DIGIT_CONSTRAINT);
          Collections.reverse(numberList);

          return numberList;
     }

     private static boolean validateFormat(List<Integer> list){
          return list.size() == DIGIT_CONSTRAINT;
     }

     public List<Integer> getNumberList() {
          return Collections.unmodifiableList(numberList);
     }
}
