package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class Game {
    public Game() {
    }

    public void playGame() {
        Number computerNumber = new Number();
        computerNumber.setRandomNumber();
        while (true) {
            Number userNumber = new Number();
            userNumber.inputUser();

            List<Integer> computerList = computerNumber.getComputerList();
            List<Integer> userList = userNumber.getUserList();

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computerList.get(i).equals(userList.get(j))) {
                        if (i == j) {
                            strike++;
                            break;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            resultScore(strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                restartGame();
            }
        }
    }

    public void restartGame(){
        // 게임 재시작 여부 묻기
        System.out.println("게임을 재시작하시겠습니까? (1: 재시작, 2: 종료)");
        String restartChoice = Console.readLine();
        int restartChoiceFormat;

        try {
            restartChoiceFormat = Integer.parseInt(restartChoice);
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력하세요.");
            return;
        }
        if (restartChoiceFormat == 1) {
            playGame(); // 게임 재시작
        } else if (restartChoiceFormat == 2) {
            return; // 게임 종료
        } else {
            System.out.println("1 또는 2를 입력 하세요.");
        }
    }

    private void resultScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
