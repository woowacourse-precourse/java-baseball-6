package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        boolean flag = true;
        String userInput;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (flag) {
            // 컴퓨터 정답 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // 스트라이크, 볼 변수 선언
            int strike;
            int ball;
            do {
                // 변수 초기화
                strike = 0;
                ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                userInput = Console.readLine();
                // 길이가 3이 아니면 예외 발생
                if (userInput.length() != 3) {
                    throw new IllegalArgumentException();
                }

                List<Integer> user = new ArrayList<>();
                // 만약 입력한 값에 같은 숫자가 있다면 예외 발생
                for (int i = 0; i < 3; i++) {
                    int tmp = Integer.parseInt(userInput.substring(i, i + 1));
                    if (!user.contains(tmp)) {
                        user.add(tmp);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                // 정답 안에 숫자가 있다면 true, 없다면 false
                for (int i = 0; i < user.size(); i++) {
                    int num = user.get(i);
                    if (computer.contains(num)) {
                        // 컴퓨터 i번쨰 자리 수와 유저 정답의 i번째 자리수가 같다면 스트라이크 + 1
                        if (computer.get(i) == num) {
                            strike++;
                            // 다르다면 볼 + 1
                        } else {
                            ball++;
                        }
                    }
                }

                StringBuffer sb = new StringBuffer();
                // 볼이 있으면 볼 추가
                if (ball > 0) {
                    sb.append(ball + "볼 ");
                } // 스트라이크가 있다면 스트라이크 추가
                if (strike > 0) {
                    sb.append(strike + "스트라이크");
                } // 둘 다 0 이면 낫싱 추가
                if (ball == 0 && strike == 0) {
                    sb.append("낫싱");
                } // 버퍼 출력
                System.out.println(sb.toString());
            } while (strike < 3); // 3스트라이크가 나올 때 까지 반복

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            userInput = Console.readLine();
            // 입력 값이 1, 2 둘 다 아니라면 예외 발생
            if (!userInput.equals("1") && !userInput.equals("2")) {
                throw new IllegalArgumentException();
            }
            if (userInput.equals("2")) { // 입력 값이 2와 같다면 실행 종료
                flag = false;
            }
        }
    }
}
