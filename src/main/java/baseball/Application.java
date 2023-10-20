package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean startGame = true;
        while (startGame) {

            // computer 정답 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            int computerNumber = 100 * computer.get(0) + 10 * computer.get(1) + computer.get(2);
            String computerNumberStr = Integer.toString(computerNumber);

            // 숫자 입력 - 정답과 비교 - 힌트 출력 반복
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userNumberStr = readLine();
                System.out.println(userNumberStr);

                if (computerNumberStr.equals(userNumberStr)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                // 입력 오류 없는지 확인
                boolean isDifferentThreeDigit = isDifferentThreeDigit(userNumberStr);
                if (isDifferentThreeDigit) continue;

            }

            // 정답일 경우
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String decisionGame = readLine();
            if (decisionGame.equals("2")) {
                System.out.println("게임을 종료합니다.");
                startGame = false;
            } // 2 입력시 게임 종료
            else if (decisionGame.equals("1")) {
                System.out.println("게임을 재시작합니다.");
            } // 1 입력시 게임 재시작
        }

    }

    public static boolean isDifferentThreeDigit(String userNumberStr) {
        // 숫자가 아닐 때
        try {
            Integer.parseInt(userNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        // 3자리가 아닐때
        if (userNumberStr.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        // 같은 숫자가 있을 때
        char digit1 = userNumberStr.charAt(0);
        char digit2 = userNumberStr.charAt(1);
        char digit3 = userNumberStr.charAt(2);
        if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자가 아닙니다.");
        }
        return true;
    }
}

class Game {

}