package service;

import util.NumbersUtil;

public class GameServiceImpl implements GameService{

    private final NumbersUtil numbersUtil;
    private boolean quit;


    public GameServiceImpl() {
        numbersUtil = new NumbersUtil();
    }

    @Override
    public void gameStart() {
        numbersUtil.clear();
        numbersUtil.setNumbers();
    }

    @Override
    public void restartOrQuit(String order) {

    }

    @Override
    public int[] checkCount(String numbers) {
        return null;
    }

    @Override
    public boolean isGameSet() {
        return numbersUtil.getGameSet();
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public boolean getQuit() { return quit; }
}
