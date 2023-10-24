package baseball;

public class Application {
    public static void main(String[] args) {
        NumberGameConfiguration baseballGameConfiguration = new NumberGameConfiguration
                .Builder()
                .minimumNumberOfRange(1)
                .maximumNumberOfRange(9)
                .numberOfDigits(3)
                .build();

        NumberGame baseballGame = new BaseballGame(baseballGameConfiguration);
    }
}
