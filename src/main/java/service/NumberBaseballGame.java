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

        outputModule.printStartGame();              // "숫자 야구 게임을 시작합니다.
    }

    public void startGame(){
        randomNumber.generateNumbers();
        numberChecker = new NumberChecker(randomNumber.getRandomNumbers());
        int ball = 0;
        int strike = 0;
        while(!flag){
            outputModule.printInputMessage();           // "숫자를 입력해주세요 :
            inputModule.setInputList();

            ball = numberChecker.getBall(inputModule.getInputList());
            strike = numberChecker.getStrike(inputModule.getInputList());

            if (ball != 0){
                outputModule.printBall(ball);
            }
            if (strike != 0){
                outputModule.printStrike(strike);
            }
            System.out.println();

            if (strike == 3){
                outputModule.printOut();
                flag = true;
            }
        }
        oneMoreGame();
    }

    private void oneMoreGame(){
        outputModule.printOneMoreTime();
        inputModule.setInputInt();

        if(inputModule.getInputInt() == 1){
            randomNumber.clear();
            startGame();
        }
    }

}
