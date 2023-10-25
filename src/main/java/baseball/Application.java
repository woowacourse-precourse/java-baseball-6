package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String REGEX = "[1-9]+"; //유효한 숫자만 추출하기 위한 정규식


    public static void main(String[] args) {
        Result result = new Result();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(result.isGameContinue()){
            Computer computer = new Computer(); //객체 생성 동시에 컴퓨터 랜덤 수 생성
            System.out.println("컴퓨터 숫자 : " + computer.getComputerNumber());
            result.setOnGoingGame(true);
            while (result.isOnGoingGame()) {
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
