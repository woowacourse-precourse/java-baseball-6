package baseball;

public class Application {

    public static final boolean IS_TEST = false;        // 정답 출력 여부 설정, 제출 시에는 false

    public static void main(String[] args) {
        int end = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        Baseball b = new Baseball();
        // 게임 진행
        while (end == 1) {
            end = b.startGame();
        }

    }
}
