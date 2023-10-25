package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Game {

    private boolean progress;
    private Computer computer;
    private User user;

    Game(){
        this.progress = true;
        this.computer = new Computer();
        this.user = new User();
    }

    public void run(){
        try {
            System.out.println("숫자 야구 게임을 시작합니다.");
            while(progress){
                computer.generateAnswer();
                do {
                    System.out.print("숫자를 입력해주세요 : ");
                    user.input();
                    Map<String, Integer> sol = computer.resolve(user.getUserInput());
                    if(scoreInfo(sol)){
                        break;
                    }
                }while(true);
                progress = restartOrEndProgram();
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public boolean scoreInfo(Map<String, Integer> sol){
        if(sol.get("스트라이크") == 3){
            System.out.printf("%d스트라이크 %n", sol.get("스트라이크"));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if(sol.get("볼") == 0 && sol.get("스트라이크") == 0){
            System.out.println("낫싱");
        } else if(sol.get("볼") == 0){
            System.out.printf("%d스트라이크", sol.get("스트라이크"));
        } else if(sol.get("스트라이크") == 0){
            System.out.printf("%d볼", sol.get("볼"));
        } else {
            System.out.printf("%d볼 %d스트라이크", sol.get("볼"), sol.get("스트라이크"));
        }
        return false;
    }

    public boolean restartOrEndProgram() throws Exception{
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int cmd = Integer.parseInt(Console.readLine());
            if (cmd == 1) {
                return true;
            } else if(cmd == 2){
                return false;
            } else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
