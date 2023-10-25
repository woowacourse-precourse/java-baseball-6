package baseball;

public class Player {
    private SecretNumber secretNumber = null;
    private final SecretNumberResolver secretNumberResolver;

    public Player(SecretNumberResolver resolver) {
        secretNumberResolver = resolver;
    }

    public SecretNumber getSecretNumber() {
        if (secretNumber == null) {
            throw new IllegalArgumentException("반드시 updateSecretNumber()를 통해 숫자를 먼저 생성해야합니다.");
        }
        return secretNumber;
    }

    public void updateSecretNumber() {
        secretNumber = secretNumberResolver.resolve();
    }
}
