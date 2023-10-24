package baseball;



import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import baseball.View;

public class Application {
    public static void main(String[] args) {

      ArrayList<Integer> comArr = new ArrayList<Integer>(3);
      ArrayList<Integer> userArr = new ArrayList<Integer>(3);
      
      String restart = "1";
      View.printGameStart();
      
      
      while(restart.equals("1")){
        //컴퓨터 숫자 뽑기
        for(int i=0;i<3;i++){
          int pickedNum=Randoms.pickNumberInRange(1,9);
          boolean isPicked=false;
          for(int j=0;j<i;j++){
            if(pickedNum==comArr.get(j))
                isPicked=true;
          }
          if(isPicked){
            i--;
            continue;
          }
          comArr.add(pickedNum);
          
        }

    
        while(true){
          View.printEnterNumber();
          
          String input = Console.readLine();
          for(int i=0;i<3;i++){
            userArr.add(input.charAt(i)-'0');
          }
          //System.out.print(userArr);

          int strikeCnt=0, ballCnt=0;

          for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
              if (i == j && userArr.get(i) == comArr.get(j)) {
                //System.out.printf("str",i);
                strikeCnt++;
              } else if (i != j && userArr.get(i) == comArr.get(j)) {
                //System.out.printf("ball","i=",i,"j=",j);
                ballCnt++;
              }
            }
          }
         View.printResult(ballCnt,strikeCnt);
          userArr.clear();
          if(strikeCnt==3){
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
}
