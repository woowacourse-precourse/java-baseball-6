package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static final int RESTART_CODE = 1;
    static final int EXIT_CODE = 2;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball baseball = new Baseball();
        int restartInput;
        do {
            baseball.initNumbers();
            baseball.startBaseball();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartInput = Integer.parseInt(Console.readLine());
            if((restartInput != RESTART_CODE) && (restartInput != EXIT_CODE)) {
                throw new IllegalArgumentException("에러:" + RESTART_CODE + ", " + EXIT_CODE + "이외의 값 입력");
            }
        } while(restartInput != EXIT_CODE);
    }

}
