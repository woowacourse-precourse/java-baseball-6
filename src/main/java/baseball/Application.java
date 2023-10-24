package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;
import util.Validate;
import util.RandomThreeNumber;

public class Application {

    private static final int STRIKE_MAX = 3; //3스트라이크
    
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameRunning = true;

        while (isGameRunning) {
            playBaseballGame();
            isGameRunning = askForRestart();
        }
    }

    private static void playBaseballGame() {
        String answer = RandomThreeNumber.getRandomNumber(); //정답!
        int strikeCount = 0;
        
        while (strikeCount < STRIKE_MAX) {
            String playerInput = getPlayerInput();
            Validate.validate_InputDataCheck(playerInput);

            char[] correctNumbers = answer.toCharArray();
            char[] playerNumbers = playerInput.toCharArray();
            
            //TODO:strike 우선처리하고, ball 후처리
            strikeCount = calculateStrike(correctNumbers, playerNumbers);
            int ballCount = calculateBall(correctNumbers, playerNumbers);

            displayResult(strikeCount, ballCount);
            
            if (strikeCount == STRIKE_MAX) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

    private static String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static int calculateStrike(char[] correctNumbers, char[] playerNumbers) {
        int strike = 0;
        for (int i = 0; i < correctNumbers.length; i++) {
            if (correctNumbers[i] == playerNumbers[i]) {
                strike++;
                playerNumbers[i] = ' ';
            }
        }
        return strike;
    }

    private static int calculateBall(char[] correctNumbers, char[] playerNumbers) {
        int ball = 0;
        for (int i = 0; i < correctNumbers.length; i++) {
            for (int j = 0; j < playerNumbers.length; j++) {
                if (correctNumbers[i] == playerNumbers[j]) {
                    ball++;
                    playerNumbers[j] = 'x';
                }
            }
        }
        return ball;
    }
    
    //스트라이크, 볼 표시
    private static void displayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼");
        }
    }

    //게임재시작유무
    private static boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartOption = Integer.parseInt(Console.readLine());
        Validate.isGameStartValid(restartOption);

        return restartOption == 1; // 2=false
    }
}
