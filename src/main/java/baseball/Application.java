package baseball;

public class Application {
    public static boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = camp.nextstep.edu.missionutils.Console.readLine();
        if(restart.equals("1")){
            return true;
        } else if (restart.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("재시작은 1, 종료는 2를 입력하세요.");
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            BaseBallGame sample = new BaseBallGame();
            sample.gameStart();
        }while (restartGame());
    }
}
