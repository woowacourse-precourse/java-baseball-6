package baseball;

public class Game {
    public void play(){
        //상대방(컴퓨터)의 Random 3자리 수 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        System.out.print("상대방(컴퓨터)랜덤 숫자 제대로 나오는 것 확인 : ");
        System.out.println(computer.getRandomNumber());
    }
}
