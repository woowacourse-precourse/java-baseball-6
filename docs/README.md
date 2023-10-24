# 🚀 설계 필요 목록

## 필요 변수 목록

- int restartCount = 1 or 2 입력받아 게임 재시작, 종료 결정 변수
- List<Integer> inputNumber (사용자로부터 입력받은 정답)
- List<Integer> randomNumber (컴퓨터가 추출한 숫자 야구 정답)
- int strikeCount (strike 횟수 판단 변수)
- int ballCount (ball 횟수 판단 변수)

------------------------------------

## 게임 로직 구현 2.2 ver

### 1. (Print) 숫자 야구 시작 선언

### 2. (While) (재)시작 or 종료 (사용자 1 or 2 입력)

+ 1 입력 시 : 다음으로
+ 2 입력 시 : 회문 종료 및 게임 종료

### 3. (Method) 랜덤한 세자리 숫자 생성 기능

+ 1, 9 범위 내 숫자 3개 생성
+ contains 기능 통한 겹치는 숫자 판별

### 4. (While) strike 3 전까지 숫자 입력 반복

+ String으로 input 값 제시받음
+ (method) 통한 List<Integer>로 전환
+ 6,7, 메서드 통한 strike, ball 값 출력
+ 6번 메서드를 strike 변수 값으로 받음

### 5. (Method) String input을 List<Integer>로 전환

+ stirng -> char로 전환 후 numericvalue로 int로 전환

### 6. (Method) strike, ball 판단 (random값과 input 값 인수로)

+ Strike, ball 개수 파악 -> 6-1 인수로

### 6-1 : strike, ball 결과 출력 메서드

+ 스트라이크 볼 개수 출력 및 strike 개수 return

### 7. 게임 종료 후 재시작, 종료 input 받기

+ parseInt로 string -> int 변경

-------------------------------------------

## 리펙터링 요소 1.1 ver

#### 1. randomNumber 생성 시 ArrayList로 관리하기

+ 3자리 int변수로 바꾼 뒤 다시 int형 배열로 바꿔 비교해야 하는 불편함
+

#### 2. 사용자로부터 inputNumber 입력 시 ArrayList로 관리하기

+ 사용자 입력값은 String으로 입력됨, int형으로 변경 필요
+ strike, ball 비교 시 contains 통해 빠른 구분 가능
+ inputNumber와 randomNumber 구조에 차이를 둠으로서 얻을 이점이 적다고 판단

#### 3. strike와 ball 카운트 메서드 분리

#### 4. 특정 표현 변수들 상수화 ex)게임 재시작, strike 카운트

#### 5. inputNumber 입력시 겹치는 수 ex)111,121 가능성

+ 예외처리 진행
