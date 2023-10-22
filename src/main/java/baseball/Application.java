package baseball;

public class Application {
    // Player와 Computer를 멤버변수로 구현?
    public static void main(String[] args) {
        Player player = new Player();
        // Computer computer = new Computer(); // 여기에 선언하면 게임을 새로 시작할 때 똑같은 숫자임

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();

//          do {
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                player.setInput();

                // Computer computer = new Computer(); // 여기에 선언하면 순서가 이상해짐
                Hint hint = new Hint(player.getInput(), computer.getRandomNumbers());
                hint.calculateTheNumberOfBallAndStrike();
                System.out.println(hint);

                if (hint.getStrikeCounter() == 3) {
                    break;
                }

//                Hint.resetCounters();
//            } while(Hint.strikeCounter != 3);
//          } while(hint.getStrikeCounter() != 3); // hint를 밖에 선언해야 하는데 밖에 선언하면 Player의 input을 설정하기 전임
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            player.setInput();

            if (player.getInput().equals("2")) {
                break;
            }

        } while(player.getInput().equals("1"));
    }
}
