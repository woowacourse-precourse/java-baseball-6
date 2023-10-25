## 프로그램 진행

![](https://velog.velcdn.com/images/sohyun9527/post/e07aecd5-f1dc-42fe-9551-be2fe32aaeec/image.jpg)

## NumberBaseballGame 클래스

- 게임 진행 메서드

```
void play()
종료를 입력받기 전까지 계속 게임을 진행하는 메서드

void oneRound()play
메서드 내부에서 3스트라이크가 될 때까지 진행하는 하나의 라운드

boolean restartOrStop()
하나의 라운드 종료 후 재시작/종료를 묻는 메서드

void makeAnswer()
새로운 정답 생성

int scoreResult()
컴퓨터의 정답과 유저의 입력값을 비교한 뒤 출력 후 strike의 횟수를 반환

boolean isThreeStrike(int strike)
파라미터의 값이 3인지 판별하는 메서드
```

- 입력 메서드

```
List<Integer> userAnswer()
유저로부터 입력받은 값을 검증 후 리스트로 변환

String getUserInput()
유저로부터 엔터 전까지의 값을 입력받음
```

## InputValidation 클래스

- validation을 userInput값에 대해서만 진행하고, 기존에 작성한 함수도 확장성이 떨어진다고 생각해 UserInput을 위한 valid로 기능 통일..

- 유저의 입력값에 대한 Validation을 한번에 진행하는 메서드

```
List<Integer> validateUserNumbers(String input)
전체 validation을 진행하는 메서드

void validateRestartOrStop(String input)
입력받은 재시작/종료 값을 validation 진행하는 메서드
```

- 문자열을 리스트로 반환하는 메서드

```
List<Integer> convertStrToList(String input)
String->List<Integer> 변환하여 반환
```

- 세부 검증 메서드

```
void validateOnlyDigit(String input)
입력값이 숫자로만 이루어져 있는지 검수

void validateContainZero(String input)
입력값에 0이 포함되어있는지 검수

void validateDuplicateNumber(String input)
입력값이 중복된 숫자가 있는지 검수

void validateSign(String input)
재시작/종료 입력값이 1,2인지 검수

void validateSignLength(String input)
재시작/종료 입력값이 한자리 수인지 검수
```

- 공백 제거 메서드

```
String deleteSpace(String input)
숫자 사이의 공백을 제거하는 메서드
```

## Message 클래스

- 각종 메시지들은 static final로 선언하여 사용
- 게임 문구, 에러메시지 포함

- 현재 스코어를 반환하는 메서드

```
String scoreMessage(List<Integer> score)
index 0은 ball,index 1은 strike로 설정한 뒤 카운트에 따라 메시지 출력
```

## AnswerMaker 클래스

- 난수 생성 메서드

```
int makeNumber(int min,int max)
min,max 사이의 하나의 숫자 반환

List<Integer> makeThreeDifferentNumbers(int min, int max)
범위 내의 세자리 난수를 생성한뒤 리스트 타입으로 반환

```

- 정답을 저장하는 메서드

```
void makeAnswer(int min, int max)
범위 내의 세자리 난수를 생성한 뒤 필드에 저장
```

- 저장된 정답을 호출하는 메서드

```
List<Integer> getAnswer()
```

## Computer 클래스

- strike, ball 스코어 측정 메서드

```
List<Integer> countScore(List<Integer> answer,List<Integer> userNumbers)
정답과 유저의 답안을 비교해 strike,ball의 개수를 세어 리스트로 반환

int judgeScore(List<Integer> answer,int number,int index)
숫자와 위치를 비교해 BALL,STRIKE,NOTHING 셋중 하나 반환
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