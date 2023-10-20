package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 컴퓨터의 랜덤 숫자 만들기
        RandomNumbers computer = new RandomNumbers();
        computer.setRandomNumbers();

        // 사용자 입력 받기
        String n = Console.readLine();
        if (n.length() != 3){
            throw new IllegalArgumentException("입력 값 오류");
        }
    }

}
