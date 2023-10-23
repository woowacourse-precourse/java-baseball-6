package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Inspection inspection=new Inspection();
        Production production = new Production();
        Game game = new Game();
        //컴퓨터 패 생성
        int[] comArr = production.settingArr();
        //정상 검출 테스트(성공 231023)
        for (int i = 0; i < comArr.length; i++) {
            System.out.println("com[" + i + "] = " + comArr[i]);
        }


        //게임시작
        boolean gameWon = false;
        while (!gameWon) {
            //사용자 패 생성
            int[] userArr = inspection.userInputToArr();
            //정상 검출 테스트(성공 231023)
            for (int i = 0; i < userArr.length; i++) {
                System.out.println("user[" + i + "] = " + userArr[i]);
            }
            game.play(comArr, userArr);
            if (game.getStrikes() == 3) {
                System.out.println("축하합니다! 모든 3개의 숫자를 맞추셨습니다. 게임 종료!");
                gameWon = true;
            }
        }





    }

}
