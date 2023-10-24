package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 랜덤객체 Balls 생성
        Balls computerBalls = Balls.randomComputerBalls();
        while(true){
            Game game = new Game(0,0);
            String userInput = Game.userInput();
            Balls userBalls = Balls.strToBalls(userInput);

            // 결과 출력
            game = Game.result(computerBalls, userBalls);
            System.out.println(game.printResult());

            if (game.isThreeStrike()) {
                if(!Game.restart()){
                    break;
                }
                else{
                    computerBalls = Balls.randomComputerBalls();
                }
            }
        }

    }
}
