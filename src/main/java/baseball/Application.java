package baseball;


public class Application {

    public static void main(String[] args) {
        int exitNumber; // 종료 확인 숫자
        Game game = new Game(); // 게임 객체 생성
        //게임 시작 메세지 출력
        StartMessage();
        do {
            game.InitData();
            game.PlayGame();
            exitNumber = Input.ExitInput();
        } while (exitNumber == 1);
    }

    static void StartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
