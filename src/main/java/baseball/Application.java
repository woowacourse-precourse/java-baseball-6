package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 게임 종료 조건
        boolean gameRunning = true;

        // 컴퓨터 3자리수 선택
        List<Integer> computerChooseNumber = computerChooseNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameRunning) {
            // 플레이어 변수 초기화
            int player = 0;
            List<Integer> playerChooseNumber = new ArrayList<>();

            System.out.print("3자리 숫자를 입력해주세요 : ");
            // 플레이어가 문자를 입력했을 경우 IllegalArgumentException 발생
            try {
                player = Integer.valueOf(Console.readLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }

            // 플레이어가 선택한 숫자 List 형식으로 변환
            while (player > 0) {
                int digit = player % 10;
                playerChooseNumber.add(0, digit);
                player /= 10;
            }

            // 플레이어가 3자리수가 아닌 숫자를 입력했을 경우 IllegalArgumentException 발생
            if (playerChooseNumber.size() != 3) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }

            System.out.printf("선택한 숫자는 %s 입니다.", playerChooseNumber.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining("")));

            // 스트라이크 계산 로직
            int strike = calculateStrikes(computerChooseNumber, playerChooseNumber);
            // 볼 계산 로직
            int ball = calculateBalls(computerChooseNumber, playerChooseNumber);

            // 게임결과 확인 및 종료 로직
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int gameContinue = Integer.valueOf(Console.readLine());
                if (gameContinue == 2) {
                    gameRunning = false;
                } else if (gameContinue == 1) {
                    computerChooseNumber = computerChooseNumber();
                } else {
                    System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                    gameRunning = false;
                }
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else {
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            }

        }



    }

    // Strike 계산
    private static int calculateStrikes(List<Integer> computerChooseNumber, List<Integer> playerChooseNumber) {
        int strike = 0;

        for (int i = computerChooseNumber.size()-1; i >= 0; i--) {
            if (computerChooseNumber.get(i).equals(playerChooseNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    // ball 계산
    private static int calculateBalls(List<Integer> computerChooseNumber, List<Integer> playerChooseNumber) {
        int ball = 0;

        for (int i = computerChooseNumber.size()-1; i >= 0; i--) {
            if (!computerChooseNumber.get(i).equals(playerChooseNumber.get(i))) {
                if (playerChooseNumber.contains(computerChooseNumber.get(i))) {
                    ball += 1;
                }
            }
        }
        return ball;
    }

    // 상대방 3자리 숫자 선택
    private static List<Integer> computerChooseNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
