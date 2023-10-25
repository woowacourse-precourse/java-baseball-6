package service;

import controller.NumberChecker;
import controller.RandomNumber;
import input.InputModule;
import output.OutputModule;

public class NumberBaseballGame {
    private InputModule inputModule;
    private OutputModule outputModule;
    private RandomNumber randomNumber;
    private NumberChecker numberChecker;

    private boolean flag;           // 숫자를 맞추면 true, 숫자가 틀리면 false

    public NumberBaseballGame() {
        outputModule = new OutputModule();
        inputModule = new InputModule();
        randomNumber = new RandomNumber();
        flag = false;
        numberChecker = new NumberChecker();

        outputModule.printStartGame();              // "숫자 야구 게임을 시작합니다.
    }

    public void startGame(){
        randomNumber.generateNumbers();
        numberChecker.setRandomNumbers(randomNumber.getRandomNumbers());
        int ball = 0;
        int strike = 0;
        while(!flag){
            outputModule.printInputMessage();           // "숫자를 입력해주세요 :
            inputModule.setInputList();

            ball = numberChecker.getBall(inputModule.getInputList());
            strike = numberChecker.getStrike(inputModule.getInputList());

            result(ball, strike);
        }
        oneMoreGame();
    }

    private void result(int ball, int strike) {
        if (ball != 0 && strike == 0){
            outputModule.printBall(ball);
        }
        if (ball == 0 && strike != 0){
            outputModule.printStrike(strike);
        }
        if (ball != 0 && strike != 0){
            outputModule.printBall(ball);
            System.out.print(" ");
            outputModule.printStrike(strike);
        }
        if (ball == 0 && strike == 0){
            outputModule.printNothing();
        }
        System.out.println();

        if (strike == 3){
            outputModule.printOut();
            flag = true;
        }
    }

    private void oneMoreGame(){
        outputModule.printOneMoreTime();
        inputModule.setInputInt();

        if(inputModule.getInputInt() == 1){
            randomNumber.clear();
            flag = false;
            numberChecker.clear();
            startGame();
        }
    }

}
