package baseball.view;

public class OutputView {
    // 게임 시작 메시지
    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 결과 메시지 출력
    public static void printGameResult(int strikes, int balls) {
        if (strikes == 3 && balls == 0) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strikes > 0) {
            System.out.print(strikes + "스트라이크 ");
        } else if (balls > 0) {
            System.out.print(balls + "볼");
        } else {
            System.out.println("낫싱");
        }

        System.out.println();
    }

}
