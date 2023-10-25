package baseball;

import java.util.ArrayList;

public class Game {
    static ArrayList<Integer> computerList;
    public static void run(){
        //야구 게임 시작 메시지 출력
        Output.printStartMessage();
        while (true){
            //게임 시작
            gameStart();
            //종료선택시 프로그램 종료
            //if
            {
                break;
            }
        }
        return;

    }
    public static void gameStart(){
        //컴퓨터 숫자 생성
        computerList = Computer.generateRandomNumber();
        while (true){
            //숫자입력 메시지 출력
            Output.printInputNumberMessage();
            //입력받아 처리하기
            //입력에 대한 결과 출력
            //맞췄을 시 종료
        }
        

    }
}
