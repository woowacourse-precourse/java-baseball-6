package baseball.domain;

import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {


//    사용자가 컴퓨터의 숫자를 맞추기
   public List<Integer> guessNumbers(){
       String numberStr = Console.readLine();
       Validation.validateInput(numberStr);

       return numbersToList(Integer.parseInt(numberStr));
   }

//   입력한 숫자를 숫자 리스트로 변환
   private List<Integer> numbersToList(int numbers){
        List<Integer> list = new ArrayList<>();
        while(numbers != 0){
            list.add(0,numbers%10);
            numbers/=10;
        }
       return list;
   }




}
