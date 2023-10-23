package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static List<Integer> getGameScores(List<Integer> user, List<Integer> computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.get(i).equals(computer.get(j))) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        return Arrays.asList(ball, strike);
    }

    public static boolean isIllegalArgument(String str) {
        List<Character> legalValues = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

        // 세 글자가 아닌 경우 true
        if (str.length() != 3) {
            return true;
        } else {
            // 허용되지 않는 문자가 있는 경우 true
            for (int i = 0; i < 3; i++) {
                if (!legalValues.contains(str.charAt(i))) {
                    return true;
                }
            }

            // 중복되는 경우 true
            if (str.charAt(0) == str.charAt(1) ||
                    str.charAt(0) == str.charAt(2) ||
                    str.charAt(1) == str.charAt(2)) {
                return true;
            };

            // 모든 체크 통과 -> false
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = false; // 종료 플래그

        while (true) {
            // 컴퓨터 랜덤 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int digit = pickNumberInRange(1, 9);
                if (!computer.contains(digit)) {
                    computer.add(digit);
                }
            }

            while (true) {
                // 사용자 입력
                System.out.print("숫자를 입력해주세요 : ");
                String userNums = readLine();
                if (isIllegalArgument(userNums)) {
                    throw new IllegalArgumentException();
                }

                // 사용자 입력값 -> List 변환
                List<Integer> user = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    int digit = Character.getNumericValue(userNums.charAt(i));
                    user.add(digit);
                }

                // 게임 결과 출력
                List<Integer> result = getGameScores(user, computer);
                int ball = result.get(0);
                int strike = result.get(1);

                if (ball > 0 && strike == 0) {
                    // ball only
                    System.out.println(ball + "볼");
                } else if (ball == 0 && strike > 0) {
                    // strike only
                    System.out.println(strike + "스트라이크");
                } else if (ball > 0 && strike > 0) {
                    // ball and strike
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else {
                    // nothing
                    System.out.println("낫싱");
                }

                // 게임 승리
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String newStart = readLine();
                    if (newStart.equals("1")) {
                        break;
                    } else if (newStart.equals("2")) {
                        flag = true;
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }

            if (flag) {
                break;
            }
        } // 무한루프 끝
    }
}
