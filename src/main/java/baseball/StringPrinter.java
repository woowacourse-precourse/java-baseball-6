package baseball;

public class StringPrinter {
    private static StringPrinter instance;

    private StringPrinter() {}

    public static StringPrinter getInstance() {
        if (instance == null) {
            instance = new StringPrinter();
        }
        return instance;
    }


    public void printPlayerInput(){
        System.out.println("\n숫자를 입력해주세요 : ");
    }

    public void printEndOfGame(){
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGuessResult(int ballCounter, int strikeCounter){
        if (ballCounter == 0 && strikeCounter == 0) {
            System.out.print("낫싱");
            return;
        }

        if (ballCounter > 0){
            System.out.print(ballCounter + "볼 ");
        }
        if (strikeCounter > 0) {
            System.out.print(strikeCounter + "스트라이크 ");
        }
    }
}
