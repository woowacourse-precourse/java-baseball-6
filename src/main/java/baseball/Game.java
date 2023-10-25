package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    int ball = 0;
    int strike = 0;
    String result = "";
    boolean gameState = true;
    private RandomNumber randomNumber = new RandomNumber();
    private ValidatorCheck validatorCheck = new ValidatorCheck();
    private CheckController checkController = new CheckController();


    public void gameStart() {
        String randomNum = randomNumber.makeRandomNum();
        System.out.println(randomNum);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameState) {
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();
            validatorCheck.inputOnlyNumber(inputNum);
            validatorCheck.inputRangeNumber(inputNum);

            strike = checkController.countStrike(inputNum, randomNum);
            System.out.println(strike);
            ball = checkController.countBall(inputNum, randomNum);
            System.out.println(ball);
            checkController.reportResult(strike, ball);

            if(strike==3){
                int restartChoice = Integer.parseInt(Console.readLine());
                checkController.gameRestart(restartChoice);
            }

            if(strike == 3 && gameState == true){
                randomNum = randomNumber.makeRandomNum();
            }

        }
    }

}
