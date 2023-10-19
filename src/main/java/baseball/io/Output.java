package baseball.io;

public class Output {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequestUserNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printHint(int[] result) {
        StringBuilder stringBuilder = new StringBuilder();
        if (result[0] != 0) {
            stringBuilder.append(result[0]).append("볼 ");
        }
        if (result[1] != 0) {
            stringBuilder.append(result[1]).append("스트라이크 ");
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append("낫싱");
        }
        System.out.println(stringBuilder);
    }

    public void printFinishOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"+"\n"+
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }

}
