package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
  
  static int size = 3;  
  
    private static final ArrayList<Integer> InputNumber = null;

    public static void main(String[] args) {
      
      System.out.println("숫자 야구 게임을 시작합니다");
        
         
      
      
//      숫자 랜덤 생성
      List<Integer> computer = new ArrayList<>();
      while (computer.size() < size) {
          int randomNumber = Randoms.pickNumberInRange(1, 9);
          if (!computer.contains(randomNumber)) {
              computer.add(randomNumber);
          }
      }
      System.out.println(computer);
      
      Input in = new Input();
      System.out.println(in.player_num());

      
      
    }

}

   
    

