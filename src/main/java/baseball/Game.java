package baseball;

import java.util.List;

public class Game {

    Player player = new Player();
    Computer computer = new Computer();

    public void startGame(){

        boolean restart = false;
        do{
            play();

            //사용자에게 재시작 여부를 확인
            //restart = ...
        }while(restart);
        //TODO : 종료하기 전 Console.close() 호출

    }
    public void play(){
        computer.init();
        Result result;
        do{
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> input = player.getInput();
            result = computer.getResult(input);
            System.out.println(result);
        }while(result.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        //Computer.init();
        /*
        게임을 진행
        결과 출력 ...
         */
    }
}
