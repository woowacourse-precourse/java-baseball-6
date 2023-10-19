package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Application {

    public static final int RESTART = 1;
    public static final int EXIT = 2;


    /**
     * 전체 게임 기능
     */
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean start = true;
        while (start){
            start = game();
        }

    }

    /**
     * 한 게임 기능
     * @return 재시작이면 true, 종료면 false;
     */
    private static boolean game() {
        Baseball number = new Baseball();
        boolean flag = false;
        while (!flag) {
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();
            number.setMyNumber(num);
            flag = number.confirmNumber();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return isRestart(); // 1을 선택했으면 flag = true, 즉 !flag = false가 되어서 while문 종료
    }

    private static boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String text = Console.readLine();
        validationRestart(text);
        return Integer.parseInt(text) == RESTART;
    }

    private static void validationRestart(String text) {
        try {
            int number = Integer.parseInt(text);
            if (number != RESTART && number != EXIT) {
                throw new IllegalArgumentException("게임을 재시작하려면 1, 종료하려면 2를 입력해야함");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("재시작 여부는 숫자로만 이루어져야함");
        }
    }
}
