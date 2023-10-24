package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int isPlaying = 1;
        while (isPlaying == 1) {
            List<Integer> randomNumbers = new ArrayList<>();
            while (randomNumbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!randomNumbers.contains(randomNumber)) {
                    randomNumbers.add(randomNumber);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                Integer userNumber = Integer.valueOf(readLine());
                if (
                        userNumber < 100
                                || userNumber > 999
                                || userNumber.toString().length() != 3
                                || userNumber.toString().contains("0")
                                || userNumber.toString().chars().distinct().count() != 3
                ) {
                    throw new IllegalArgumentException();
                }

                int strike = 0;
                int ball = 0;
                for (int i = 0; i < 3; i++) {
                    int userDigit = Integer.parseInt(userNumber.toString().substring(i, i + 1));
                    if (randomNumbers.get(i) == userDigit) {
                        strike++;
                    } else if (randomNumbers.contains(userDigit)) {
                        ball++;
                    }
                }

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    break;
                } else if (strike > 0 || ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else {
                    System.out.println("낫싱");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isPlaying = Integer.parseInt(readLine());
            if (isPlaying != 1 && isPlaying != 2) {
                throw new IllegalArgumentException();
            }
            if (isPlaying == 2) {
                System.out.println("게임 종료");
            }
        }
    }
}
