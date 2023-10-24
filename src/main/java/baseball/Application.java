package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        GameState gameState = GameState.START;
        Computer computer = new Computer();

        //개임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameState != GameState.END) {
            //컴퓨터가 서로 다른 랜덤한 숫자 3개를 선택한다(1)
            computer.GenerateRandomNumber();

            //플레이어가 1번 플로우에서 컴퓨터가 생각한 숫자를 맞출때까지 2~4번을 반복한다.(5)
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                //플레이어가 숫자 3개를 컴퓨터에게 제출한다(2)
                String submitResult = computer.submitAnswer(inputNumber);
                //컴퓨터는 판단한 결과를 플레이어에게 알려준다(4)
                System.out.println(submitResult);
                if (submitResult.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            //플레이어가 숫자 3개를 맞췄을 경우 다시 시작하거나 완전히 종료 시킨다(6)
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartAnswer = Console.readLine();
            if (restartAnswer.equals("1") || restartAnswer.equals("2")) {
                if (Integer.parseInt(restartAnswer) == GameState.RESTART.ordinal()) {
                    gameState = GameState.RESTART;
                } else {
                    gameState = GameState.END;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

}
