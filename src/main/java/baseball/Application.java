package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static int strike, ball;
    static List<Integer> computer;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        int restart = 0;
        do{
            computer = new ArrayList<>();
            while(computer.size() < 3){
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if(!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            boolean finish = false;
            while(!finish){
                System.out.print("숫자를 입력해주세요 : ");
                String[] str = readLine().split("");
                if(str.length != 3){
                    throw new IllegalArgumentException();
                }

                ball = 0;
                strike = 0;

                strikeBall(str);

                if(strike == 3){
                    finish = true;
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                } else if(strike > 0 || ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if(strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.parseInt(readLine());
        }while(restart == 1);
    }

    public static void strikeBall(String[] arr){
        for(int i = 0; i < computer.size(); i++){
            for(int j = 0; j < computer.size(); j++){
                if(computer.get(i) == Integer.parseInt(arr[j]) && i == j){
                    strike++;
                }
                if(computer.get(i) == Integer.parseInt(arr[j]) && i != j){
                    ball++;
                }
            }
        }
    }
}
