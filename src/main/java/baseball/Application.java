package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 랜덤객체 Balls 생성
        Balls computerBalls = Balls.randomComputerBalls();
        while(true){
            Game game = new Game(0,0);
            System.out.print("숫자를 입력해주세요 : ");
            // 사용자 입력
            String userInput = Console.readLine();
            System.out.println("입력크기 : "+userInput.length());
            if(userInput.length() != 3){
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }
            Balls userBalls = Balls.strToBalls(userInput);

            // 결과 출력
            game = Game.result(computerBalls, userBalls);
            System.out.println(game.printResult());

            if (game.isThreeStrike()) {
                if(!game.restart()){
                    break;
                }
                else{
                    computerBalls = Balls.randomComputerBalls();
                }
            }
        }
    }
}
