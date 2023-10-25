//package baseball;
//
//import camp.nextstep.edu.missionutils.Console;
//import java.util.ArrayList;
//
//public class ComputerGame {
//
//     while (flag) {
//        //게임시작
//        boolean flag = true;
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        System.out.print("숫자를 입력해 주세요 : ");
//
//        //사용자 숫자 입력
////        User user = new User();
//        user.setUserName(Console.readLine());
//
//        //사용자 입력 숫자 길이 체크
//        Computer computer = new Computer();
//        computer.lengthcheck(user.getUserName());
//
//        //사용자 입력 숫자 중복 체크
//        ArrayList<String> userNumber = computer.collapseCheck(user.getUserName());
//
//        //컴퓨터 랜덤숫자출력 및 중복확인
//        ArrayList<String> computerRandomNumber = computer.ComputerRandomNumber();
//        System.out.println(computerRandomNumber);
//
//        //유저와 컴퓨터의 점수 비교
//        computer.CompareScroe(userNumber, computerRandomNumber);
//
//        //결과를 계산하여 변환
//        String reply = computer.ScoreCheck();
//
//        System.out.println(reply);
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//
//        String computerInput = Console.readLine();
//
//        if (computerInput.equals("1")) {
//
//        } else if (computerInput.equals("2")) {
//            flag = false;
//            System.out.println("게임종료");
//
////                else if (!"1".equals(Console.readLine()) && !"2".equals(Console.readLine())) {
////                    System.out.println("1과 2가 아닌 다른 값이 입력되었습니다. 다시 입력해주세요.");
////                }//else-if
//
//        }//if
//    }//outer-while
//}
