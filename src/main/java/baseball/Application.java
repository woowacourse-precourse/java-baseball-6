package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputSystem;

        Computer computer = new Computer(); // 컴퓨터 객체 생성
        String randomNumber = computer.generateRandom(); // 컴퓨터 번호 생성

        User user = new User(); // 사용자 객체 생성

        Judge judge = new Judge();

        System.out.println(randomNumber);

        // 본격적으로 시작
        do{
            user.reset(); // 사용자 입력값 초기화
            inputSystem = ""; // 재시작 후에 초기화를 하기 위함

            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = user.generateInput();


            judge.judgeResult(randomNumber, inputNumber); // 스트라이크, 볼 판정
            String result = judge.getResult();

            System.out.println(result);


            boolean complete = judge.checkThree();

            if (complete) { // 3스트라이크 인 경우
                inputSystem = Console.readLine();
                computer.reset();
            }

            if (inputSystem.equals("1")) { // 재시작
                randomNumber = computer.generateRandom();
            }
            judge.reset();


        }while(!inputSystem.equals("2"));
    }
}
