package baseball;



import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {

      ArrayList<Integer> comArr = new ArrayList<Integer>(3);
      ArrayList<Integer> userArr = new ArrayList<Integer>(3);
      
      String restart = "1";
      System.out.println("숫자 야구 게임을 시작합니다.");
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
        //System.out.print("컴퓨터의 숫자 :"+comArr);

    
        while(true){
          System.out.print("숫자를 입력해주세요 : ");
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
          if(strikeCnt==0 && ballCnt==0){
            System.out.print("낫싱");
          }
          else{
            if (ballCnt>0)
              System.out.print(ballCnt + "볼 ");
            if(strikeCnt>0)
              System.out.print(strikeCnt + "스트라이크");
          }
          System.out.println();
          userArr.clear();
          if(strikeCnt==3){
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
