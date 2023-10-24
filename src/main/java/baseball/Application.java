package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        /*int i;
        for(i = 0; i < computer.size(); i++)
            System.out.println("Random is " + computer.get(i));*/

        System.out.println("숫자 야구 게임을 시작합니다.");

        int startOrStop = 1;
        while (startOrStop == 1){
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while(true){
                int strike = 0;
                int ball = 0;
                int divisor = 100;

                System.out.print("숫자를 입력해주세요 : ");

                List<Integer> inputNumber = new ArrayList<>();
                int input = Integer.parseInt(Console.readLine()); //자체 클래스보려면 camp.nextstep.edu.missionutils에 들어가서 사용법 봐야함
                int index = 0;
                while (input > 0) {
                    inputNumber.add(input % 10);
                    input /= 10;
                    index++;
                }
                Collections.reverse(inputNumber);
                if (inputNumber.size() != 3){
                    throw new IllegalArgumentException();
                }
                for(int i = 0; i < computer.size(); i++) {
                    for (int j = 0; j < inputNumber.size(); j++)
                        if(computer.get(i) == inputNumber.get(j) && i == j)
                            strike++;
                        else if(computer.get(i) == inputNumber.get(j))
                            ball++;
                }
                if (strike == 0 && ball == 0)
                    System.out.println("낫싱");
                else if(strike > 0 && ball == 0)
                    System.out.println(strike + "스트라이크");
                else if(strike == 0 && ball > 0)
                    System.out.println(ball + "볼");
                else
                    System.out.println(ball + "볼 " + strike + "스트라이크");

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            startOrStop = Integer.parseInt(Console.readLine());
        }
    }
}
