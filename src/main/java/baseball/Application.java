package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        boolean gameStart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameStart) {
            playGame();

            // 재시작or종료 안내
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                String userInput = Console.readLine();

                int intUserInput = Integer.parseInt(userInput);

                if (intUserInput == 1 || intUserInput == 2) {
                    if (intUserInput == 2) {
                        gameStart = false;
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("입력한 값이 유효하지 않습니다.");
            }
        }
    }

    public static void playGame() {
        boolean isCorrect = false;

        // 정답 생성
        ArrayList<Integer> pickedNumbers = new ArrayList<>();
        while (pickedNumbers.size() < 3) {
            int pickedNum = Randoms.pickNumberInRange(1, 9);

            if (!pickedNumbers.contains(pickedNum)) {
                pickedNumbers.add(pickedNum);
            }
        }

        while (!isCorrect) {
            // 입력값 받기
            System.out.println("1부터 9까지의 서로 다른 3개의 숫자를 선택하여 입력해 주세요.");
            String playerInput = Console.readLine();

            try {
                int intplayerInput = Integer.parseInt(playerInput);

                if (playerInput.length() != 3) {
                    throw new IllegalArgumentException("입력한 값이 유효하지 않습니다.");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("입력한 값이 유효하지 않습니다.");
            }

            // 비교
            int cntStrike = 0;
            int cntBall = 0;

            for (int i = 0; i < 3; i++) {
                char charPlayerInput = playerInput.charAt(i);
                int digitPlayerInput = Character.getNumericValue(charPlayerInput);
                int digitComputerNum = pickedNumbers.get(i);

                if (pickedNumbers.contains(digitPlayerInput)) {
                    if (digitPlayerInput == digitComputerNum) {
                        cntStrike += 1;
                    } else {
                        cntBall += 1;
                    }
                }
            }

            // 결과 출력
            if (cntStrike > 0 || cntBall > 0) {
                if (cntBall == 0) {
                    System.out.println(cntStrike + "스트라이크");
                    if (cntStrike == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        isCorrect = true;
                    }
                } else if (cntStrike == 0) {
                    System.out.println(cntBall + "볼");
                } else {
                    System.out.println(cntBall + "볼 " + cntStrike + "스트라이크");
                }
            } else {
                System.out.println("낫싱");
            }
        }
    }
}
