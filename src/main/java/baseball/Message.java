package baseball;

public class Message {

    public void play() {
        System.out.println(Const.GAME_START);
    }

    public void input() {
        System.out.print(Const.INPUT_NUMBER);
    }

    public void end() {
        System.out.println(Const.GAME_EXIT);
    }

    public void restartOrExit() {
        System.out.println(Const.GAME_RESTART);
    }

}
