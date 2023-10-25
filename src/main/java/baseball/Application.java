package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        CreateNumber numberGenerator = new CreateNumber();
        InputNumber inputValidator = new InputNumber();
        Calculate scoreCalculator = new Calculate();
        BaseBallGame gamePlay = new BaseBallGame(numberGenerator, inputValidator, scoreCalculator);

        gamePlay.play();
    }
}
