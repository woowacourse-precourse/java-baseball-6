package baseball;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int retry = 1;  // 게임 종료 후 재시작 확인용
        while (retry == 1) {
            // 컴퓨터 숫자 값 설정
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // 사용자 입력 부분: break 되기 전까지 무조건 반복이므로 true 사용
            while (true) {
                // 결과 출력 후 값 초기화 및 선언 일괄 처리 위해 반복문 하위에 작성
                int strike = 0;
                int ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                String user = Console.readLine();
                List<Integer> userNum = new ArrayList<>();
                for(Character ch : user.toCharArray())
                    if (!userNum.contains(Character.getNumericValue(ch))) // 중복된 숫자는 저장하지 않음
                        userNum.add(Character.getNumericValue(ch));
                // 예외 처리
                if (userNum.size() != 3) {
                    throw new IllegalArgumentException("올바른 값을 입력해 주세요");
                }
                // 스트라이크, 볼 계산
                for (int i : userNum) {
                    if (computer.contains(i)) {
                        if (computer.indexOf(i) == userNum.indexOf(i))
                            strike ++;
                        if (computer.indexOf(i) != userNum.indexOf(i))
                            ball++;
                    }
                }
                // 결과 출력
                if (ball > 0)
                    System.out.print(ball + "볼 ");
                if (strike > 0)
                    System.out.print(strike + "스트라이크");
                if (ball == 0 && strike == 0)
                    System.out.print("낫싱");
                System.out.println();
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    retry = Integer.parseInt(Console.readLine());
                    // 예외 처리
                    if (retry < 1 || retry > 2) {
                        throw new IllegalArgumentException("올바른 값을 입력해 주세요");
                    }
                    break;
                }
            }
         }
    }
}