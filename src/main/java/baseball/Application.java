package baseball;

/*
 * 클래스 이름
 * Application
 *
 * 버전 정보
 * 0.3
 *
 * 날짜
 * 2023/10/25
 *
 * 저작권 주의
 * Free Source
 */

public class Application {
    static final int COUNT_3 = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        start();

    }

    public static void start() {
        String select = "1";
        Game game = new Game();

        while (select.equals("1")) {
            String answer = RandNum.Make_Random_Num();
            game.play(answer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            select = Input.inSec();

        }
    }


}
