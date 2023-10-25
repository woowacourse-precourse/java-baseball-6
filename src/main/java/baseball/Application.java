package baseball;

/**
 * 프로그램 실행시키는 Main 함수가 있는 클래스
 */
public class Application {
    /**
     * 숫자 야구 게임 시작 멘트 출력, 게임 객체 생성 및 실행, 재시작하는 코드 구현
     * @param args
     */
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (restart == 1) {
            BaseballGame baseBallGame = new BaseballGame();
            User user = new User();
            baseBallGame.gameStart(user);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = user.inputRestartNumber();
        }
    }
}
