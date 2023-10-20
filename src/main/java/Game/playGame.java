package Game;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class playGame {
    String answer = new String();

    public playGame(){
        while(answer.length()<3){
            int randomNum= Randoms.pickNumberInRange(1,9);
            if(!answer.contains(String.valueOf(randomNum))){
                answer+=String.valueOf(randomNum);
            }
        }
    }

    private void turn(){
        String inputString;
        do {
            System.out.print("숫자를 입력해주세요 :");
            inputString = Console.readLine();
            checkInputString(inputString);
        }while(true);
    }

  

}
