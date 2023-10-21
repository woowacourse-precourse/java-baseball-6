package baseball;

public class Game {
    private Computer computer;
    private final String GAME_START="숫자 야구 게임을 시작합니다.";
    private final String GAME_END="3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private Game(Computer computer) {
        this.computer = computer;
    }

    private static class LazyHolder{
        public static final Game INSTANCE=new Game(Computer.getInstance());
    }

    public static Game getInstance(){
        return LazyHolder.INSTANCE;
    }

    private void printGameStart(){
        System.out.println(GAME_START);
    }

    private void printGameEnd(){
        System.out.println(GAME_END);
    }
}
