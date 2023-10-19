package controller;

import view.OutputView;

/**
 * packageName    : controller
 * fileName       : GameController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class GameController {

    OutputView outputView = new OutputView();

    public void proceedGame(){
        boolean gameState = true;

        while(gameState){
            outputView.printGameStart();
        }
    }
}
