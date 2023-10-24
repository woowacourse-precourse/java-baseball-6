package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO : 프로그램 구현
        // 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 야구 게임 프로세스를 담당하는 BaseballGame Class 초기화
        BaseballGame baseballGame = new BaseballGame();

        // 사용자가 종료를 원할 때까지 반복
        do {
            baseballGame.play();
        } while (baseballGame.choiceRestart());
    }
}
