package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 처음 시작
        boolean flag = true; //게임이 종료되었을 때 재시작과 종료를 확인할 수 있는 flag
        while (flag) {//게임 다시 시작할지 정하는 flag
            flag = game.start();
        }
        Console.close();
    }
}
