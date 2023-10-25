package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            HashSet<String> computerHash = new HashSet<>();
            while (computerHash.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                String randomString = String.valueOf(randomNumber);
                computerHash.add(randomString);
            }
            String computer = String.join("", computerHash);

            boolean isAllStrike = false;

            while (!isAllStrike) {
                System.out.print("숫자를 입력해주세요 : ");
                String user = Console.readLine();
                if (user.length() > 3) {
                    throw new IllegalArgumentException("예외");
                }

                // 다른 자릿수, 같은 숫자
                int ballCount = 0;
                for (int i = 0; i < 3; i++) {
                    if ((computer.contains(String.valueOf(user.charAt(i)))
                            && (computer.charAt(i) != user.charAt(i)))) {
                        ballCount++;
                    }
                }

                // 같은 자릿수, 같은 숫자
                int strikeCount = 0;

                for (int i = 0; i < 3; i++) {
                    if (computer.charAt(i) == user.charAt(i)) {
                        strikeCount++;
                    }
                }

                // 비교 결과
                String hint = "";
                if (ballCount > 0) {
                    hint += ballCount + "볼";
                }
                if (strikeCount > 0) {
                    if (!hint.isEmpty()) {
                        hint += " ";
                    }
                    hint += strikeCount + "스트라이크";
                }
                if (strikeCount == 0 && ballCount == 0) {
                    hint = "낫싱";
                }
                System.out.println(hint);

                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isAllStrike = true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();

            if (userInput.equals("2")) {
                System.out.println("게임 종료");
                break;
            } else if (!userInput.equals("1") && !userInput.equals("2")) {
                throw new IllegalArgumentException();
            }
        }
    }
}