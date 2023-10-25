# 1주차 미션 - 숫자 야구

---

## 순서

### 1. 구현 기능 목록
### 2. 클래스 목록
### 3. 메서드 목록

---

## 1. 구현 기능 목록

- 구현할 기능 목록 및 내용 설명

---

### 1) 게임 진행 기능

- 게임의 전체 과정을 진행하는 기능


- 게임 시작 문구 출력
  - `숫자 야구 게임을 시작합니다.` 출력


- 중첩 반복문 실행
  - 외부 반복문
    - 전체 게임 과정 반복
    - 게임 종료시 재시작하기 위해 사용
    - 종료 조건 : 게임 재시작 여부 확인 기능에서 플레이어가 `2`(게임 종료 숫자) 입력
  - 내부 반복문
    - 플레이어가 정답 맞추는 과정 반복
    - 플레이어가 숫자 입력과 결과 출력을 위해 사용
    - 종료 조건 : 정답 여부 확인 기능에서 플레이어가 정답을 맞춤


### 2) 컴퓨터 정답 설정 기능


- 컴퓨터의 정답을 생성해 저장하는 기능


- 1에서 9까지의 랜덤한 숫자를 3개 생성
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 사용


- 만든 숫자가 중복되지 않다면 리스트에 저장


### 3) 플레이어 숫자 설정 기능


- 플레이어에게 숫자를 입력받아 저장하는 기능


- 플레이어에게 숫자 입력받기
  - `숫자를 입력해주세요 :` 출력 후 문자열 입력받기
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용


- 입력받은 문자열 검사
  - 조건 1. 문자열의 길이가 3인지
  - 조건 2. 문자열에 0이 포함되어 있지 않은지
  - 조건 3. 문자열의 각 숫자가 정수가 맞는지
  - 조건 4. 문자열에 중복된 숫자가 없는지
  - 문자열이 조건에 맞지 않으면 예외 `IllegalArgumentException` 발생시킨 후 프로그램 종료


- 입력받은 숫자가 검사에 통과하면 리스트에 저장


### 4) 스트라이크, 볼 계산 기능


- 게임의 결과를 계산하는 기능


- 컴퓨터의 정답 리스트와 플레이어 숫자 리스트 비교


- 플레이어 숫자가 정답과 얼마나 일치하는지 스트라이크와 볼 개수 계산
  - 스트라이크 : 같은 자리에 같은 숫자가 몇 개 존재하는지 계산
  - 볼 : 다른 자리에 같은 숫자가 몇 개 존재하는지 계산


- 계산 결과를 배열로 반환


### 5) 결과 출력 기능


- 게임의 결과를 출력하는 기능


- 게임의 계산 결과를 문자열로 만들어 출력
  - 스트라이크와 볼이 모두 존재 : `n볼 m스트라이크`
  - 스트라이크만 존재 : `n스트라이크`
  - 볼만 존재 : `n볼`
  - 스트라이크와 볼이 모두 없음 : `낫싱`


### 5) 정답 여부 확인 기능


- 플레이어가 정답을 맞췄는지 확인하는 기능


- 게임의 결과의 스트라이크가 3이면 정답 문자열 출력
  - `3개의 숫자를 모두 맞히셨습니다! 게임 종료` 출력
 

- 정답 여부 반환
  - 정답일 경우 `true` 반환
    - `1) 게임 진행 기능`의 `내부 반복문` 종료
  - 정답이 아닐 경우 `false` 반환


### 5) 게임 재시작 여부 확인 기능


- 플레이어가 정답을 맞춰 게임이 종료되면 게임 재시작 여부를 확인하는 기능


