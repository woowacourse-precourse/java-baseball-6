package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {
    static ArrayList<Integer> computerList;
    static ArrayList<Integer> playerList;
    public Input myInput;

    public Game() {
        myInput = new Input();
    }
    public void run(){
        //야구 게임 시작 메시지 출력
        Output.printStartMessage();
        while (true){
            //게임 시작
            gameStart();
            //종료or 재시작 선택 메시지 출력
            Output.printNewGameOrGameEndMessage();
            //종료선택시 프로그램 종료
            String input = Console.readLine();
            int choice = Integer.parseInt(input);

            if(choice == 2)
            {
                break;
            }
        }
        return;

    }
    public void gameStart(){
        //컴퓨터 숫자 생성
        computerList = Computer.generateRandomNumber();

        while (true){
            //숫자입력 메시지 출력
            Output.printInputNumberMessage();
            //입력받아 처리하기
            //String[] input = Console.readLine().split("");
            //예외 처리 추가
            String str = Console.readLine();
            int[] input = myInput.varlidateInput(str);
            playerList = new ArrayList<>();
            for(int i=0; i<input.length; i++){
                playerList.add(input[i]);
            }
            //입력에 대한 결과 출력
            int strike = strikeNumber(playerList);
            int ball = ballNumber(playerList, strike);

            Output.printResult(strike, ball);
            //맞췄을 시 종료
            if(strike == 3){
                Output.printVictoryMessage();
                break;
            }
        }
        

    }
    static int strikeNumber(ArrayList<Integer> input){

        int result=0;
        for(int i=0; i<computerList.size(); i++){
            if(computerList.get(i) == input.get(i)){
                result += 1;
            }
        }
        return result ;
    }

    static int ballNumber(ArrayList<Integer> input, int strike){

        int result=0;
        for(int i=0; i<computerList.size(); i++){
            if(input.contains(computerList.get(i))){
                result += 1;
            }
        }
        //포함되어 있는 수 - STRIKE를 = BALL의 개수
        return result - strike;
    }
}
