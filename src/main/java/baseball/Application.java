package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        boolean play = true;
        // 게임 시작
        while (play) {
            // 맞춰야 하는 대상(난수) 생성
            List computer = Computer.computer();
            System.out.println("맞춰야 하는 난수: "+ computer);

            boolean pingPong = true;
            while (pingPong) {
                // 사용자 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                // 사용자 입력값 검증(문자, 음수, 소수 포함 여부 / 길이 / 숫자 중복 여부) 후 list로 변환
                List<Integer> user = Convertor.convert(input, 3);

                // 정답과 사용자 입력값을 비교한 결과 보여주기
                Map<String, Integer> attempt = StrikeOrBall.strikeOrBall(computer, user);
                System.out.println(PrintResult.printResult(attempt));

                // 정답과 사용자 입력값이 일치하여 3스트라이크가 나올 경우 종료
                if (attempt.get("strike") == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    pingPong = false;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            // 사용자 입력값 검증(문자, 음수, 소수 포함 여부 / 길이 / 숫자 중복 여부) 후 list로 변환
            List<Integer> continueChoice = Convertor.convert(input, 1);

            // 1을 입력하면 게임 재시작, 2를 입력하면 프로그램 종료, 그 외 숫자는 에러발생
            switch (continueChoice.get(0)) {
                case 1:
                    play = true;
                    break;
                case 2:
                    System.out.println("게임을 종료합니다");
                    play = false;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}

