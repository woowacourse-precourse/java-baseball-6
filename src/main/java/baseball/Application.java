package baseball;

public class Application {
    public static void main(String[] args){

        GameSimulation gameSimulation=new GameSimulation();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameSimulation.gameEnd()){
            gameSimulation.gamePlay();
        }


    }
}
