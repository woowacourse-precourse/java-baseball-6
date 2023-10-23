package baseball.game;

import static baseball.common.Constants.numDigit;

import baseball.player.ComputerPlayer;
import baseball.player.UserPlayer;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameInstance {
    public static GameInstance instance;

    public static GameInstance getInstance() {
        if(instance == null) {
            instance = new GameInstance();
        }
        return instance;
    }

    private ComputerPlayer computerPlayer = new ComputerPlayer();
    private UserPlayer userPlayer = new UserPlayer();


    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public void game() {
        startGame();
        // restartGame();
    }

    public void startGame() {
        initGame();
        System.out.println(START_GAME_MESSAGE);
        while(strikeCnt < 3) {
            userPlayer.input();
            calculateStrikeBall();
            printResult();
        }
    }

    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";

    public void printResult() {
        StringBuilder sb = new StringBuilder();


        if (ballCnt == 0 && strikeCnt == 0) sb.append("낫싱");
        if (ballCnt > 0) sb.append(ballCnt).append("볼 ");
        if (strikeCnt > 0) sb.append(strikeCnt).append("스트라이크 ");
        sb.append("\n");
        System.out.println(sb.toString());

        if(strikeCnt == 3) System.out.println(END_GAME_MESSAGE);
    }

    public void calculateStrikeBall() {
        List<Integer> userNumber = userPlayer.getUserNumber();
        List<Integer> computerNumber = computerPlayer.getComputerNumber();
        int strike = 0;
        int ball = 0;
        for(int idx = 0; idx < numDigit; idx++) {
            if(userNumber.get(idx).equals(computerNumber.get(idx)))  strike++;
            else if(computerNumber.contains(userNumber.get(idx))) ball++;
        }

        strikeCnt = strike;
        ballCnt = ball;
    }

    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int mode = 0;
//    public void restartGame() {
//        System.out.println(RESTART_GAME_MESSAGE);
//        mode = Integer.parseInt(Console.readLine());
//        Console.close();
//        if(mode == 1) startGame();
//    }

    public void initGame() {
        computerPlayer.pickNumber();
        strikeCnt = 0;
        ballCnt = 0;
    }
}
