package baseball;
import baseball.Computer.Computer;
import baseball.Play.Play;
import baseball.User.User;


public class Application {
    static Integer restart = 0;
    public static void main(String[] args) {
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
        Play();
        // TODO: 프로그램 구현
        if(restart == 1) {
            Play();
        }
    }
    public static void Play() {
        Play play = new Play();
        play.PlayGame();
        while(play.getStrikes() != 3) {
            play.PlayGame();
        }
        restart = play.getRestart();
    }
}
