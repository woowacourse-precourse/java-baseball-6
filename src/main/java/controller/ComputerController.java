package controller;

import model.GameNumber;

import java.util.List;

/**
 * packageName    : controller
 * fileName       : ComputerController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class ComputerController {

    RandomController random = new RandomController();
    public void startGame(GameNumber gameNumber) {
        List<Integer> computerNumbers = random.generateRandomNumbers();
        gameNumber.setComputerNumbers(computerNumbers);
    }
}
