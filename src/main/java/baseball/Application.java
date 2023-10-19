package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        System.out.println(computer.getNumbers());
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            User user = new User();
            System.out.print("숫자를 입력해주세요: ");
            user.setGuessNumber();
            System.out.println(user.getNumbers());
            ArrayList<Integer>com = computer.getNumbers();
            ArrayList<Integer>player = user.getNumbers();
            int strike = 0;
            int ball = 0;
            for(int i=0 ;i<com.size();i++){
                for(int j=0;j<player.size();j++){
                    if(com.get(i).equals(player.get(j))){
                        if(i==j){
                            strike++;
                        } else
                            ball++;
                    }
                }
            }
            if(strike==3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
            else if(strike!=0||ball!=0){
                if(ball!=0){
                    System.out.printf("%d볼 ",ball);
                }
                if(strike!=0){
                    System.out.printf("%d스트라이크\n",strike);
                } else{
                    System.out.println();
                }
            } else {
                System.out.println("낫싱");
            }
        }

    }
}
