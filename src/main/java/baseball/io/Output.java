package baseball.io;

public class Output {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequestUserNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printHint(String result) {
        System.out.println(result);
    }

    public void printFinishOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"+"\n"+
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }

}
