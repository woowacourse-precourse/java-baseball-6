package baseball.View;

import baseball.data.GameResult;

public interface View {
    public void startView();
    public int inputView();
    public boolean outputView(GameResult gameResult);
    public boolean endView();
}
