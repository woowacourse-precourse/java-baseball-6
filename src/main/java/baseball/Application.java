package baseball;



import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import baseball.View;
import baseball.Computer;

public class Application {
    public static void main(String[] args) {

      ArrayList<Integer> comArr = new ArrayList<Integer>(3);
      ArrayList<Integer> userArr = new ArrayList<Integer>(3);
      
      Computer computer = new Computer();
      
      
      String restart = "1";
      View.printGameStart();
   
        
        
      while(restart.equals("1")){

        computer.init();
        
        
        while(true){
          View.printEnterNumber();
          Application.inputUserNumbers(userArr);
          
          ArrayList<Integer> resultArr =  computer.calculateResult(userArr);
          View.printResult(resultArr);
          
          if(resultArr.get(1)==3){
            View.printGameEnd();
            restart = Console.readLine();
            if(restart.equals("1")){
//              System.out.print("다시 ㄱㄱ");
            }
            else if(restart.equals("2")){
//              System.out.print("다시 ㄱㄱ안해요");
            }
            comArr.clear();
            userArr.clear();
            break;
          }


        }

        
        
        }
    }
    public static void inputUserNumbers(ArrayList<Integer> userArr){
      userArr.clear();
      String input = Console.readLine();
      for(int i=0;i<3;i++){
        userArr.add(input.charAt(i)-'0');
      }
      
    }
  
}
