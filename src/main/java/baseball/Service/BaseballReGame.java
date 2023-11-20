package baseball.Service;

import baseball.Domain.ConvertCoin;
import baseball.View.OutputView;

public class BaseballReGame {
    public Boolean run() {
        return convertCoin(enterCoin());
    }

    private String enterCoin() {
        OutputView outputView = new OutputView();
        return outputView.closingGame();
    }

    private boolean convertCoin(String coin) {
        ConvertCoin convertCoin = new ConvertCoin();
        return convertCoin.convertCoin(coin);
    }
}
