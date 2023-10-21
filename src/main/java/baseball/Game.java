package baseball;

public class Game {
    private Computer computer;

    private Game(Computer computer) {
        this.computer = computer;
    }

    private static class LazyHolder{
        public static final Game INSTANCE=new Game(Computer.getInstance());
    }

    public static Game getInstance(){
        return LazyHolder.INSTANCE;
    }
}
