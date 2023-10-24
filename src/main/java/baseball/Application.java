package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            Game g = new Game();
            g.start();
        } while(isProgress());

    }

    private static boolean isProgress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String stringNumber = Console.readLine();
        if (!validation(stringNumber)) {
            throw new IllegalArgumentException();
        }
        if (stringNumber.equals("2")){
            return false;
        }
        return true;
    }

    private static boolean validation(String stringNumber) {
        boolean isNumeric = (stringNumber.length() == 1 && stringNumber.matches("[0-9]"));
        return isNumeric;
    }

}
