# 미션1 - 숫자 야구

JAVA _ 숫자 야구 게임 프로젝트

## 프로젝트 소개

컴퓨터가 랜덤으로 생성한 1 ~ 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

## 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한
  숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### ✔ 입력

#### 1. 서로 다른 3자리의 수

- (추가) Null 값은 잘못된 입력값

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 
Exception in thread "main" java.lang.IllegalArgumentException: 문자열이 비어있거나 빈 공백으로 이뤄져 있습니다. 게임을 종료합니다.
	at others.ExceptionHandling.isNull(ExceptionHandling.java:10)
	at others.ExceptionHandling.digitsExceptionTesting(ExceptionHandling.java:42)
	at baseball.Application.main(Application.java:25)

Process finished with exit code 1
```

- (추가) 공백은 무시한 후, 값을 판단

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 :           1   2              3
1스트라이크
숫자를 입력해주세요 : 
```

#### 2. 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

- (추가) 공백은 무시한 후, 값을 판단

```
숫자를 입력해주세요 : 632
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                         1
숫자를 입력해주세요 : 
```

<br>

### ✔ 출력

#### 1. 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

#### 2. 하나도 없는 경우

```
낫싱
```

#### 3. 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

#### 4. 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
```

<br>

### ✔ 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

## 기능 목록

### ✔ 게임 시작

#### 1. 게임 시작 문구 출력 기능 (_printGameStart()_)

#### 2. 랜덤 숫자를 생성하는 기능 (_computerGenerateNum()_)

- Integer List 'computer' 변수 선언
- int 'random'변수에 1 ~ 9 중 랜덤하게 숫자 하나를 뽑아 할당
- 뽑은 'random'이 'computer'안에 없으면 추가
- 'computer'의 길이가 3이 될때까지 랜덤 숫자를 추가

<br>

### ✔ 게임 진행

#### 1. 게임 시작 문구 출력 (_printGameStart()_)

#### 2. 숫자 요청 문구 출력 및 문자 입력 기능

- 숫자 요청 문구 출력 (_printInputNumber()_)
- 문자열을 입력받고 공백들을 제거하여 리턴 (_playerInputGuessingNumber()_)

#### 3. 입력 받은 값을 숫자 타입으로 저장하는 기능 (_playerGenerateNum()_)

- Integer List 'player' 변수 선언
- String 'strNumber'의 element를 하나씩 integer로 바꿔 int 'intNumber'변수에 저장
- 'player'에 'intNumber' 추가

#### 4. 컴퓨터와 사용자의 숫자 비교 기능 (_compareDigits()_)

- 스트라이크 개수 찾기
    - 'computer'와 'player'의 인덱스와 값이 모두 같으면 'strike'값 증가
- 볼 개수 찾기
    - 'computer'와 'player'의 인덱스는 다르지만 값이 같으면 'ball'값 증가 <br> 중복 체크 피하기 위해 'player'의 인덱스는 고정시키고 'computer'인덱스만 증가시켜 이와 비교

#### 5. 비교한 결과 판단 기능 (_resultJudgment()_)

- 3스트라이크 판단
    - 'strike'가 3
    - 'printThreeStrike()'로 결과 출력
    - 'true'를 리턴하여 'guess'에 할당

- 낫싱 판단
    - 'strike'와 'ball' 모두 0
    - 'printNothing()'로 결과 출력
- 볼만 있는 경우
    - 'strike'는 0, 'ball'은 0이 아님
    - 'printOnlyBall()'로 결과 출력
- 스트레이크만 있는 경우
    - 'strike'는 0이 아님, 'ball'은 0
    - 'printOnlyStrike()'로 결과 출력
- 볼과 스트라이크 둘다 있는 경우
    - 'strike'과 'ball'은 0이 아님
    - 'printBallAndStrike()'로 결과 출력

- 'false'를 리턴하여 'guess'에 할당

#### 6. 재게임 여부 입력 관련 기능

- 재게임 안내 문구 출력 (_printRestart()_)
- 문자열을 입력받고 공백들을 제거한 값 리턴 (_playerInputRestartNumber()_)
- 재게임 여부를 나타내는 입력값 판단 (_ifRestart()_)
    - "1"이라는 값을 받으면 'true'를 리턴해 'ifGameContinue'에 할당
    - "2"라는 값을 받으면 'false'를 리턴해 'ifGameContinue'에 할당
    - 이 외의 값을 받으면 'restartException()'을 호출

<br>

### ✔ 사용자 입력 예외 처리

#### 1. 예측 숫자에 대한 예외 처리 기능 (_digitsExceptionTesting()_)

- 문자열이 비어있거나 빈 공백인 경우 (_isNull()_)
    - isBlank()를 이용해 값을 판단
    - 잘못된 값이면 IllegalArgumentException을 발생시키고 게임 종료
- 3자리 수가 아닌 경우 (_isThree()_)
    - length()를 이용해 값을 판단
    - 잘못된 값이면 IllegalArgumentException을 발생시키고 게임 종료
- 1 ~ 9까지의 숫자가 아닌 경우 (_isDigits()_)
    - 'strNumber'의 element들을 char 타입으로 바꾸고 각 숫자 범위 판단
    - 잘못된 값이면 IllegalArgumentException을 발생시키고 게임 종료
- 숫자가 중복되는 경우 (_isDifferent()_)
    - 빈 문자열인 'strTemp'변수를 선언
    - 'strNumber'의 element를 char 타입으로 바꿔 'chNumber'에 할당
    - 'strNumber'가 'chNumber'의 String 타입의 값을 포함하는지 판단
    - 중복 값이 확인되면 IllegalArgumentException을 발생시키고 게임 종료

#### 2. 재게임 여부를 의미하는 숫자에 대한 예외 처리 기능 (_restartException()_)

- 잘못된 값을 입력했으니 IllegalArgumentException을 발생시키고 게임 종료