package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
    private static final String STRIKE = "스트라이크";
    private static final String SPACE = " ";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int START = 1;
    private static final int END = 2;
    private Computer computer;
    private User user;
    private List<Integer> comnum;
    private List<Integer> usernum;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void playBall() {
        // Game Logic Here
        System.out.println("숫자야구 게임을 시작합니다.");
        String inputString;
        while (true) {
            int game;
            int strikeCount = 0;
            int ballCount = 0;
            while (true) {
                computer.generateNumbers();
                comnum=computer.getNumbers();
                try {
                    user.inputNumbers();
                    usernum = user.getNumbers();
                } finally {

                }
                for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
                    for (int j = 0; j < BASEBALL_GAME_NUMBER_LENGTH; j++) {
                        //컴퓨터 생성 숫자의 i번째 인덱스와 맞추는 숫자의 모든 원소들을 비교
                        if (comnum.get(i) == usernum.get(j) && i == j) {
                            //같은 숫자가 있고 인덱스도 같으면 스트라이크
                            strikeCount++;
                        } else if (comnum.get(i) == usernum.get(j) && i != j) {
                            //같은 숫자만 있으면 볼
                            ballCount++;
                        }
                    }
                }
                //아무것도 맞추지 못하면 나씽
                if (strikeCount != 0 || ballCount != 0) {
                    System.out.println(ballCount + BALL + SPACE + strikeCount + STRIKE);
                } else {
                    System.out.println(NOTHING);
                }
                if (strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT) {
                    System.out.println(SUCCESS);
                    usernum.clear();
                    break;
                }
                usernum.clear();
                strikeCount = 0;
                ballCount = 0;
            }
            System.out.print(RESTART);
            comnum.clear();
            try {
                inputString = Console.readLine();
                game = Integer.parseInt(inputString);
                if (game != START && game != END) {
                    throw new IllegalArgumentException("Input must be either '1' or '2'.");
                } else if (game == START) {
                    continue;
                } else if (game == END) {
                    break;
                }
            } finally {
            }
        }

    }
}
