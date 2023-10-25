package baseballgame;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseballgame.Constant.*;


public class Play {
    List<Integer> result = new ArrayList<>();

    public Play(){
        // 컴퓨터의 숫자 생성하고 list에 집어넣기
        while(result.size() < ANSWER_SIZE ){
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if(!result.contains(randomNumber)){
                result.add(randomNumber);
            }
        }
    }

    public static void run(){
        //객체 선언
        Play play;
        do{
            //컴퓨터 숫자생성
            play = new Play();
            //게임 시행
            play.
        }while(/*게임 재시작 여부확인*/);
    }

    //게임 1회 시행
    public void playOnce(){
        String inputString;
        do{
            System.out.print(INPUT_NUMBER_STRING);
            inputString = Console.readLine();
        }while(/*게임결과확인*/ != SUCCESS_BOOLEAN);
    }

}
