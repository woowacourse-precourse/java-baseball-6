# 숫자 야구 미션
## 필요한 기능
-[x] 스트라이크, 볼, 낫싱을 구별하는 기능
  -[x] 스트라이크 : 같은 수가 같은 자리에 있음
  -[x] 볼 : 같은 수가 다른 자리에 있음
  -[x] 같은 수가 전혀 없음
-[x] 결과를 출력하는 기능
  -[x] "숫자+볼" > "숫자+스트라이크" 순으로 출력
  -[x] 결과가 낫싱인 경우 "낫싱" 출력
-[x] 상대방의 역할 : 컴퓨터가 1~9까지 서로 다른 임의의 수 3개를 선택하는 기능
-[x] 게임 플레이어가 컴퓨터가 생각하는 숫자 3개를 입력하는 기능
  -[x] 게임 플레이어가 입력하는 숫자에 따라서 위의 결과를 출력하는 기능이 호출되는 **협력 관계**
  -[x] 스트라이크가 나올 때까지 계속 반복해서 입력 받는 기능
-[ ] 게임이 종료되면 게임을 다시 시작하거나 완전히 종료시키는 기능
-[x] 사용자가 잘못된 입력을 할 경우 `IllegalArgumentException`을 발생시키는 기능
  - [x] 숫자가 아닌 다른 문자열을 입력한 경우
  - [x] 자릿수가 일치하지 않는 경우

## 객체 도메인
* InputView
  * String inputNumbers()
  * String inputIfContinue()
* OutputView
  * void startMention()
  * void printResult(Result result)
  * void printGameOver()
* Controller
  * void run()
    * -> OutputView.startMention() call
    * -> Service
  * void willContinue()
  * void exit()
* Service
  * void initComputer()
  * private void initData(String inputtedNumbers)
  * Result calculateResult()
* GamePlayer
  * List<Integer> threeNumbers
  * void initThreeNumbers(String inputtedNumbers)
  * private void inputThreeNumberString(String inputtedString)
  * private void flushNumbers()
  * List<Integer> getThreeNumbers()
* Computer(상대방)
  * List<Integer> threeNumbers
  * void generateThreeNumbers()
  * private void flushNumbers()
  * List<Integer> getThreeNumbers()
* Result
  * initResult() 
  * int ballCount
  * int strikeCount
  * void addBall()
  * void addStrike()
  * boolean isNothing()
  * int getBallCount()
  * int getStrikeCount()
  * boolean isAllStrike()
* Validator
  * int parseValidatedInt(String str)
  * void validateCiphers(int value, int ciphers)
  * public void validateInRange(int value, int from, int to)