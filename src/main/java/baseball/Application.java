package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        int[] playerNumber = new int[3];
        for (int i = 0; i < 3; i++){
            playerNumber[i] = playerInput.charAt(i) - '0';
        }
        int strike = 0;
        int ball = 0;
        boolean nothing = true;
        for(int i =0; i < 3; i++){
            for(int j = 0; j<3; j++){
                if(computer.get(i) == playerNumber[j]){
                    if(i == j){
                        strike++;
                        nothing = false;
                        continue;
                    }else{
                        ball++;
                        nothing= false;
                        continue;
                    }
                }else{
                    nothing = true;
                    continue;
                }
            }
        }if(strike > 0&& ball == 0){
            System.out.println(strike + "스트라이크 ");
        }else if(strike ==0 && ball > 0) {
            System.out.println(ball + "볼 ");
        }else if(strike > 0 && ball > 0){
            System.out.println(strike + "스트라이크 " + ball + "볼 ");
        }else if(nothing == true){
            System.out.println("낫싱");
        }
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }





    }
}
