package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        Umpire umpire = new Umpire();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(umpire.getCoin()){
            computer.selectComputerNum();

            while(umpire.getStrike() != 3){
                player.inputPlayerNum();

                if(player.getPlayerNum().size() != 3){
                    throw new IllegalArgumentException();
                }

                umpire.countAll(computer.getComputerNum(),player.getPlayerNum());
                umpire.countStrike(computer.getComputerNum(),player.getPlayerNum());

                umpire.setJudgment(umpire.Judge());

                System.out.println(umpire.getJudgment());
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            umpire.onceAgain();
        }
        System.out.println("게임 종료");
    }
}