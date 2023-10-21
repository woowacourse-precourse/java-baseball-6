package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        boolean play = true;

        while (play) {
            // 맞춰야 하는 대상(난수) 생성
            List computer = Computer.computer();
            // System.out.println("맞춰야 하는 난수: "+ computer);

            boolean oneGame = true;

            while (oneGame) {
                // 사용자 입력 받기 + 간단한 검증(문자, 음수, 소수 포함 여부 / 문자열 길이 / )
                List user = User.user();
                System.out.println("숫자를 입력해주세요 : " + user);

                Map<String, Integer> attempt = StrikeOrBall.strikeOrBall(computer, user);
                System.out.println(PrintResult.printResult(attempt));
                if (attempt.get("strike") == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    oneGame = false;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            // 입력 validation 필요
            if (input.equals("2")) {
                System.out.println("게임을 종료합니다");
                play = false;
            }
        }
        }

}

