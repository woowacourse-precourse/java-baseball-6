package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 정답(3자리 숫자) 생성
        List<Integer> tmp = new ArrayList<>();
        while (tmp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!tmp.contains(randomNumber)) {
                tmp.add(randomNumber);
            }
        }
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            target.append(tmp.get(i));
        }
        System.out.println(target); // 테스트용

        // 게임 시작, 입력 받기
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String ans = Console.readLine();

            // 입력 유효성 검사 1. 빈 입력값 확인
            if (ans.isEmpty()) {
                throw new IllegalArgumentException("1~9까지의 중복되지 않는 수만 입력해주세요.[에러 - 빈 입력값]");
            }
            ans = ans.replaceAll(" ", "");
            // 입력 유효성 검사 2. 숫자가 아닌 입력값(문자열) 확인
            try {
                Integer.parseInt(ans);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("1~9까지의 중복되지 않는 수만 입력해주세요.[문자열 입력]");
            }
            // 입력 유효성 검사 3. 0이 포함되어 있는가?
            for (int i = 0; i < 3; i++) {
                if (ans.charAt(i) == '0') {
                    throw new IllegalArgumentException("1~9까지의 중복되지 않는 수만 입력해주세요.[0 입력]");
                }
            }
            // 입력 유효성 검사 4. 숫자이지만 3자리가 아닌 입력값 확인
            if (ans.length() != 3) {
                throw new IllegalArgumentException("1~9까지의 중복되지 않는 수만 입력해주세요.[입력 길이]");
            }
            // 입력 유효성 검사 5. 숫자이며, 3자리이지만 중복되는 입력값 확인
            if (ans.charAt(0) == ans.charAt(1) || ans.charAt(0) == ans.charAt(2) || ans.charAt(1) == ans.charAt(2)) {
                throw new IllegalArgumentException("1~9까지의 중복되지 않는 수만 입력해주세요.[중복값 입력]");
            }

            // 정답 확인하기 - 볼
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j && ans.charAt(i) == target.charAt(j)) {
                        ballCount++;
                    }
                }
            }
            // 정답 확인하기 - 스트라이크
            int strCount = 0;
            for (int i = 0; i < 3; i++) {
                if (ans.charAt(i) == target.charAt(i)) {
                    strCount++;
                }
            }
            // 정답 확인하기 - 볼, 스트라이크, 낫싱 출력하기
            if (ballCount != 0 && strCount == 0) {
                System.out.printf("%d볼 ", ballCount);
                System.out.println();
            }
            if (ballCount == 0 && strCount != 0) {
                System.out.printf("%d스트라이크", strCount);
                System.out.println();
            }
            if (ballCount != 0 && strCount != 0) {
                System.out.printf("%d볼 ", ballCount);
                System.out.printf("%d스트라이크", strCount);
                System.out.println();
            }
            if (ballCount == 0 && strCount == 0) {
                System.out.println("낫싱");
            }
            // 프로그램 종료하기
            if (strCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String temp2 = Console.readLine();
                // 1. 빈 입력값
                if (temp2.isEmpty()) {
                    throw new IllegalArgumentException("1 또는 2만 입력해주세요.[빈 입력값]");
                }
                // 2. 문자열 입력
                int reset;
                try {
                    reset = Integer.parseInt(temp2);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("1 또는 2만 입력해주세요.[문자열 입력]");
                }
                // 3. 1 또는 2가 아닌 수 입력
                if (reset != 1 && reset != 2) {
                    throw new IllegalArgumentException("1 또는 2만 입력해주세요.[다른 수 입력]");
                }
                if (reset == 1) {
                    System.out.println("숫자 야구 게임을 시작합니다.");
                }
                if (reset == 2) {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
            }
        }
    }
}
