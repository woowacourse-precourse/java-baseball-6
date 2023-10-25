package baseball;

import camp.nextstep.edu.missionutils.Console;



public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다."); 
        while(true){

            Baseball.play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); 

            String input = Console.readLine();
            try {
                Validate.restartEndValidateInput(input);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                break;
            }
            if (!input.equals("1")) {
                break;
            }
        }

    }
}