package baseball;

public class Application {
    public static void main(String[] args){
        int[] computerInput = {1,3,5,5,8,9};
        BaseballGame game = BaseballGame.getInstance();
        game.run(computerInput);
    }
}

