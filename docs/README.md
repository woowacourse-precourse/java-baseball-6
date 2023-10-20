## 기능 요구사항
1. 서로 다른 임의의 3개 숫자 기능
2. 볼 판정 기능
3. 스트라이크 판정 기능
4. 잘못된 입력 시 IllegalArgumentException 리턴 기능


### 클래스 및 메소드 구현
1. Checker 
- 1.1. isCorrectInput(input) : Boolean
  - 사용자 입력(input)에 대해 잘못된 입력인지 판단한 후, 올바른 입력이면 true, 잘못된 입력이면 false를 리턴한다. (요구사항 4번 관련)
- 1.2. numberOfStrikes(input, randomNumber) : Integer
  - input과 computer가 만든 randomNumber를 비교하여 스트라이크의 수를 리턴한다. (요구사항 3번)
- 1.3. numberOfBalls(input, randomNumber) : Integer
  - input과 randomNumber를 비교하여 볼의 수를 리턴한다. (요구사항 2번)

2. NumberMaker
- 2.1. getRandomNumber() : String
  - 서로 다른 임의의 3개 숫자를 만들어 String으로 리턴한다. (요구사항 1번)