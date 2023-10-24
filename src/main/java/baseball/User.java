package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
  public ArrayList<Integer> getUserNumbers() {
    return userNumbers;
  }

  ArrayList<Integer> userNumbers = new ArrayList<Integer>();
  public  void inputUserNumbers(){
    userNumbers.clear();
 
     
      try {
        String inputStr = Console.readLine();
        if(inputStr.length()>3 || inputStr.length()<1)
          throw new IllegalArgumentException("3개의 숫자가 입력되지 않았습니다.");

        //ArrayList<Integer> inputNumbers = new ArrayList<Integer>(3);
        for(int i=0;i<3;i++){
          int parsedNum=inputStr.charAt(i)-'0';
          if(parsedNum<1 || parsedNum>9)
            throw new IllegalArgumentException("1에서 9사이의 숫자를 입력해 주세요");
          
          for(int j=0;j<i;j++){
            if(userNumbers.get(j)==parsedNum)
              throw new IllegalArgumentException("숫자에 중복이 존재합니다");
          }

          userNumbers.add(parsedNum);
        }
        
      }
      catch (Exception e){
        System.out.println(e);
      }
//      for(int i=0;i<3;i++){
//        userNumbers.add(input.charAt(i)-'0');
////        userNumbers.add(1);
//      }
    

   

  }
}
