package baseball;

public class Print {
    private static final Print print = new Print();
    private Print() {}
    public static Print getPrint() {
        return print;
    }

    // 게임 시작
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 결과 출력
    public void resultGame(int[] result) {
        if (result[0] + result[1] == 0) System.out.println("낫싱");
        else if (result[0] == 0 && result[1] != 0) System.out.println(result[1] + "볼");
        else if (result[1] == 0 && result[0] != 0) System.out.println(result[0] + "스트라이크");
        else System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
    }
}
