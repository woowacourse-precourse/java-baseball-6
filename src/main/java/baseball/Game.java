package baseball;

public class Game {
    boolean gameClear = false;

    public Game() {
        startAnnounce();
        gameIng();
    }

    private void gameIng() {
//        while (!gameClear) {
//
//        }
        gameClearAnnounce();
    }

    private void startAnnounce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void gameClearAnnounce() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
