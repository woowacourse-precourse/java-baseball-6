package player;

import camp.nextstep.edu.missionutils.Console;

public class User implements Player {
    private char[] number;

    //todo: number 초기화 고려
    public User() {
        number = new char[3];
    }

    public boolean chooseGameEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        //todo: validate
        int choice = Integer.parseInt(Console.readLine());

        if (choice == 0)
            return false;

        return true;
    }

    @Override
    public void setNumber() {
        //validation
        number = Console.readLine().toCharArray();
    }

    public char getNumber(int index) {
        return number[index];
    }
}
