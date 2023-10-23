package baseball;

public class Application {
    public static void main(String[] args) {
        //개임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        //컴퓨터가 서로 다른 랜덤한 숫자 3개를 선택한다(1)
        computer.GenerateRandomNumber();
    }


}
