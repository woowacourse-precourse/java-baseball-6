package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Pattern;

public class Application {
    // 숫자 야구 입력 정규식
    static final Pattern INPUT_PATTERN = Pattern.compile("^\\d{3}$");
    // 숫자 야구 종료 정규식
    static final Pattern QUIT_PATTERN = Pattern.compile("[12]");

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(Randoms.pickNumberInRange(1, 9));
        }
        String answer = sb.toString();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            // 데이터 검증
            String input = Console.readLine();
            if (!INPUT_PATTERN.matcher(input).matches()) {
                throw new IllegalArgumentException("입력은 3자리 숫자만 가능해요");
            }

            System.out.println(getHint(input, answer));
            // 정답을 맞춘경우
            if (input.equals(answer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String quitInput = Console.readLine();
                if (!QUIT_PATTERN.matcher(quitInput).matches()) {
                    throw new IllegalArgumentException("입력은 1 혹은 2만 가능해요");
                }
                if ("2".equals(quitInput)) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb2.append(Randoms.pickNumberInRange(1, 9));
                }
                answer = sb2.toString();
            }
        }
    }

    public static String getHint(String input, String answer) {
        String[] inputArr = input.split("");
        String[] answerArr = answer.split("");
        int strikeCount = 0;
        int ballCount = 0;
        // 인풋 배열과 정답 배열을 탐색하며
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 같은 숫자인경우
                if (inputArr[i].equals(answerArr[j])) {
                    // 같은 자리인경우
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (ballCount > 0) {
            stringBuilder.append(ballCount + "볼");
        }
        if (strikeCount > 0) {
            if (ballCount > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strikeCount + "스트라이크");
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append("낫싱");
        }
        return stringBuilder.toString();
    }
}
