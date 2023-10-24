package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static int GameStart(int gameCoin) {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }    
    
        ArrayList<Integer> StrikeBallList = new ArrayList<Integer>();
        StrikeBallList.add(3);
        StrikeBallList.add(0);
        System.out.println(StrikeBallList);

        while (true){
            // ikeBallList =  ArrayList<Integer>(strike, ball)
            if (StrikeBallList.get(0) == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }else if (StrikeBallList.get(0) == 0){
                if (StrikeBallList.get(1) == 0){
                    System.out.println("낫싱");
                }else{
                    System.out.println(StrikeBallList.get(1)+"볼");
                }
            }else{
                if (StrikeBallList.get(1) != 0){
                    System.out.println(StrikeBallList.get(1)+"볼 " + StrikeBallList.get(0) + "스트라이크");
                }else{
                    System.out.println(StrikeBallList.get(0)+"스트라이크");
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameCoin = sc.nextInt();
        return gameCoin;

    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameCoin = 1;

        while(gameCoin == 1){
            gameCoin = GameStart(gameCoin);
        }
        
    }

}