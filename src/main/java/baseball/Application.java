package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //"게임 시작 문구" 출력　
        System.out.println("숫자 야구 게임을 시작합니다.");

        //사용자는 서로 다른 숫자로 이루어진 3자리 숫자 1개를 입력　
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();

        //사용자가 잘못된 값을 입력하면 IllegalArgumentException을 발생시킨 후 애플리케이션이 종료된다.
        //검증: 만약 숫자가 아닌 것을 입력하면 잘못 입력한 것이다.
        if (!isInteger(inputNum)) {
            throw new IllegalArgumentException();
        }

    }

    //정수인지 아닌지 확인
    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
