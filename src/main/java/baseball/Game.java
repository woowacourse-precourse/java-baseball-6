package baseball;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

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

        while (gameState) {
            //System.out.println(randomNum);
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = readLine();
            validatorCheck.inputOnlyNumber(inputNum);
            validatorCheck.inputRangeNumber(inputNum);

            strike = checkController.countStrike(inputNum, randomNum);
            //System.out.println(strike);
            ball = checkController.countBall(inputNum, randomNum);
            //System.out.println(ball);
            checkController.reportResult(strike, ball);

            if(strike==3){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int check = Integer.parseInt(Console.readLine());

                if (check == 2) {
                    gameState = false;
                } else if (check == 1) {
                    randomNum = randomNumber.makeRandomNum();
                } else {
                    throw new IllegalArgumentException("1 또는 2 숫자만 입력해주세요.");
                }

            }
        }
    }

}
