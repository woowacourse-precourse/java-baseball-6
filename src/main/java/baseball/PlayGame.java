package baseball;

public class PlayGame {

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();

        //System.out.println("컴퓨터 : " + computer.getRandomNums());

        boolean success = false;

        while(!success){
            Player player = new Player();
            Judge judge = new Judge();
            success = judge.compare(computer,player);
        }
    }
}
