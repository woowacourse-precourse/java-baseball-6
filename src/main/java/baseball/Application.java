package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int choose = 1;
        while (choose == 1) {
            List<Integer> computer = new ArrayList<>();
            computer.add(Randoms.pickNumberInRange(1, 9));
            computer.add(Randoms.pickNumberInRange(1, 9));
            computer.add(Randoms.pickNumberInRange(1, 9));

            while(computer.size()<3){
                int randNum=Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randNum)){
                    computer.add(randNum);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userNum = Console.readLine();

                if (userNum.length() != 3) {
                    throw new IllegalArgumentException();
                }

                List<Integer> userGuess = new ArrayList<>();
                userGuess.add(Integer.parseInt(userNum.substring(0, 1)));
                userGuess.add(Integer.parseInt(userNum.substring(1, 2)));
                userGuess.add(Integer.parseInt(userNum.substring(2, 3)));

                if (userGuess.get(0) == userGuess.get(1) || userGuess.get(1) == userGuess.get(2) || userGuess.get(0) == userGuess.get(2)) {
                    throw new IllegalArgumentException();
                }

                int strike = 0;
                int ball = 0;
                for (int i = 0; i < 3; i++) {
                    if (userGuess.get(i) == computer.get(i)) {
                        strike++;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            if (i != j && userGuess.get(i) == computer.get(j)) {
                                ball++;
                            }
                        }
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else if (strike != 0 && ball == 0 && strike != 3) {
                    System.out.println(strike + "스트라이크");
                } else if (strike != 3) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike == 3) {
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choose = Integer.parseInt(Console.readLine());
            if (choose != 1 && choose != 2) {
                throw new IllegalArgumentException();
            }
        }
    }
}