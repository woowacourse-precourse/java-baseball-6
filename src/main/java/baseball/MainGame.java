package baseball;

import java.util.List;
public class MainGame {
    static final String THREESTRIKE = "3스트라이크";
    static final String GAMEOVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    GetRandomNum randomNum = new GetRandomNum();
    UserInput input = new UserInput();
    Judge judge = new Judge();
    Playagain playagain = new Playagain();
    Validator validator = new Validator();

    public void startGame() {
        boolean again = true; //게임 다시 시작할 여부

        while (again) {
            List<Integer> computer = randomNum.create();//난수 생성 computer 변수에 저장

            String result = "";
            while (!result.equals(THREESTRIKE)) {
                List<Integer> playerGuess = UserInput.playerNumber();
                try {
                    validator.validate(playerGuess); // 사용자 입력이 유효한지 검증
                } catch (IllegalArgumentException e) {
                    System.exit(0); // 프로그램 종료
                }
                result = judge.judgement(computer, playerGuess);
                System.out.println(result);
            }

            System.out.println(GAMEOVER);

            again = playagain.playagain();
        }
    }
}





