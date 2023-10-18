package baseball;

public class Application {
    public static void main(String[] args) {
<<<<<<< HEAD
        // TODO: 프로그램 구현
=======
        GameMaster.run();
        /*int userInput = 1, strike = 0, ball = 0;

        //게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (userInput == 1) {
            //숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            do {
                System.out.print("숫자를 입력해주세요 : ");

                strike = 0;
                ball = 0;
                userInput = Integer.parseInt(readLine());
                System.out.println(userInput);

                if (!(userInput >= 100 && userInput <= 999)) {
                    throw new IllegalArgumentException();
                }

                int[] userArray = {userInput / 100, (userInput / 10) % 10, userInput % 10};

                for (int i = 0; i < 3; i++) {
                    if (computer.get(i) == userArray[i]) {
                        strike++;
                    } else if (computer.contains(userArray[i])) {
                        ball++;
                    }
                }

                String result = "";
                if (ball > 0) {
                    result += ball + "볼 ";
                }
                if (strike > 0) {
                    result += strike + "스트라이크";
                }
                if (result.isBlank()) {
                    result = "낫싱";
                }
                System.out.println(result);


            } while (strike != 3);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = Integer.parseInt(readLine());
            System.out.println(userInput);
        }
        System.out.println("게임 종료");*/
>>>>>>> 98c739d (feat: setup precourse baseball project)
    }
}
