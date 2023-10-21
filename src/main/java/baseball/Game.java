package baseball;

/**
 * @Class : 야구 게임 클래스
 * @auther : SYB
 * @since : 2023/10/21
 */
public class Game {
    private final int REPLAY_GAME = 1;
    private final int EXIT_GAME = 0;


    /**
     *  @Method  : 게임 시작
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    public void start() {
        //게임 시작 처리
        System.out.println(MessageType.START.getMessage());

        //게임 진행
        int replayChoice = REPLAY_GAME;
        while (replayChoice == REPLAY_GAME) {
            replayChoice = play();
        }
    }


    private int play() {
        return EXIT_GAME;
    }
}
