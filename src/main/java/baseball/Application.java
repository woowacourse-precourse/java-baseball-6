package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        String userInput;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            while (true) {
                // 서로 다른 수로 이루어진 3자리 수 랜덤 생성
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }

                int strike = 0;
                int ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                userInput = Console.readLine();

                // 입력값 올바른 지 체크
                if (userInput.length() != 3) throw new IllegalArgumentException();
                for (int i = 0; i < userInput.length(); i++) {
                    if(userInput.charAt(i) - '0' < 1 && userInput.charAt(i) - '0' > 9)
                        throw new IllegalArgumentException();
                }

                for (int i = 0; i < computer.size(); i++) {
                    for (int j = 0; j <userInput.length(); j++) {
                        if (computer.get(i) == userInput.charAt(j) - '0') {
                            if (i == j) strike++;
                            else ball++;
                        }
                    }
                }

                if (strike == 0) {
                    if (ball == 0) System.out.println("낫싱");
                    else System.out.println(ball + "볼");
                }
                else {
                    if (ball == 0) System.out.println(strike + "스트라이크");
                    else System.out.println(ball + "볼 " + strike + "스트라이크");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = Console.readLine();
            if (userInput.equals("2")) break;
            else if (!userInput.equals("1")) throw new IllegalArgumentException();  // 잘못된 값 입력 시
            computer.clear();
        }
    }
}
