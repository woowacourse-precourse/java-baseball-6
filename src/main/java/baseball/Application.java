package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String GAME_RESTART = "1";
    private static final String GAME_END = "2";
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game(); // 게임 객체 생성
        game.createAnswer(); //랜덤의 답 생성
        String judge = "-1"; //while문에 오류없이 진입 위해 음수로 설정

        while(!judge.equals(GAME_END)){
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input=Console.readLine();
                checkCorrectInput(input);
                int number = Integer.parseInt(input);

                judge = game.judgeGame(number);

                if(judge.equals("SUCCESS")){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    judge = Console.readLine();
                    checkCorrectRestart_Input(judge); //사용자가 1,2 가 아닌 다른 수나 문자를 입력했을 때 예외처리
                    if(judge.equals(GAME_RESTART)) game.createAnswer(); //새로운 답안 생성
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }

    public static void checkCorrectInput(String number){
        try {
            Integer.parseInt(number); // 숫자로 변환을 시도
        } catch (NumberFormatException e) { //만약 숫자가 아닌 값이 있다면 해당 예외 발생
            throw new IllegalArgumentException("ERROR: 숫자만을 입력해주세요");
        }
        if (number.length() != 3) {
            throw new IllegalArgumentException("ERROR : 3자리의 숫자를 입력해주세요");
        }
    }

    private static void checkCorrectRestart_Input(String judge) {
        if (!judge.equals(GAME_RESTART) && !judge.equals(GAME_END)) {
            throw new IllegalArgumentException("ERROR: 정답을 맞추신 후, 1 또는 2의 숫자를 입력해주세요.");
        }
    }

}
