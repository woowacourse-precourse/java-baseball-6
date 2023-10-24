## 🚀 구현할 기능

### Hint 클래스
- `calculateTheNumberOfBallAndStrike()`
  - 컴퓨터의 3가지 랜덤 숫자와 플레이어의 입력값을 비교한다.
    - 값만 같으면 볼 카운터를 1 증가
    - 값과 위치 모두 같으면 스트라이크 카운터를 1 증가
    
- `getStrikeCounter()`
  - 스트라이크 카운터의 값을 리턴한다.
  - 플레이어가 정답을 맞췄는지 확인, 게임 종료를 위해 사용한다.

- `toString()`
  - 볼, 스트라이크 카운터에 따라 힌트 메시지를 달리 한다.
  - 다음과 같이 모두 4가지 경우의 힌트 메시지 형식이 나올 수 있다.
    - 볼이 0이 아닌 경우
      - 스트라이크가 0이 아닌 경우
      - 스트라이크가 0인 경우
  
    - 볼이 0인 경우
      - 스트라이크가 0이 아닌 경우
      - 스트라이크가 0인 경우

### Player 클래스
- `setThreeNumbersInput()`
  - 플레이어의 서로 다른 3가지 숫자를 입력 받을 때 사용한다.
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
  - 입력값을 정수형으로 변환한다.
    - 다음과 같은 경우는 `IllegalArgumentException`의 예외를 발생한다.
    - 입력값이 111부터 999 범위의 자연수가 아닌 경우 그리고 이 중 각 자리 숫자가 하나라도 같을 경우.
  
- `validateUniqueness()`
  - 각 자리 숫자를 비교해 하나라도 같을 경우 false를 리턴한다.

- setGameRestartInput()
  - 플레이어에게 게임 종료 여부를 물어본다.
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- `getInput()`
  - 플레이어의 입력값을 리턴한다.

### Computer 클래스
- `Computer()` (기본 생성자)
  - 라이브러리 사용 예시를 사용해 Computer 클래스가 생성될 때 3가지 랜덤 숫자를 저장한다.

- `getRandomNumbers()`
  - 3가지 랜덤 숫자를 리턴한다.

### Game 클래스
- `Game()` (생성자)
  - 애플리케이션이 작동됐을 때 플레이어를 인식한다.

- `startGame()`
  - `do-while문`은 플레이어의 게임 종료 여부 입력값이 1일 때 반복, 2일 때는 반복을 벗어나게 된다.
    - 게임 시작 메시지 출력
    - Computer 클래스 타입의 변수를 선언, 인스턴스 생성 후 이 변수에 저장한다.
    - 플레이어의 서로 다른 세 자리 숫자와 컴퓨터의 서로 다른 세 자리 숫자를 스트라이크 카운터가 나오기 전까지 비교한다.
    - 플레이어에게 게임을 다시 시작할 것인지 종료할 것인지 물어본다.

- `comparePlayerNumberAndComputerNumber()`
  -  `while문`은 스트라이크 카운터가 3인 경우 종료, 그 이외는 반복된다.
    - 숫자 입력 메시지 출력
    - Player 클래스의 setThreeNumbersInput() 호출
    - Hint 클래스 타입의 변수를 선언한다.
      - 이때, 위에서 선언한 Player, Computer 인스턴스의 getInput(), getRandomNumbers() 메서드를 사용해 Hint 인스턴스의 초기화 값으로 준다.
    - 볼, 스트라이크 카운터를 계산한다.
    - 힌트를 출력한다.

### Application 클래스
- 플레이어를 생성한다.
- 플레이어를 게임에 인식한다.
- 게임을 시작한다.