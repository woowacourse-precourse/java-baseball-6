package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Computer computer;
    private Player player;

    public Game(){
        computer = new Computer();
        player = new Player();
    }

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            play();
            if (!restart()){
                break;
            }
        }
    }

    private void play() {
        computer.setNumbers();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            player.setPlayerNumber(inputNumber);
            CountChecker countChecker = new CountChecker();
            if(countChecker.count(player.getPlayerNumber(), computer.getNumbers())){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String selectNumber;
        try {
            selectNumber = Console.readLine();
        } catch (IllegalArgumentException e) {
            return false;
        }
        if ("1".equals(selectNumber)) {
            return true;
        } else if ("2".equals(selectNumber)) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리 수를 입력해야합니다.)");
    }
}
