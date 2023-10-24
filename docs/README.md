# 숫자 야구 게임

## 기능 구현 목록


- [x] 1에서 9까지 서로 다른 수 생성(컴퓨터의 수) - makeAnswer()
  - Randoms API를 이용해서 난수를 answerNumbers에 저장
  - ``Randoms.pickNumberInRange``로 1~9 범위에 있는 정수를 무작위로 가져옵니다.
  - 그 후에 answerNumbers에 정수가 있는지 확인하고 없으면 add합니다.
  - 위 동작을 answerNumbers의 크기가 3이 될 때까지 반복합니다.
- [x] 1에서 9까지 서로 다른 수 입력받기(사용자의 수) - startGame()
  - ``Console.readline()``을 통해서 문자열을 입력 받음.
  - ``inputToArrayList()``로 문자열을 입력받고 userNumbers에 저장.
- [x] 잘못된 입력값인지 확인하는 기능 - validateInput()
  - [x] 입력값의 길이 확인 - validateNumberLength()
  - [x] 정수 여부 확인 - validateIntegerNumber()
  - [x] 0을 입력했는지 - validateIsZero()
  - [x] 중복된 값을 입력했는지 확인 - validateDuplicateNumbers() 
- [x] 결괏값을 출력하는 기능 - printScore()
- [x] 게임을 시작 하느 기능 - run()
  - 게임을 시작 할 때마다 ``makeAnswer()``로 컴퓨터의 수 생성
  - 매번 ball과 strike 개수 초기화
- [x] 게임을 다시 시작할지 입력값을 받는 기능 - retryGame()
  - ``Console.readline()``입력을 받고 1 또는 2가 아니면 예외 처리
- [x] 볼의 개수를 세는 기능 - countBalls
  - 인덱스별로 값이 같으면 count를 증가하지 않음
  - ``contains``로 볼의 개수 확인
- [x] 스트라이크의 개수를 세는 기능 - countStrikes
  - 인덱스별로 값이 같으면 count가 증가