- 플레이어에게 게임 재시작 여부 입력받기
  - `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 출력
  - 문자열 입력받기


- 입력받은 문자열 검사
  - 조건 : 문자열이 `1`또는 `2`와 일치하는지
  - 문자열이 조건에 맞지 않으면 예외 `IllegalArgumentException` 발생시킨 후 프로그램 종료


- 게임 재시작 여부 반환
    - 문자열이 `1`일 경우 `true` 반환
      - `1) 게임 진행 기능`의 `외부 반복문` 종료
    - 문자열이 `2`일 경우 `false` 반환

---

## 2. 클래스 목록

- 클래스 목록 및 역할 설명

---

- Application 
  - 프로그램을 실행하는 클래스


- Game 
  - 게임 진행을 수행하는 클래스


- ComputerNumber
  - 컴퓨터 정답을 생성하고 관리하는 클래스


- PlayerNumber
  - 플레이어 숫자를 생성하고 관리하는 클래스


- RestartNumber
  - 게임 재시작 문자열을 관리하는 클래스


- CalculateResult
  - 게임 결과(스트라이크, 볼)를 계산하는 클래스


- ExceptionCheck
  - 예외 조건을 검사하고 예외를 발생시키는 클래스


- InputOutput
  - 사용자 입력과 출력을 수행하는 클래스

---

## 3. 메서드 목록

- 클래스별 메서드 목록 및 기능 설명

---

### Application

- none

### Game

- `public void run()`
  - do while 문을 통해 게임 시작 및 재시작 여부 확인


- `private void startGame()`
  - do while 문을 통해 게임 과정 진행


- `private void setComputerNumber()`
  - `ComputerNumber` 객체 생성


- `private void setPlayerNumber()`
  - `PlayerNumber` 객체 생성


- `private int[] calculateResult()`
  - `CalculateResult` 객체 생성
  - 계산 결과 반환


- `private void printResult(int[] gameResult)`
  - 계산 결과 출력 메서드 호출


- `private boolean isAnswer(int[] gameResult)`
  - 정답 여부 확인 및 반환
  - 정답시 게임 종료 메서드 호출


- `private boolean checkRestart()`
  - `RestartNumber` 객체 생성
  - 게임 재시작 여부 반환 함수 호출 및 반환값 반환

### ComputerNumber

- `public ComputerNumber()`
  - 정답 리스트 생성
  - 컴퓨터 정답 설정 메서드 호출


- `public void addNumbers()`
  - 랜덤 숫자 반환 메서드 호출 후 정답 리스트에 추가 


- `private void getRandomNumber()`
  - 1~9 범위의 중복되지 않은 숫자 1개 반환


- `public boolean isEqualNumberSameIndex(int number, int index)`
  - 정답 리스트의 index 번째 인덱스의 값과 number 값이 같은지 반환


- `public boolean containsNumber(int number)`
  - 정답 리스트 내에 number 값이 존재하는지 반환


### PlayerNumber

- `public PlayerNumber(String inputNumber)`
  - 숫자 리스트 생성
  - 예외 검사 메서드 호출
  - 플레이어 숫자 설정 메서드 호출


- `private void setNumbers(String input)`
  - 플레이어 입력 문자열 숫자로 변환
  - 숫자 리스트에 숫자 추가


- `public int getNumber(int index)`
  - 숫자 리스트에서 index 인덱스의 값 반환


### RestartNumber

- `public RestartNumber(String restartNumber)`
  - 게임 재시작 문자열 검사 메서드 호출
  - 게임 재시작 여부 문자열 저장


- `public boolean isRestart()`
  - 게임 재시작 여부 반환


### CalculateResult

- `public CalculateResult(ComputerNumber computerNumber, PlayerNumber playerNumber)`
  - `ComputerNumber` 객체와 `PlayerNumber` 객체 의존성 주입
  - 스트라이크 계산, 볼 계산 메서드 호출


- `private void calculateStrike()`
  - 각 인덱스마다 카운트 스트라이크 메서드 호출
  - 반환값 스트라이크 개수에 추가


- `private int countStrikeByIndex(int index)`
  - `ComputerNumber` 객체의 동일 인덱스 동일 값 메서드 호출
  - 현재 인덱스의 스트라이크 개수(1 or 0) 반환


- `private void calculateBall()`
  - 각 인덱스마다 카운트 볼 메서드 호출
  - 반환값 볼 개수에 추가
  - 볼 개수에서 스트라이크 개수 빼기 연산


- `private int checkBallByIndex(int index)`
  - `ComputerNumber` 객체의 숫자가 존재하는지 확인하는 메서드 호출
  - 현재 인덱스의 볼 개수(1 or 0) 반환

- `public int[] getResult()`
  - 스트라이크, 볼 개수 반환

### ExceptionCheck

- `public static void checkPlayerNumberInput(String playerNumber)`
  - 플레이어 숫자 입력값 조건 확인 메서드 4개 호출


- `private static void isLengthThree(String playerNumber)`
  - 입력 문자열 길이가 3이 아니면 `IllegalArgumentException` 발생
  - 예외 메시지 : "입력된 숫자가 3자리가 아닙니다."


- `private static void notContainsZero(String playerNumber)`
  - 입력 문자열에 0이 포함되어 있으면 `IllegalArgumentException` 발생
  - 예외 메시지 : "입력된 숫자 중 0이 존재합니다."


- `private static void isNumber(String playerNumber)`
  - 입력 문자열에 숫자가 아닌 값이 있으면 `IllegalArgumentException` 발생
  - 예외 메시지 :"입력된 값 중 숫자가 아닌 값이 존재합니다."


- `private static void isNotDuplicated(String playerNumber)`
  - 입력 문자열에 중복된 숫자가 있으면 `IllegalArgumentException` 발생
  - 예외 메시지 :"중복된 숫자가 있습니다."


- `public static void checkRestartNumber(String restartNumber)`
  - 게임 재시작 여부 메시지가 "1"이나 "2"가 아니라면 `IllegalArgumentException` 발생
  - 예외 메시지 :"잘못된 값이 입력되었습니다."


### InputOutput

- `public static void printGameStart()`
  - "숫자 야구 게임을 시작합니다." 출력


- `public static void printGameEnd()`
  - "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력


- `public static String inputPlayerNumber()`
  - "숫자를 입력해주세요 : " 출력 후 사용자 입력을 받아 반환 


- `public static void printResult(int strike, int ball)`
  - 매개변수로 전달받은 스트라이크와 볼 개수로 결과 문자열 만들어서 출력
  - 스트라이크, 볼 모두 0이라면 "낫싱" 출력


- `public static String inputRestartNumber()`
  - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력 후 사용자 입력을 받아 반환