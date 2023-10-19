package baseball.service;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseBallGameService {
    public BaseBallGameService(){

    }

    public List<Integer> computerNumberInit(){
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    //스트라이크, 볼 갯수 확인
    public List<Integer> strikeBallCheck(List<Integer> userNum, List<Integer> computerNum){
        Integer strike = 0;
        Integer ball = 0;

        //스트라이크면 continue 아니면 ball 확인
        for (int i = 0; i < 3; i ++) {
            if (userNum.get(i) == computerNum.get(i)){
                strike += 1;
                continue;
            }
            if(computerNum.contains(userNum.get(i))) ball += 1;
        }

        return List.of(strike,ball);
    }

    //스트라이크, 볼 갯수로 결과값 반환
    public String gameResult(List<Integer> userNum, List<Integer> computerNum){
        List<Integer> gameResult = strikeBallCheck(userNum, computerNum);
        //볼, 스트라이크 결과값 작성
        String result = (gameResult.get(1) != 0 ? gameResult.get(1) + "볼 " : "") +
                        (gameResult.get(0) != 0 ? gameResult.get(0) + "스트라이크" : "");
        //빈 문자열이면 낫싱
        if (result.equals("")) return "낫싱";

        return result;
    }

    public Boolean IntegerCheck(String userInputNum){
        for (char c : userInputNum.toCharArray()) {
            if (!Character.isDigit(c)) return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public Boolean sameNumCheck(String userInputNum){
        Set<Character> charSet = new HashSet<>();

        for (char c : userInputNum.toCharArray()) {
            charSet.add(c);
        }

        return charSet.size() == 3;
    }
    //input이 3이어야하며, 숫자로만 이루어지고, 같은수가 없어야한다
    public Boolean errorCheck(String userInputNum){
        return (userInputNum.length() == 3
                && IntegerCheck(userInputNum)
                && sameNumCheck(userInputNum));
    }

    //한턴 게임
    private void playOneGame(Scanner scanner, List<Integer> computerNum, String command) {
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInputNum = scanner.nextLine();
            //잘못된 유저 인풋 확인
            if (!errorCheck(userInputNum)) throw new IllegalArgumentException();
            //유저 입력 리스트 만들기
            List<Integer> userNum = new ArrayList<>();
            for (char c : userInputNum.toCharArray()) userNum.add(Character.getNumericValue(c));
            command = gameResult(userNum, computerNum);
            //결과 출력
            System.out.println(command);
            //게임 종료 확인
            if (command.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    //1과 2만 받는다
    public Boolean restartInputErrCheck(String restartInput){
        return (restartInput.equals("1") || restartInput.equals("2"));
    }

    public void playGame() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNum = computerNumberInit();
        playOneGame(scanner, computerNum, "");

        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reGameCheck = scanner.nextLine();
            restartInputErrCheck(reGameCheck);
            //종료 확인
            if (reGameCheck.equals("2")) break;
            //게임 다시 진행
            computerNum = computerNumberInit();
            playOneGame(scanner, computerNum, "");}
        scanner.close();
    }




}
