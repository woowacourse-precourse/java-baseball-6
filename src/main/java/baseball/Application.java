package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        String userInput;
        List<Integer> user;
        List<Integer> computer;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 랜덤값 생성
            computer = createRandomNum();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = Console.readLine();

                int ballCnt;
                int strikeCnt;

                // 사용자 입력값이 올바른지 검사
                user = validateNum(userInput);

                // 볼, 스트라이크 수 계산
                ballCnt = countBall(computer, user);
                strikeCnt = countStrike(computer, user);

                // 결과 출력 함수 호출
                if(showResult(ballCnt, strikeCnt)) break;
            }
            if(isExit()) break;
        }
    }

    private static List<Integer> createRandomNum() {
        // 서로 다른 수로 이루어진 3자리 수 랜덤 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static int countBall(List<Integer> computer, List<Integer> user) {
        int ballCnt = 0;
        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (computer.get(i).equals(user.get(j)) && i != j) {
                    ballCnt++;
                }
            }
        }
        return ballCnt;
    }

    private static int countStrike(List<Integer> computer, List<Integer> user) {
        int strikeCnt = 0;
        for (int i = 0; i < computer.size(); i++) {
            if(computer.get(i).equals(user.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private static boolean showResult(int ballCnt, int strikeCnt) {
        if (strikeCnt == 0) {
            if (ballCnt == 0) System.out.println("낫싱");
            else System.out.println(ballCnt + "볼");
        }
        else {
            if (ballCnt == 0) System.out.println(strikeCnt + "스트라이크");
            else System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
        if (strikeCnt == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static boolean isExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        return switch (userInput) {
            case "1" -> false;
            case "2" -> true;
            default -> throw new IllegalArgumentException("1 또는 2만 입력하세요.");
        };
    }

    private static List<Integer> validateNum(String userInput) {
        // 입력값 올바른 지 체크
        if (userInput.length() != 3) throw new IllegalArgumentException("세 자리 수를 입력하세요.");
        for (int i = 0; i < userInput.length(); i++) {
            if(userInput.charAt(i) - '0' < 1 && userInput.charAt(i) - '0' > 9)
                throw new IllegalArgumentException("숫자를 입력하세요");
        }

        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
