package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.startGame();
    }
}

class GameController {
    private boolean isRunning = true;
    private Game game;

    public GameController() {
        this.game = new Game();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isRunning) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (input.equals("1")) {
                isRunning = true;
                game = new Game();

            } else if (input.equals("2")){
                isRunning = false;

            } else {
                isRunning = false;
                throw new IllegalArgumentException();
            }
        }
    }



    private void playGame() {
        List<Integer> computerNumber = game.getComputerNumber();

        while (isRunning) {
            List<Integer> playerNumber = game.getPlayerResponse();
            int strikes = 0;
            int balls = 0;
            for (int i = 0; i < 3; i++) {
                if (playerNumber.get(i).equals(computerNumber.get(i))) {
                    strikes++;
                } else if (computerNumber.contains(playerNumber.get(i))) {
                    balls++;
                }
            }
            game.printResult(strikes, balls);

            if (strikes == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}

class Game {
    private List<Integer> computerNumber;

    public Game() {
        this.computerNumber = makeRandomNumber();
    }

    public List<Integer> getComputerNumber() {

        return computerNumber;
    }
    public List<Integer> getPlayerResponse() {
        System.out.print("숫자를 입력해주세요 : ");
        String response = Console.readLine();

        if (response.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> playerNumber = new ArrayList<>();
        for (int i=0; i<response.length(); i++) {
            char now = response.charAt(i);
            playerNumber.add(Character.getNumericValue(now));
        }
        return playerNumber;
    }

    public void printResult(int strikes, int balls) {
        if(strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
        else if (balls > 0) {
            System.out.println(balls + "볼");
        }
        else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        }
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
