package baseball;

public class Application {
    public static void main(String[] args) {
        int restart = 1;
        Computer com = new Computer();
        User user = new User();
        Compare comp = new Compare();
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(restart == 1) {
            comp.startCompare();
            restart = game.restart();
            if(restart == 2) {
                break;
            }
        }
    }
}
