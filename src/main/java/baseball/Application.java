package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean exit = false; // 게임 종료 여부

        while(true) {
            // exit가 참일 경우 게임 종료
            if(exit) break;

            // 컴퓨터 3자리 수 생성
            List<Integer> computer = new ArrayList<>();
            while(computer.size() < 3) {
                int randomNum = Randoms.pickNumberInRange(1, 9);
                if(!computer.contains(randomNum)) {
                    computer.add(randomNum);
                }
            }

            while(true) {
                // 3자리 수 입력
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> user = new ArrayList<>();
                String[] inputs = Console.readLine().split("");
                for(String input : inputs) {
                    if(!user.contains(Integer.parseInt(input))) {
                        user.add(Integer.parseInt(input));
                    }
                }

                // 서로 다른 3자리가 입력되지 않은 경우 예외 발생
                if(user.size() != 3) {
                    throw new IllegalArgumentException("서로 다른 3자리를 입력해주세요");
                }

                // ball, strike 판독
                int ball = 0, strike = 0;
                for(int i=0; i<user.size(); i++) {
                    if(computer.contains(user.get(i))) {
                        if(computer.get(i) == user.get(i)) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                // ball, strike, 낫싱 출력
                if(ball == 0 && strike == 0) {
                    System.out.print("낫싱");
                } else {
                    if(ball > 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if(strike > 0) {
                        System.out.print(strike + "스트라이크");
                    }
                }
                System.out.println();

                // 정답일 경우
                if(strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int replay = Integer.parseInt(Console.readLine());

                    // 1이나 2가 입력되지 않은 경우 예외 발생
                    if(replay != 1 && replay != 2) {
                        throw new IllegalArgumentException("1 또는 2를 입력해주세요");
                    } else {
                        if(replay == 2) {
                            exit = true;
                        }
                    }
                    break;
                }
            }
        }
    }
}