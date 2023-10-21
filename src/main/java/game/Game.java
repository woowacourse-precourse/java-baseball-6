package game;

/**
 * description: 게임을 나타내는 인터페이스
 */
public interface Game {
    /**
     * description: 게임을 시작하는 메소드
     */
    void start();

    /**
     * description: 게임을 종료하는 메소드
     */
    void end();

    /**
     * description: 게임을 재시작할지 여부를 반환하는 메소드
     *
     * @return 게임을 재시작할지 여부
     */
    boolean isRestart();
}
