package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayingProgress playingProgress = new PlayingProgress();
        playingProgress.gameLoop();
//        PlayingProcess process = new PlayingProcess();
//        process.streaming();
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        int newGame =1;
//        do {
//
//            ComputerNum computerNum = new ComputerNum();
//            List<Integer> listComFixed = new ArrayList<>(computerNum.computer());
//            System.out.println(listComFixed);
//
//            boolean win = false;
//
//                do {
//
//                    System.out.print("숫자를 입력해주세요 : ");
//                    UserInput userInput = new UserInput();
//
//                    List<Integer> listUserFixed = new ArrayList<>(userInput.changeInList());
//                    int listUserFixedNum = listUserFixed.size();
//
//                    if (listUserFixedNum != 3) {
//                        throw new IllegalArgumentException();
//                    }
//                    CheckTheList checkTheList = new CheckTheList();
//                    int correctBalls = checkTheList.correctBallCount(listComFixed, listUserFixed);
//                    int strikes = checkTheList.strikeCount(listComFixed, listUserFixed);
//
//
//                    if (correctBalls > 0) {
//                        if (strikes == 0)
//                            System.out.println(correctBalls + "볼");
//                        if (strikes == 3) {
//                            System.out.println(strikes + "스트라이크");
//                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//                            break;
//                        }
//                        if (strikes > 0) {
//                            if (correctBalls - strikes == 0) {
//                                System.out.println(strikes + "스트라이크");
//                                continue;
//                            }
//                            System.out.print((correctBalls - strikes) + "볼");
//                            System.out.print(" ");
//                            System.out.println(strikes + "스트라이크");
//                        }
//
//                    }
//                    if (correctBalls == 0) {
//                        System.out.println("낫싱");
//                    }
//                }
//
//
//
//            while (win == false) ;
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            String gameOrNot = Console.readLine();
//            newGame = Integer.parseInt(gameOrNot);
//
//        } while(newGame == 1);
    }
}



class ComputerNum {
    List<Integer> computer = new ArrayList<>();

    public List<Integer> computer() {
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            return computer;
    }
}
class UserInput {

    String userString = Console.readLine();

    public List<Character> putInList() {
        Set<Character> set = new HashSet<>();
        List<Character> digits = new ArrayList<>();
        for (int i = 0; i < userString.length(); i++) {

            if (userString.charAt(i) >= '1' && userString.charAt(i) <= '9')
                digits.add(userString.charAt(i));

            if (!Pattern.matches("[1-9]{3}",userString))
                throw new IllegalArgumentException();
        }
        return digits;
    }
    public List<Integer> changeInList() {
        List<Integer> digitsInt = new ArrayList<>();
        for (Character chr : putInList()) {
            int num = Character.getNumericValue(chr);
            digitsInt.add(num);
        }
        return digitsInt;
    }
}
class CheckTheList {
    public int strikeCount(List<Integer> list1, List<Integer> list2) {
        int strikeCounts = 0;
        for (int i = 0; i < 3; i++) {
            if (list1.get(i) == list2.get(i))
                strikeCounts++;
        }
        return strikeCounts;
    }

