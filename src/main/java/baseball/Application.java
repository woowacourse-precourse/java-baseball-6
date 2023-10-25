package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.generateThreeDigits();
        System.out.println(randomNumberGenerator.getNumbers());
        randomNumberGenerator.printNumbers();
    }
}
