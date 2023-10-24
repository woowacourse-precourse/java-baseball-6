package baseball;

import baseball.controller.UserController;
import baseball.domain.ComputerNumber;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserController userController = new UserController();
        ComputerNumber computerNumber = new ComputerNumber(3);


        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 랜덤 번호 생성
            computerNumber.createNewNum();
            // 숫자 맞추기 로직
            userController.guessNumber(computerNumber.convert2Dto());

            // 유저에게 게임 종료 여부 확인
            if (userController.isOver()) {
                break;
            }

        }

    }


}
