package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String player = Console.readLine();
            if(player.length() != 3){
                throw new IllegalArgumentException("입력은 세자리로 이루어져야합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 - " + e.getMessage());
        }
    }
}
