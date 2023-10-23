package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //개임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        //컴퓨터가 서로 다른 랜덤한 숫자 3개를 선택한다(1)
        computer.GenerateRandomNumber();
        //플레이어 (사람)가 숫자 3개를 컴퓨터에게 답을 제출한다(2)
        String inputNumber = Console.readLine();
        String submitResult = computer.submitAnswer(inputNumber);
        //컴퓨터는 판단한 결과를 플레이어에게 알려준다(4)
        System.out.println(submitResult);
    }


}
