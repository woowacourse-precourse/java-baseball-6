package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart = 1;

        WHILEFOR:
        while (true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }



            System.out.println("숫자 야구 게임을 시작합니다.");
            int strike = -1, ball = -1;


            while (true) {
                System.out.println(computer);
                strike = 0;
                ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                String temp = camp.nextstep.edu.missionutils.Console.readLine();
                if (temp.length() != 3)
                    throw new IllegalArgumentException("Invalid argument: " + temp);
                List<Integer> user = new ArrayList<>();
                for (int i = 0; i < 3; i++)
                    user.add(temp.charAt(i) - '0');

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (user.get(i) == computer.get(j)) {
                            if (i == j) strike++;
                            else ball++;
                        }
                    }
                }

                if (strike == 0 && ball == 0)
                    System.out.println("낫싱");
                else if (strike == 0 && ball != 0)
                    System.out.println(ball + "볼");
                else if (strike != 0 && ball == 0)
                    System.out.println(strike + "스트라이크");
                else
                    System.out.println(ball + "볼 " + strike + "스트라이크");

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String tmp = camp.nextstep.edu.missionutils.Console.readLine();
                    restart = tmp.charAt(0) - '0';
                    if (restart < 1 && restart > 2)
                        throw new IllegalArgumentException("Invalid argument: " + restart);
                    if (restart == 2)
                        break WHILEFOR;
                    if(restart == 1)
                        break;
                }
            }


        }
    }
}
