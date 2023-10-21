package baseball;


public class Application {
    public static void main(String[] args) {
        Baseball bg = new Baseball();
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean gaming = true;
        while(gaming) {
            gaming = bg.playBaseballGame();
        }
    }
}
