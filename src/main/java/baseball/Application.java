package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력값을 받을 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 숫자 야구 게임 시작
        while (true) {
            // 1. 게임 시작 메시지 출력
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 2. 게임 진행
            // 2-1. 컴퓨터가 임의의 수 3개를 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // System.out.println(computer);

            // 2-2. 사용자가 임의의 수 3개를 입력
            while (true) {
                List<Integer> user = new ArrayList<>();
                System.out.print("숫자를 입력해주세요 : ");
                int inputNumber = scanner.nextInt();

                // 3자리 수가 아닌 경우 예외 처리
                if(inputNumber < 100 || inputNumber > 999) {
                    throw new IllegalArgumentException();
                }

                // 3자리 수인 경우, 각 자리 수를 user에 추가
                user.add(inputNumber / 100);
                user.add((inputNumber % 100) / 10);
                user.add(inputNumber % 10);
                // System.out.println(user);

                // 2-3. 컴퓨터가 생성한 수와 사용자가 입력한 수 비교
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < computer.size(); i++) {
                    // 스트라이크: 같은 인덱스인 경우
                    if (computer.get(i).equals(user.get(i))) {
                        strike++;
                    }
                    // 볼: 다른 인덱스면서 배열에 속하는 경우
                    else if (computer.contains(user.get(i))) {
                        ball++;
                    }
                }

                // 2-4. 비교한 결과 출력
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else if (strike != 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }

                // 2-5. 3스트라이크일 경우 게임 종료
                if (computer.equals(user)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            // 3. 게임 재시작할지 확인 [시작=1, 종료=2]
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int isRestart = scanner.nextInt();
            if(isRestart == 1){
                System.out.println(isRestart);
                continue;
            }
            if(isRestart == 2) {
                break;
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        // Scanner 객체 종료
        scanner.close();
    }
}
