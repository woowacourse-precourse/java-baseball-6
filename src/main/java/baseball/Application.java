package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        // 입력 받은 내용을 처리하거나 출력하기
        List<Integer> computer = new ArrayList<>();

        String tf = "1";

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            if(tf.equals("1")) {
                // 입력 받은 내용을 처리하거나 출력하기
                computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }

                tf = "";

                System.out.println(computer);
            }

            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();

            System.out.println("사용자가 입력한 값: " + userInput);
            String str[] = userInput.split("");

            int strike = 0;
            int ball = 0;

            for(int i=0; i<userInput.length(); i++){
                if(computer.get(i) == Integer.parseInt(str[i])){
                    strike++;
                } else if(computer.contains(Integer.parseInt(str[i]))){
                    ball++;
                }
            }
            if(ball != 0){
                System.out.print(ball + "볼 ");
            }

            if(strike != 0){
                System.out.print(strike + "스트라이크");
            }

            if(ball == 0 && strike == 0){
                System.out.print("낫싱");
            }

            System.out.println();

            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                tf = readLine();

                if(tf.equals("2")) break;
            }
        }
    }
}
