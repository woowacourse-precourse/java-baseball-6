package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Game game = new Game();

        game.setGame();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (game.isPlaying()){
            computer.init();

            // 상대방(컴퓨터)은 1에서 9까지 서로 다른 임의의 수(랜덤) 3개를 선택
            computer.selectRandomNumber();
            computer.printComputerNumber();

            while (game.isThreeStrike()){
                System.out.print("숫자를 입력 해 주세요 : ");
                user.init();
                user.selectUserNumber();

                // 입력한 숫자에 대한 결과 출력
                game.play(computer, user);
                System.out.println(game.getGameResult());
            }

            game.isReplay();
        }

    }
}
