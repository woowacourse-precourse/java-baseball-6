package baseball;

public class Playagain {
    public boolean playagain(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = camp.nextstep.edu.missionutils.Console.readLine();
        if(Integer.parseInt(answer) == 1){
            return true;
        }
        return false;
    }
}
