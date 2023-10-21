package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        boolean flag = true;
        String number;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (flag) {
            // 컴퓨터 정답 생성
            List<Integer> computerBall = new ArrayList<>();
            while (computerBall.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerBall.contains(randomNumber)) {
                    computerBall.add(randomNumber);
                }
            }
            // 스트라이크, 볼 변수 선언
            Referee referee;
            BallCount ballCount;
            do {
                // 변수 초기화
                referee = new Referee();

                System.out.print("숫자를 입력해주세요 : ");
                number = Console.readLine();
                // 유효성 검사
                ErrorDetector.throwIfNumberIsWrong(number);

                List<Integer> playerBall = new ArrayList<>();
                // 만약 입력한 값에 같은 숫자가 있다면 예외 발생
                for (int i = 0; i < 3; i++) {
                    int num = Integer.parseInt(number.substring(i, i + 1));
                    playerBall.add(num);
                }

                ballCount = referee.checkBallCount(playerBall, computerBall);
                // 정답 안에 숫자가 있다면 true, 없다면 false
                System.out.println(ballCount.toString());

            } while (!ballCount.isThreeStrike()); // 3스트라이크가 나올 때 까지 반복

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String option = Console.readLine();
            // 유효성 검사
            ErrorDetector.throwIfOptionIsWrong(option);
            if (option.equals("2")) { // 입력 값이 2와 같다면 실행 종료
                flag = false;
            }
        }
    }
}
