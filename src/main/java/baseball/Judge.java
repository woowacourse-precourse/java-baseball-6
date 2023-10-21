//package baseball;
//
//import java.util.ArrayList;
//
//public class Judge {
//    private final Computer computer;
//
//    public Judge(Computer computer) {
//        this.computer = computer;
//    }
//
//    public boolean isGameEnd() {
//        Round round = new Round(computer);
//        ArrayList<Integer> roundResult = round.getRoundResult();
//        int strikeCnt = roundResult.get(0);
//        if (strikeCnt == 3) {
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            return true;
//        }
//        return false;
//    }
//}
