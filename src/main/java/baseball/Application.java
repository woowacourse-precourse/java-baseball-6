package baseball;



import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        System.out.print("@");





      ArrayList<Integer> comArr = new ArrayList<Integer>(3);
      ArrayList<Integer> userArr = new ArrayList<Integer>(3);
      
        for(int i=0;i<3;i++){
          comArr.add(Randoms.pickNumberInRange(1,9));
        }
        
        System.out.print(comArr);
        
        while(true){
          userArr.clear();
          String input = Console.readLine();
          for(int i=0;i<3;i++){
            userArr.add(input.charAt(i)-'0');
          }
          System.out.print(userArr);
          
          int strikeCnt=0, ballCnt=0;
          
          for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
              if (i == j && userArr.get(i) == comArr.get(j)) {
                //System.out.printf("str",i);
                strikeCnt++;
                break;
              } else if (i != j && userArr.get(i) == comArr.get(j)) {
                //System.out.printf("ball","i=",i,"j=",j);
                ballCnt++;
                break;
              }
            }
          }
          System.out.println(strikeCnt + "strike"+ballCnt+"ball");
          
           
        }
    }
}
