package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameState = 1;//1:게임진행, 2:게임종료
        List<Integer> computer = new ArrayList<>();//컴퓨터 수 컨테이너 할당

        //게임 시작
        while(gameState==1){
            //1.상대방 수 생성
            while (computer.size() < 3){
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if(!computer.contains(randomNumber)){
                    computer.add(randomNumber);
                }
            }
            System.out.println(computer.toString());
            //2.3자리수 입력 시작
            while(true){
                String in = Console.readLine();
                System.out.println(in);
            }
        }
    }
}
