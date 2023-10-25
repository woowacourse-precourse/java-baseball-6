package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {


    public static void main(String[] args) {
        Result result = new Result();


        while(!result.isGameOver()){
            Computer computer = new Computer(); //객체 생성 동시에 컴퓨터 랜덤 수 생성

            while (result.continueGuess()) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                User user = new User(input); //사용자 입력 저장 및 유효성 검사

                //유저의 입력에서 스트라이크와 볼 수 계산
                user.calculateStrike(computer);
                user.calculateBall(computer);

                result.printResult(user);
            }
        }

    }
}
