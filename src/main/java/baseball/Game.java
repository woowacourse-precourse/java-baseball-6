package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computerNumber = shuffleNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String userNumber = Console.readLine();
            checkNumber(userNumber);

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < computerNumber.length(); i++) {
                char computerDigit = computerNumber.charAt(i);
                char userDigit = userNumber.charAt(i);
                if (strikeCount(computerDigit, userDigit)) {
                    strike += 1;
                    continue;
                }
                if (ballCount(computerNumber, String.valueOf(userDigit))) {
                    ball += 1;
                }
            }

            if (ball != 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike != 0) {
                System.out.print(strike + "스트라이크");
            }
            if (strike == 0 && ball == 0) {
                System.out.print("낫싱");
            }
            System.out.println();

            if (strike == 3) {
                int reStartValue;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                reStartValue = Integer.parseInt(Console.readLine());
                if (reStartValue != 1 && reStartValue != 2) {
                    throw new IllegalArgumentException("1 혹은 2의 값만 입력해주세요");
                }

                if (reStartValue == 2) {
                    break;
                }

                computerNumber = shuffleNumber();
            }
        }

    }

    private String shuffleNumber() {
        // 랜덤값 생성
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return String.join("", computer);
    }

    private void checkNumber(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("3개의 값을 입력해주세요");
        }
        if (!userNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
        String tmp = "";
        for (char c : userNumber.toCharArray()) {
            if (tmp.contains(String.valueOf(c))) {
                throw new IllegalArgumentException("중복되지 않는 숫자로 입력해주세요");
            }
            tmp += String.valueOf(c);
        }
    }

    private boolean ballCount(String computerNumber, String userNumber) {
        return computerNumber.contains(userNumber);
    }

    private boolean strikeCount(int computerNumber, int userNumber) {
        return computerNumber == userNumber;
    }
}