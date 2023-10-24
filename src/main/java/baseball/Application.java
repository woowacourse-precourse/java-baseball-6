package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameState = true;
        startGame(gameState);
    }

    public static void startGame(boolean gameState) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (gameState) {

            int strikeCount = 0;
            int ballCount = 0;
            String result;

            System.out.println("숫자를 입력해 주세요: ");
            List<Integer> player = new ArrayList<>();

            List<Integer> computerBall = new ArrayList<>();
            List<Integer> playerBall = new ArrayList<>();

            // playerInput에 플레이어가 입력한 값 저장
            String playerInput = Console.readLine();

            try {
                // 플레이어가 3자리를 입력하지 않을 경우 예외 처리
                if (playerInput.length() != 3) {
                    throw new IllegalArgumentException("3자리 수로 입력해 주세요.");
                }

                for (int i = 0; i < playerInput.length(); i++) {
                    char playChar = playerInput.charAt(i);

                    // 플레이어가 숫자가 아닌 값을 입력할 경우 예외 처리
                    if (!Character.isDigit(playChar)) {
                        throw new IllegalArgumentException("숫자로 입력해 주세요.");
                    }

                    int playerNum = Character.getNumericValue(playChar);

                    // 플레이어가 입력한 수 중 같은 수가 있을 경우 예외 처리
                    if (player.contains(playerNum)) {
                        throw new IllegalArgumentException("서로 다른 수로 입력해 주세요.");
                    }

                    // 플레이어가 0을 입력했을 경우 예외 처리
                    if (playerNum == 0) {
                        throw new IllegalArgumentException("1부터 9까지의 숫자로 입력해 주세요.");
                    }
                    player.add(playerNum);
                }

                // 스트라이크 수 확인
                for (int s = 0; s < 3; s++) {

                    if (computer.get(s) == player.get(s)) {
                        strikeCount++;
                    } else {
                        computerBall.add(computer.get(s));
                        playerBall.add(player.get(s));
                    }
                }
                if (strikeCount == 3) {
                    result = strikeCount + "스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                    System.out.println(result);
                    gameState = false;
                    endGame();
                }

                // 볼 수 확인
                for (int b = 0; b < playerBall.size(); b++) {
                    if (computerBall.contains(playerBall.get(b))) {
                        ballCount++;
                    }
                }

                if (strikeCount > 0 && strikeCount < 3 && ballCount == 0) {
                    result = strikeCount + "스트라이크";
                    System.out.println(result);
                } else if (strikeCount == 0 && ballCount != 0) {
                    result = ballCount + "볼";
                    System.out.println(result);
                } else if (strikeCount != 0 && ballCount != 0) {
                    result = ballCount + "볼 " + strikeCount + "스트라이크 ";
                    System.out.println(result);
                } else if (strikeCount == 0 && ballCount == 0) {
                    result = "낫싱";
                    System.out.println(result);
                }
            }
            // 플레이어가 입력한 값에 대한 예외 처리
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }

    public static void endGame() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        try {
            String choice = Console.readLine();
            switch (choice) {
                case "1":
                    startGame(true);
                    break;
                case "2":
                    System.out.println("게임 종료");
                    break;
                default:
                    throw new IllegalArgumentException("1(재시작)과 2(종료) 중 선택해 주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
