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

        System.out.println(Message.GAME_START);

        computer.pickComputerNumbers();
        player.pickPlayerNumbers();
        gameMachine = new GameMachine(computer.getComputerNumbers(), player.getPlayerNumbers());
        computer.setGameMachine(gameMachine);
        while (!isFinished) {
            gameResult = computer.activateMachine();
            ball = gameResult.getBall();
            strike = gameResult.getStrike();
            if (ball == 0 && strike == 0) {
                System.out.println(Message.NOTHING);
            } else if (strike == 0) {
                System.out.println(ball + Message.BALL);
            } else if (ball == 0) {
                System.out.println(strike + Message.STRIKE);
                if (strike == STRIKE_COUNT_TO_FINISH) {
                    System.out.println(Message.GAME_FINISH);
                    isFinished = true;
                }
            }
            if (ball != 0 && strike != 0) {
                System.out.println(ball + Message.BALL + strike + Message.STRIKE);
            }
            // 실패 시 playerNumbers 수정
            if (!isFinished) {
                player.pickPlayerNumbers();
                computer.setPlayerNumbers(player.getPlayerNumbers());
                computer.changeGameMachinePlayerNumbers();
            }
            // 게임 종료 후 재시작 여부 묻기
            if (isFinished) {
                System.out.println(Message.GAME_RESTART_OR_QUIT);
                if (Console.readLine().equals(Message.RESTART)) {
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