    public int correctBallCount(List<Integer> list1, List<Integer> list2) {

        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (list1.contains(list2.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

}
class OutputForBalls extends CheckTheList {

    public void checkingStream(List<Integer> list1) {
        boolean win = false;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            UserInput users = new UserInput();

            List<Integer>listUserFixed = new ArrayList<>(users.changeInList());
            int listUserFixedNum = listUserFixed.size();

            if (listUserFixedNum != 3) {
                throw new IllegalArgumentException();
            }
            int correctBalls = correctBallCount(list1,listUserFixed);
            int strikes = strikeCount(list1,listUserFixed);
            if (correctBalls > 0) {
                checkingNoStrikes(strikes,correctBalls);
                if (checkingWin(strikes)) {
                    break;
                }
                if (strikes > 0) {
                    if (allCorrectBallisStrike(strikes,correctBalls)) {
                        continue;
                    }
                    mixedCorrectBalls(strikes,correctBalls);
                }

            }
            nothingCorrect(correctBalls);
        } while (!win);
    }

    public void checkingNoStrikes (int strkies ,int correctBalls){
        if(strkies == 0){
            System.out.println(correctBalls + "볼");
        }
    }

    public boolean checkingWin(int strikes) {
        boolean allStrikes = false;
        if(strikes == 3) {
            System.out.println(strikes + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            allStrikes = true;
        }
        return allStrikes;
    }

    public boolean allCorrectBallisStrike(int strikes, int correctBalls){
        boolean allBallisStrkie = false;
        if(correctBalls - strikes == 0){
            System.out.println(strikes + "스트라이크");
            allBallisStrkie = true;
        }
        return allBallisStrkie;
    }

    public void mixedCorrectBalls(int strikes, int correctBalls){
        System.out.print((correctBalls - strikes) + "볼");
        System.out.print(" ");
        System.out.println(strikes + "스트라이크");
    }

    public void nothingCorrect(int correctBalls){
        if(correctBalls == 0){
            System.out.println("낫싱");
        }
    }
}
class PlayingProgress {
    public void streamGame() {
        ComputerNum computerNum = new ComputerNum();
        List<Integer> listComFixed = new ArrayList<>(computerNum.computer());
        System.out.println(listComFixed);

        OutputForBalls outputForBalls = new OutputForBalls();
        outputForBalls.checkingStream(listComFixed);
    }

    public void gameLoop() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int newGame = 1;
        do {
            streamGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newGame = continueOrNot();
        } while (newGame == 1);
    }

    public int continueOrNot() {
        String gameOrNot = Console.readLine();
        int newOrEnd = Integer.parseInt(gameOrNot);
        return newOrEnd;
    }


}


//class PlayingProcess{
//
//    ComputerNum coms = new ComputerNum();
//    UserInput users = new UserInput();
//    CheckTheList checks = new CheckTheList();
//
//
//    public void streaming() {
//        int newGame = 1;
//        do {
//
//            firstSettings();
//            userTyping();
//            checkingStream();
//            newGame = askContinue();
//
//        }while (newGame ==1);
//
//    }
//
//    public void firstSettings() {
//        ComputerNum coms = new ComputerNum();
//        System.out.println("숫자야구를 시작합니다.");
//        List<Integer> listComFixed = new ArrayList<>(coms.computer());
//        System.out.println(listComFixed);
//
//    }
//
//    public void userTyping() {
//
//        System.out.print("숫자를 입력해주세요 : ");
//        UserInput users = new UserInput();
//        List<Integer>listUserFixed = new ArrayList<>(users.changeInList());
//        int listUserFixedNum = listUserFixed.size();
//
//        if (listUserFixedNum != 3) {
//            throw new IllegalArgumentException();
//        }
//    }
//
////    public void checking() {
////        this.checks = new CheckTheList();
////        this.correctBalls = checks.correctBallCount(this.listComFixed, this.listUserFixed);
////        this.strikes = checks.strikeCount(this.listComFixed,this.listUserFixed);
////        checkingContainsList(correctBalls,strikes);
////        if (correctBalls > 0) {
////            if (strikes == 0)
////                System.out.println(correctBalls + "볼");
////            if (strikes == 3) {
////                System.out.println(strikes + "스트라이크");
////                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
////                break;
////            }
////            if (strikes > 0) {
////                if (correctBalls - strikes == 0) {
////                    System.out.println(strikes + "스트라이크");
////                    continue;
////                }
////                System.out.print((correctBalls - strikes) + "볼");
////                System.out.print(" ");
////                System.out.println(strikes + "스트라이크");
////            }
////
////        }
////        if (correctBalls == 0) {
////            System.out.println("낫싱");
////        }
////    }
//    public void checkingStream(){
//
//        do {
//            userTyping();
//            CheckTheList checks = new CheckTheList();
//            int correctBalls = checks.correctBallCount(listComFixed, listUserFixed);
//            int strikes = checks.strikeCount(listComFixed, listUserFixed);
//            if (correctBalls > 0) {
//                checkingNoStrikes();
//                if (checkingWin()) {
//                    break;
//                }
//                if (strikes > 0) {
//                   if (allCorrectBallisStrike()) {
//                        continue;
//                   }
//                   mixedCorrectBalls();
//                }
//                nothingCorrect();
//            }
//        }while (!win);
//    }
//
//
//    public void checkingNoStrikes(int i){
//        if (strikes == 0)
//            System.out.println(correctBalls + "볼");
//    }
//
//    public boolean checkingWin(){
//        if (strikes == 3) {
//            System.out.println(strikes + "스트라이크");
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            this.win = true;
//        }
//        return this.win;
//    }
//
//    public boolean allCorrectBallisStrike(){
//        if (correctBalls - strikes == 0) {
//            System.out.println(strikes + "스트라이크");
//        }
//        return true;
//    }
//
//    public void mixedCorrectBalls(){
//        System.out.print(correctBalls - strikes) + "볼");
//        System.out.print(" ");
//        System.out.println(strikes + "스트라이크");
//    }
//
//    public void nothingCorrect(){
//        if (correctBalls == 0) {
//            System.out.println("낫싱");
//        }
//    }
//
//
//    public int askContinue(){
//        int newGame;
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        String gameOrNot = Console.readLine();
//        newGame = Integer.parseInt(gameOrNot);
//        return newGame;
//    }
//
//}

//class PlayingProcess {
//    ComputerNum computerNum = new ComputerNum();
//    UserInput userInput = new UserInput();
//    CheckTheList checkTheList = new CheckTheList();
//
//    public void streaming() {
//        List<Integer> listComFixed = new ArrayList<>(computerNum.computer());
//        boolean win = false;
//        do {
//
//            System.out.print("숫자를 입력해주세요 : ");
//            List<Integer> listUserFixed = new ArrayList<>(userInput.changeInList());
//
//            if (checkTheList.correctBallCount(listComFixed, listUserFixed) > 0)
//                System.out.println(checkTheList.correctBallCount((listComFixed), listUserFixed) + "볼");
//            if (checkTheList.strikeCount(listComFixed, listUserFixed) > 0) {
//                System.out.println(checkTheList.strikeCount(listComFixed, listUserFixed) + "스트라이크");
//                if (checkTheList.strikeCount(listComFixed, listUserFixed) == 3) {
//                    win = true;
//                    break;
//                }
//            }
//            checkTheList.nothing(listComFixed, listUserFixed);
//
//        } while (win == false);
//
//    }
//}
//}
//
