package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // FEAT : 2. 게임 시작 전 문구를 출력하는 기능
        System.out.println("숫자 야구 게임을 시작합니다.");
        // end
        Boolean newGame = true;
        while (newGame) {
            // FEAT : 1. 서로 다른 임의의 수(1에서 9까지) 3개를 선택하는 기능
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // end
            Boolean isBegin = true;
            while (isBegin) {
                // FEAT : 3. 사용자에게 수를 입력받는 기능
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                // end
                // FEAT : 4. 사용자가 잘못된 값을 입력할 경우 예외를 발생시키는 기능
                List<Integer> user = new ArrayList<>();
                if (userInput != null && userInput.length() == 3 && userInput.matches("[1-9.]+")) {
                    for (int i = 0; i < userInput.length(); i++) {
                        int parseNumber = userInput.charAt(i) - '0';
                        user.add(parseNumber);
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                // end

                // FEAT : 5. 컴퓨터 수와 사용자가 입력한 수를 비교하는 기능
                // 스트라이크
                int strike = 0;

                int[] computerNumber = new int[10];
                int[] userNumber = new int[10];

                for (int i = 0; i < 3; i++) {

                    computerNumber[computer.get(i)]++;
                    userNumber[user.get(i)]++;
                    if (computer.get(i) == user.get(i)) {
                        strike++;
                    }
                }

                // 볼
                int ball = 0;
                if (strike < 3) {
                    for (int i = 1; i <= 9; i++) {
                        if (userNumber[i] > 0) {
                            ball += computerNumber[i];
                        }
                    }
                    ball -= strike;
                }
                // end
                // FEAT : 6. 사용자에게 힌트를 출력하는 기능
                if (strike == 0 && ball == 0){
                    System.out.print("낫싱");
                }
                if (ball > 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.print("\n");
                // FEAT : 7. 게임을 종료 문구를 출력하는 기능

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isBegin = false;

                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restartRequested = Console.readLine();
                    if (restartRequested.equals("1")|| restartRequested.equals("2")) {
                        if (restartRequested.equals("2")) {
                            newGame = false;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                    // end
                    // FEAT : 8. 개임 재시작 여부를 입력받는 기능

                    // end

            }
            // end
        }
        return ;
    }

}