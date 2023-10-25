package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Integer> computerNums;
    public Application(){
        computerNums = getComputerNums();
    }
    private List<Integer> getComputerNums() {
        List<Integer> computerNums = new ArrayList<>();

        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }

        return computerNums;
    }

    private List<Integer> parseInput(String input) {
        List<Integer> parsedNums = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            int num = Character.getNumericValue(c);

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }

            if (parsedNums.contains(num)) {
                throw new IllegalArgumentException();
            }

            parsedNums.add(num);
        }

        return parsedNums;
    }

    private int getStrike(List<Integer> computerNums, List<Integer> playerNums) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNums.get(i).equals(computerNums.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    private int getBall(List<Integer> computerNums, List<Integer> playerNums) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNums.contains(computerNums.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    public void playGame() {
        String gameStart = new String("1");

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 진행
        while (gameStart.equals("1")) {
            // 임의 숫자 생성
            List<Integer> computerNums = getComputerNums();

            // 플레이어 입력
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Integer> playerNums = parseInput(input);
            int strike = getStrike(computerNums, playerNums);
            int ball = getBall(computerNums, playerNums);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameStart = Console.readLine();
            } else if (strike > 0 && ball > 0){
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball > 0) {
                System.out.println(ball + "볼");
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.playGame();
    }
}