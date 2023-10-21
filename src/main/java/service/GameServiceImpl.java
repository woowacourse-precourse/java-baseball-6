package service;

import exception.MyException;

import util.NumbersUtil;

public class GameServiceImpl implements GameService{

    private final NumbersUtil numbersUtil;
    private final MyException exception;
    private boolean quit;


    public GameServiceImpl() {
        numbersUtil = new NumbersUtil();
        exception = new MyException();
    }

    @Override
    public void gameStart() {
        numbersUtil.clear();
        numbersUtil.setNumbers();
    }

    @Override
    public void restartOrQuit(String order) {
        exception.varlidateInputOrder(order);
        if(order.equals("2")) { quit = true; }
    }

    @Override
    public int[] checkCount(String numbers) {
        exception.varlidateInputNumbers(numbers);
        int[] numberArr = new int[3];
        for(int i = 0; i < 3; i++) { numberArr[i] = numbers.charAt(i) - '0'; }
        return numbersUtil.ballCount(numberArr);
    }

    @Override
    public boolean isGameSet() {
        return numbersUtil.getGameSet();
    }

    @Override
    public boolean getQuit() { return quit; }
}
