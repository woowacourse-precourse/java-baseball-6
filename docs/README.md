# 기능 구현 목록

- private static void printStartMessage() 메서드 구현
  > - 시작 메세지를 출력함.
- private static void makeRandomNumber() 메서드 구현
  > - 3자리 숫자를 생성함
- private static void playBaseball() 메서드 구현
  > - 숫자 야구 한판을 진행하는 메서드
- private static int inputThreeNumber()메서드 구현
    > - 사용자에게 숫자야구에 사용할 3자리 숫자를 입력받음
- private static void checkThreeNumbersAreValid(String str)메서드 구현
    > - 유효한 값인지 확인하고, 아닌경우 IllegalArgumentException 발생 시킨후 메서드 종료시킴.
- private static boolean judgeStrikeAndBall(int number) 메서드 구현
  > - 스트라이크와 볼을 판단한 후 출력함. 
  > - 3스트라이크 인경우 종료.
- private static int endGame()
    > - 종료메시지 출력과, 다시 진행할지 여부를 판단함.
- private static void checkEndNumberIsValid(String str);
    > - 재시작/종료를 위해 입력받은 값이 유효한지 판단함.
- private static String getJudgeMessage(int strikeCnt, int ballCnt)
  > - 스트라이크와 볼의 개수에 따라 출력할 메세지를 결정함.