package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {

        boolean gameRunning = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (gameRunning) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> player = new ArrayList<>();
            String playerInput = Console.readLine();

            if (playerInput.length() != 3) {
                throw new IllegalArgumentException("입력값은 3자리의 정수여야 합니다.");
            }

            for (int i = 0; i < playerInput.length(); i++) {
                char c = playerInput.charAt(i);
                int number;


                try {
                    number = Integer.parseInt(String.valueOf(c));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("입력값은 정수여야 합니다.");
                }

                if (number < 1 || number > 9) {
                    throw new IllegalArgumentException("입력값은 1부터 9까지 중 하나의 정수여야 합니다.");
                }

                player.add(number);
            }

            int strike = 0;
            int ball = 0;

            for (int j = 0; j < 3; j++) {
                if (player.get(j).equals(computer.get(j))) {
                    strike++;
                } else if (computer.contains(player.get(j))) {
                    ball++;
                }
            }

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else {
                if (ball > 0) {
                    System.out.print(ball + "볼");
                }
                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.println();
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameRunning = false;
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String newGame = Console.readLine();
                if ("2".equals(newGame)) {
                    gameRunning = false;
                }
                else {
                    gameRunning = true;
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                }
            }

        }
    }
}
