## ⭐기능 구현 사항

1. 3자리 정답 숫자 랜덤하게 생성하기
- generateAnswerNumber(): 숫자 3개를 랜덤하게 생성하고 ArrayList에 추가

2. 예외 생성
- checkUserInputAsInt(String input): 입력값이 없거나 숫자가 아닐 경우 IllegalArgumentException throw
- checkUserInputAsLength(String input): 입력값이 3자리가 아닐 경우 IllegalArgumentException throw
- checkContinueMsgAsValue(String input): 입력값이 1,2 가 아닐 경우 IllegalArgumentException throw

3. 사용자 입력 받기
- getUserInput(): 사용자의 입력 받아 올바른 입력값인지 확인해주고 아닌 경우 예외 발생
- generateUserInputArray(String input): 사용자의 입력값인 String을 ArrayList로 바꿔줌

4. strike, ball 값 생성
- generateStrike(List<Integer> input): strike 개수 알려줌
- generateBallNothing(List<Integer> input): ball 개수 알려줌 (0인 경우 낫싱)
- updateBall(int strike, int ball): ball 값을 재설정해줌 (strike와 ball의 중복 제거)

5. strike, ball 결과 출력
- printResult(int strike, int ball): 

6. 재시작 or 종료할지 알려주기
- getContinueMsg(): 사용자의 입력값을 받아 1(재시작), 2(종료)를 return 하고 두 수가 아닐 경우 예외 발생