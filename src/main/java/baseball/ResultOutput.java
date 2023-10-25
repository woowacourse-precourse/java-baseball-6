package baseball;

public class ResultOutput {
    public boolean outputResult(int strikes, int balls){
        if (strikes == 0 && balls == 0){
            System.out.println("낫싱");
        }else if (strikes == 3){
            System.out.println("3스트라이크\n"
                    + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else{
            System.out.println(balls + "볼 " +strikes + "스트라이크");
        }
        return false;
    }
}
