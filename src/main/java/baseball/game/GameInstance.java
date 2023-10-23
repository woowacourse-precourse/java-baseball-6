package baseball.game;


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

    private ComputerPlayer computerPlayer;
    private UserPlayer userPlayer;


    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private int strikeCnt = 0;
    private int ballCnt = 0;

    private boolean destroy = false;
    public void game() {
        do {
            startGame();
            System.out.println(RESTART_GAME_MESSAGE);
            mode = Integer.parseInt(Console.readLine());
            if(mode == 2) destroy = true;
        } while (!destroy);
    }

    public void startGame() {
        initGame();
        System.out.println(START_GAME_MESSAGE);
        while(strikeCnt < 3) {
            userPlayer.input();
            calculateStrikeBall(userPlayer.getUserNumber(), computerPlayer.getComputerNumber());
            printResult();
        }
    }

    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";

    public void printResult() {
        StringBuilder sb = new StringBuilder();

        if (ballCnt == 0 && strikeCnt == 0) sb.append("낫싱");
        if (ballCnt > 0) sb.append(ballCnt).append("볼 ");
        if (strikeCnt > 0) sb.append(strikeCnt).append("스트라이크 ");
        sb.append("\n");

        if(strikeCnt == 3) {
            sb.append(THREE_STRIKE_MESSAGE).append("\n");
        }

        System.out.printf(sb.toString());
    }

    public void calculateStrikeBall(List<Integer> userNumberList, List<Integer> computerNumberList) {
        int strike = 0, ball = 0;

        for (int i = 0; i < userNumberList.size(); i++) {
            if (computerNumberList.get(i).equals(userNumberList.get(i))) {
                strike++;
            } else if (computerNumberList.contains(userNumberList.get(i))) {
                ball++;
            }
        }

        strikeCnt = strike;
        ballCnt = ball;
    }

    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int mode = 0;

    public void initGame() {
        computerPlayer = new ComputerPlayer();
        userPlayer = new UserPlayer();
        strikeCnt = 0;
        ballCnt = 0;
        destroy = false;
    }

    public void resetGame() {
        Console.close();
    }
}
