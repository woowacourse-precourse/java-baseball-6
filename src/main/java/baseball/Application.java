package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        Boolean allowsRestart = false;

        do {
            Computer computer = new Computer();  // 컴퓨터 객체 생성
            Boolean isCorrect = false;

            while(!isCorrect) {  // 정답일 경우 반복문 종료

                // 사용자로부터 숫자 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if(input.length() != 3) {  // 사용자 입력 예외 처리
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                }

                // Computer 클래스의 startGame 메서드로부터 정답 여부 반환
                isCorrect = computer.startGame(input);
            }

            if (isCorrect) {  // 정답일 경우 게임 재시작 여부 질의

                // 사용자로부터 재시작 여부 숫자 입력 받기
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String resume = Console.readLine();

                // 1을 입력받았을 경우 do-while 반복문 다시 수행하도록 Boolean 변수 조정
                allowsRestart = (resume.equals("1")) ? true : false;
            }

        } while (allowsRestart);
    }
}
