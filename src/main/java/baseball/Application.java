package baseball;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 맞춰야 하는 대상(난수) 생성
        List computer = Computer.computer();
        System.out.println("맞춰야 하는 난수: "+ computer);

        // 사용자 입력 받기 + 간단한 검증(문자, 음수, 소수 포함 여부 / 문자열 길이 / )
        List user = User.user();
        System.out.println("사용자의 입력: " + user);

        Map<String, Integer> attempt = StrikeOrBall.strikeOrBall(computer, user);
        System.out.println(PrintResult.printResult(attempt));
        }
}

