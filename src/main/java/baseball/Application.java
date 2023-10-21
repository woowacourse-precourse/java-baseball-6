package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumbersBaseballManager numbersBaseballManager = new NumbersBaseballManager();
        numbersBaseballManager.gameStart(NumbersBaseballManager.START_MESSAGE,NumbersBaseballManager.FINSIH_MESSAGE);
    }
}
