package baseball;

import java.util.ArrayList;


public class IdentifyNumber {


        RunGame runGame = new RunGame();

        Input input = new Input();

        RandomNumber randomNumber = new RandomNumber();

        ArrayList<Integer> computernumber = randomNumber.ComputerNumber();



    public int CheckNumber () {
        InputValidator inputValidator = new InputValidator();
        String inputnumber = input.InputNumber();

        int[] clientnumber = inputValidator.StringToInt(inputnumber);


        int ball=0;
        int strike=0;


        for (int i=0;i<3;i++) {

            boolean isContain = computernumber.contains(clientnumber[i]);

            if (isContain) {
                if(clientnumber[i] != computernumber.get(i))
                    ball += 1;
                else{
                    strike += 1;
                }

            }

        }

        ResultGame(ball,strike);

        return strike;


    }


    public void ResultGame(int ball, int strike) {
        String resultball = "";
        String resultstrike = "";


        if (ball >0) {
            resultball = ball + "볼 ";
        }

        if (strike >0) {
            resultstrike = strike + "스트라이크";
        }

        if (ball + strike >0) {
            System.out.println(resultball+resultstrike);
        }else{
            System.out.println("낫싱");
        }

    }

    public void PlayGame() {
        while (CheckNumber() < 3){

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int restart_num = Integer.parseInt(input.Restart());
        RestartGame(restart_num);


    }

    public void RestartGame(int startnumber) {

        if (startnumber == 1) {
            runGame.StartGame();
        }

        if (startnumber > 2) {
            throw new IllegalArgumentException();

        }

    }

}

