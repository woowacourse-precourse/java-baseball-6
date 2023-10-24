package baseball;


public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        String result = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = UserInput.getUserNumber();
            int[] score = computer.getResult(userInput);
            if (score[1] != 0) {
                result += score[1] + "볼";
            }
            if (score[0] != 0) {
                if (!result.isEmpty()) {
                    result += ' ';
                }
                result += score[0] + "스트라이크";
            }
            if (result.isEmpty()) {
                result += "낫싱";
            }
            System.out.println(result);
            if (score[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                boolean restart = UserInput.getUserRestart();
                if (restart) {
                    computer.resetNumber();
                } else {
                    System.out.println("게임 종료");
                    break;
                }
            }
            result = "";
        }
    }
}


