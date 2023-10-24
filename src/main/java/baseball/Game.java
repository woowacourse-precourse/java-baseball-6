package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Game {
    class UserNumber {
        private List<Integer> userNumberSaved = new ArrayList<>();

        public UserNumber() {
        }

        public List<Integer> set() {
            String rawInput = Console.readLine();
            checkInputError(rawInput);
            this.userNumberSaved = stringToList(rawInput);
            return this.userNumberSaved;
        }

        public List<Integer> get() {
            return this.userNumberSaved;
        }

        private List<Integer> stringToList(String rawInput) {
            List<Integer> ret = new ArrayList<>();

            for (int i = 0; i < rawInput.length(); i++) {
                String oneNum = rawInput.substring(i, i + 1);
                Integer oneNumInt = Integer.parseInt(oneNum);
                ret.add(oneNumInt);
            }
            return ret;
        }

        private void checkInputError(String rawInput) {
            String[] rawInputArray = rawInput.split("");

            if (checkEmptyError(rawInputArray)
                    || checkLengthError(rawInputArray, 3)
                    || checkNumericError(rawInputArray)
                    || checkEach1to9Error(rawInputArray)
                    || checkDuplicateError(rawInputArray)) {
                throw new IllegalArgumentException();
            }
        }

        private boolean checkEmptyError(String[] rawInputArray) {
            if (rawInputArray == null || rawInputArray.length == 0) {
                return true;
            }
            return false;
        }

        private boolean checkLengthError(String[] rawInputArray, int length) {
            if (rawInputArray.length != length) {
                return true;
            }
            return false;
        }

        private boolean checkNumericError(String[] rawInputArray) {
            try {// 숫자형식으로 변환 시 예외 발생 여부
                for (String rawInputChar : rawInputArray)
                    Integer.decode(rawInputChar);
            } catch (NumberFormatException e) {
                return true;
            }
            return false;
        }

        private boolean checkEach1to9Error(String[] rawInputArray) {
            for (String userInputChar : rawInputArray) {// 1~9 확인
                char c = userInputChar.charAt(0);
                if (c < '1' || c > '9') {
                    return true;
                }
            }
            return false;
        }

        private boolean checkDuplicateError(String[] rawInputArray) {
            if (rawInputArray[0].equals(rawInputArray[1])
                    || rawInputArray[1].equals(rawInputArray[2])
                    || rawInputArray[0].equals(rawInputArray[2])) {
                return true;
            }
            return false;
        }
    }

    class ComNumber {
        private List<Integer> comNumberSaved = null;

        ComNumber() {
            this.comNumberSaved = newNumber();
        }

        List<Integer> newNumber() {
            List<Integer> newNumber = new ArrayList<>();

            while (newNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!newNumber.contains(randomNumber)) {
                    newNumber.add(randomNumber);
                }
            }
            this.comNumberSaved = newNumber;
            return this.comNumberSaved;
        }

        List<Integer> get() {
            return this.comNumberSaved;
        }
    }

    private void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private int countStrike(UserNumber userNumber, ComNumber comNumber) {// 스트라이크 개수 확인
        int strikeCount = 0;
        List<Integer> userNumberList = userNumber.get();
        List<Integer> comNumberList = comNumber.get();
        for (int i = 0; i < 3; i++) {
            Integer user = userNumberList.get(i);
            Integer com = comNumberList.get(i);
            if (user == com) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(UserNumber userNumber, ComNumber comNumber) {// 볼 개수 확인
        int ballCount = 0;
        List<Integer> userNumberList = userNumber.get();
        List<Integer> comNumberList = comNumber.get();

        for (int i = 0; i < userNumberList.size(); i++) {
            Integer userNumber1 = userNumberList.get(i);
            for (int j = 0; j < comNumberList.size(); j++) {
                if (i == j) {
                    continue;
                }
                Integer comNumber1 = comNumberList.get(j);
                ballCount += (userNumber1 == comNumber1) ? 1 : 0;
                // ballCount += Boolean.compare(userNumber1 == comNumber1, false);
            }
        }
        return ballCount;
    }

    private void printResult(UserNumber userNumber, ComNumber comNumber) { // 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
        int strikeCnt = countStrike(userNumber, comNumber);
        int ballCnt = countBall(userNumber, comNumber);

        if (ballCnt > 0) {
            System.out.print(ballCnt + "볼");
        }
        if (strikeCnt > 0) {
            if (ballCnt > 0) {
                System.out.print(" ");
            }
            System.out.print(strikeCnt + "스트라이크");
        } else if (strikeCnt == 0 && ballCnt == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    private void checkRestartInputError(String restartInput) throws IllegalArgumentException {
        final List<String> correctAnswer = List.of("1", "2");

        if (correctAnswer.contains(restartInput) == false) {
            throw new IllegalArgumentException();
        }
    }

    private boolean askContinue() {// 재시작여부 입력 받기
        boolean ret = false;
        String userInput = Console.readLine();

        checkRestartInputError(userInput);
        if (userInput.compareTo("1") == 0) {
            ret = true;
        } else if (userInput.compareTo("2") == 0) {
            ret = false;
        }
        return ret;
    }

    public void play() {
        printStart();
        boolean continueGame = true;
        UserNumber userNumber = new UserNumber();
        ComNumber comNumber = new ComNumber();

        while (continueGame) {
            printInput();
            userNumber.set();
            printResult(userNumber, comNumber);

            int strikeCount = countStrike(userNumber, comNumber);
            if (strikeCount == 3) {
                printRestart();
                continueGame = askContinue();
            }
            if (strikeCount == 3 && continueGame) {
                comNumber.newNumber();
            }
        }
    }

}
