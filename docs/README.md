## 코드 진행
![](https://velog.velcdn.com/images/sohyun9527/post/79fd5c2f-9344-44c8-8ab6-d0ae32ea9ae8/image.jpg)

## Message 클래스
- 출력 메서드
```java
String startMessage() 게임 시작 문구 반환
String requestNumberMessage() 숫자 입력 메시지 문구 반환
String successMessage() 3스트라이크 성공 문구 반환
String restartOrStopMessage() 재시작 / 종료 선택 문구 반환
String scoreMessage(int ball, int strike) 볼 / 스트라이크 현재 스코어 문구 반환
```

## NumberBaseballGame 클래스
- 출력 메서드
```java
void speaker(String message) 입력받은 메세지 출력
```
- 게임 진행 메서드
```java
void play() 종료를 입력받기 전까지 계속 게임을 진행하는 메서드
void oneRound() play 메서드 내부에서 3스트라이크가 될 때까지 진행하는 하나의 라운드
boolean restartOrStop() 하나의 라운드 종료 후 재시작 / 종료를 묻는 메서드
```

## AnswerMaker 클래스
- 난수 생성 메서드
```java
int makeNumber(int min, int max) min, max 사이의 하나의 숫자 반환
```
- 리스트로 난수 생성 후 저장 메서드
```java
AnswerMaker(int min, int max) 생성자 호출 시 makeNumber를 사용해 난수 생성후 정답을 리스트로 만들어 저장
```
- 저장된 정답을 호출하는 메서드
```java
List<Integer> getAnswer()
```

## Validation 클래스
- 유저가 입력한 값에 대한 검증 메서드
```java
void validateThreeNumbers(String input) 유저가 입력한 값에 대한 validate false가 걸리면 Exception 던지기
void validateContinueSign(String input) 재시작 / 종료 입력값에 대한 validate, false 걸리면 Exception 던지기
        
        //잘못된 값이면 false 반환
boolean duplicationCheck(String input) 중복수 판별 
boolean onlyDigitCheck(String input) 숫자만 적혀있는지 판별
boolean inRangeCheck(String input) 1 ~ 9 사이의 수인지 판별
boolean sizeCheck(String input) 지정된 사이즈만큼 들어왔는지 판별
```

## Computer 클래스
- strike, ball 스코어 측정 메서드
```java
List<Integer> countScore(List<Integer> answer, List<Integer> userNumbers) 정답과 유저의 답안을 비교해 strike, ball의 개수를 세어 리스트로 반환

int judgeScore(List<Integer> answer, int number, int index) 숫자와 위치를 비교해 BALL, STRIKE, NOTHING 셋중 하나 반환

//먼가... judgeScore를 위해 countScore에서부터 answer를 받아오는게 좀 그런가..

```

## UserInput 클래스
- 유저의 String을 입력받는 메서드
```java
String getUserInput() 미션의 요구사항대로 Console의 메서드 사용하여 String으로 입력받는 기능 
```
- validation 후 원하는 타입으로 값을 변환하는 메서드
```java
List<Integer> makeUserInputToThreeNumbers() 입력받은 String을 validation 진행 후 integer 리스트로 반환
void validateContinueSign(String sign)() 재시작 / 종료 사인에 대한 validation 진행 메서드
```


### 뭘 만들어야 할까?

1. 입력 Validation
    - 입력된 수가 잘못되었을 경우
    1. 3자리가 아닌 수를 입력했을 경우
    2. 중복된 수를 입력했을 경우
    3. 숫자가 아닌 것을 입력했을 경우
    4. 잘못된 값을 입력했을 경우, IllegalArgumentException을 발생시킨 후 종료한다.

2. 게임 진행
    0. computer는 List<Integer>로 숫자들을 담고 있다.
    1. 그렇다면 받은 숫자도 List<Integer>로 담아주자.
    1. 스트라이크 : 같은 자리에 같은 수
        - string으로 입력받은 수를 어떻게 처리해야할까??
        - 같은 수가 있는지 탐색하고, 같은 자리인지 탐색을 해야하나
        - 같은 수가 있는지 탐색하고, 같은 자리다 -> 스트
        - 같은 수인데, 다른 자리다 -> 볼
    2. 볼 : 같은 수에 다른 자리
    3. 낫싱 : 다른 수, 다른 자리

3. 메시지 출력
    1. 게임 시작 문구 출력
    2. 3스트라이크일 경우 게임 종료 메시지
    3. 게임 재시작 / 종료 선택 메시지
    4. 재시작 -> 처음으로 다시, 종료 -> 프로그램 종료