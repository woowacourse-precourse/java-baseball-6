package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        final int STRIKE_COUNT_TO_FINISH = 3;
        Computer computer = new Computer();
        Player player = new Player();
        GameMachine gameMachine;
        GameResult gameResult;
        boolean isFinished = false;
        int ball = 0;
        int strike = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        computer.pickComputerNumbers();
        player.pickPlayerNumbers();
        gameMachine = new GameMachine(computer.getComputerNumbers(), player.getPlayerNumbers());
        computer.setGameMachine(gameMachine);
        while (!isFinished) {
            gameResult = computer.activateMachine();
            ball = gameResult.getBall();
            strike = gameResult.getStrike();
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
                if (strike == STRIKE_COUNT_TO_FINISH) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isFinished = true;
                }
            }
            if (ball != 0 && strike != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
            // 실패 시 playerNumbers 수정
            if (!isFinished) {
                player.pickPlayerNumbers();
                computer.setPlayerNumbers(player.getPlayerNumbers());
                computer.changeGameMachinePlayerNumbers();
            }
            // 게임 종료 후 재시작 여부 묻기
            if (isFinished) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if (Console.readLine().equals("1")) {
                    isFinished = false;
                    // 컴퓨터, 사용자 입력 새로 받고 게임머신 생성
                    computer.pickComputerNumbers();
                    player.pickPlayerNumbers();
                    gameMachine = new GameMachine(computer.getComputerNumbers(), player.getPlayerNumbers());
                    computer.setGameMachine(gameMachine);
                }
            }
        }
    }
}
