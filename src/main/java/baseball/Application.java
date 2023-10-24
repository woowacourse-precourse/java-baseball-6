package baseball;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Character.isDigit;

public class Application {
    public static void main(String[] args) {
        // 게임 재시작시 처음으로 돌아옴
        while (true) {
            // 상대방의 수를 생성, 어레이로 각 자리수 저장
            ArrayList<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                // 먼저 포함된 숫자를 확인하여 서로 다른 숫자만 저장
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // 시작 메시지
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 게임 진행
            PlayGame(computer);

            // 재시작 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartText = readLine();
            if (Objects.equals(restartText, "1")) {
                continue;
            }
            else if (Objects.equals(restartText, "2")) {
                break;
            }
            else {
                // 1과 2가 아니라면 Exception
                throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
            }
        }
    }

    /**
     * 사용자가 숫자를 입력하고 컴퓨터의 숫자와 비교하여 스트라이크와 볼을 출력하는 메소드
     *
     * @param computer: 컴퓨터가 생성한 3자리수를 넣는다.
     */
    public static void PlayGame(ArrayList<Integer> computer) {
        while (true) {
            // 입력 요청 메시지
            System.out.print("숫자를 입력해주세요 : ");

            // 입력받은 사용자의 수를 ArrayList로 각 자리수 저장
            String userNumber = readLine();
            if (userNumber.length() != 3 || !userNumber.matches("[+-]?\\d*(\\.\\d+)?")) {
                // 3자리의 숫자가 아니라면 Exception
                throw new IllegalArgumentException("3자리의 중복되지 않은 숫자만 입력 가능합니다." );
            }
            ArrayList<Integer> user = new ArrayList<>();
            for (int i = 0; i < userNumber.length(); i++) {
                if (user.contains(userNumber.charAt(i) - '0')) {
                    // 먼저 포함된 숫자를 확인하여 중복된 수 발견시에 Exception
                    throw new IllegalArgumentException("3자리의 증복되지 않은 숫자만 입력 가능합니다." );
                }
                user.add(userNumber.charAt(i) - '0');
            }


            // 컴퓨터와 사용자의 수 비교 및 출력
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < computer.size(); i++) {
                if (Objects.equals(computer.get(i), user.get(i))){
                    strike += 1;
                }
                else if (computer.contains(user.get(i))) {
                    ball += 1;
                }
            }

            // 스트라이크 볼 출력
            if (strike == 0 && ball == 0)  {
                System.out.println("낫싱");
            }
            else if (strike == 0) {
                System.out.println(ball + "볼 ");
            }
            else if (ball == 0){
                System.out.println(strike + "스트라이크 ");
            }
            else{
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            // 3스트라이크(정답)의 경우
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
