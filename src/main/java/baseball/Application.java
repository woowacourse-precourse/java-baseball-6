package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball_Game Game = new Baseball_Game();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exit_flag = false;
        while (!exit_flag) {
            Game.run();
            exit_flag = User_Input.Ask_Exit();
        }
    }
}
