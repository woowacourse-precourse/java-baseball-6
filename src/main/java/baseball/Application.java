package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        BaseballComputer baseballComputer = new BaseballComputer();
        boolean isFinished = false;
        do {
            baseballComputer.selectNumber();
            System.out.println("숫자 야구 게임을 시작합니다");
            baseballComputer.takeInputAndPrint();
            isFinished = baseballComputer.enterFinished();
        } while (!isFinished);
    }
}
