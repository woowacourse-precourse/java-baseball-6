package baseball.entity;

public class Coin {

    public static final String COIN_TO_GAME_START = "1";
    public static final String COIN_TO_GAME_FINISH = "2";
    private final String coin;

    public Coin() {
        this.coin = COIN_TO_GAME_START;
    }

    public Coin(String coin) {
        checkCoin(coin);
        this.coin = coin;
    }

    public boolean isCoin() {
        return this.coin.equals(COIN_TO_GAME_START);
    }

    private void checkCoin(String coin) {
        if (!coin.equals(COIN_TO_GAME_START) && !coin.equals(COIN_TO_GAME_FINISH)) {
            throw new IllegalArgumentException("입력할 수 있는 값은 1, 2입니다.");
        }
    }
}