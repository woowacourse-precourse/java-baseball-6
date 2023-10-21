package baseball;


public class Display {
    // 게임 시작 메시지 출력
    public static void printStartMessage(Boolean isFirstStart) {
        if (isFirstStart == true) {
            return;
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
