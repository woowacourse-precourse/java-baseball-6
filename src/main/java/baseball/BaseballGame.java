package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    int GAME_RUN;
    int STRIKE;
    int BALL;
    private List<Integer> computer; //컴퓨터 숫자
    private List<Integer> player;   //플레이어 숫자

    //컴퓨터 숫자 랜덤 생성
    public List<Integer> random(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //숫자 입력
    public int InputNum(){
        String Num = Console.readLine();
        return Integer.parseInt(Num);
    }

    //int -> List 변경
    public ArrayList<Integer> ListNum(int PNum){
        ArrayList<Integer> arrNum = new ArrayList<>();

        while(PNum > 0) {
            arrNum.add(PNum %10);
            PNum /= 10;
        }

        return arrNum;
    }

    //초기화
    public void init(){
        GAME_RUN = 1;
        STRIKE = 0;
        BALL = 0;
    }

    //실행
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            if(GAME_RUN == 2){
                break;
            }

            init();
            computer = random();

            while(true) {
                init();
                System.out.print("숫자를 입력해주세요 : ");
                int PNum = InputNum();
                player = ListNum(PNum);

                for(int i=0; i <3; i++){
                    if(computer.get(i) == player.get(i)){
                        STRIKE++;
                    }
                    else{
                        BALL++;
                    }
                }

                if(STRIKE == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                else if(BALL == 3){
                    System.out.println("낫싱");
                }
                else{
                    System.out.println(BALL + "볼 " + STRIKE + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            GAME_RUN = InputNum();
        }
    }
}
