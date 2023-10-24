# 기능 구현 목록

숫자 야구 게임은 다음 기능들을 통해 동작할 수 있습니다.

<br>

---
# 1. 게임 매니저
## class BaseballGameManager implements GameManager

게임의 전반적인 흐름을 제어합니다.  
각 게임을 생성하고, 시작할 수 있습니다.  

``` java
void startGameProcess()  
- 게임 프로세스를 제어하는 뼈대이다.  
- 큰 역할은, 게임 객체를 생성하는 것이다.  
```

<br>

---
# 2. 게임
## class BaseballGame implements Game
숫자 야구 게임이 구현되어 있습니다.  
즉, 실질적인 게임이 이루어집니다.  


▶ **필요한 상수**

``` java
private final String ANSWER = generateAnswer();  
private final int INPUT_LENGTH = 3;
```

<br>

▶ **사용자의 '게임 한 판'에 대한 메서드**

``` java
String generateAnswerNumber()  
- 컴퓨터가 정답숫자 문자열을 생성한다.  
```


``` java
void startAnnounce()  
- 최초 게임 시작시, 시작 멘트를 외친다.  
```

``` java
void playGame()  
- '게임 한 판'을 수행한다.  
```

``` java
boolean isContinue()  
- 사용자가 게임을 계속 할 것인지 선택한다.
```

<br>

▶ **사용자의 '1회 입력'에 대한 메서드**

▷ **1회 입력**

```
int inputNumber()  
- 사용자로부터 올바른 숫자 문자열 입력을 받는다.  
- 반환값은 입력받은 검증 성공한 숫자 문자열이다.
```

```
int validateInputNumber()    
- 사용자가 입력한 숫자의 유효성을 검증한다.  
- 검증 실패시 IllegalArgumentException을 일으킨다.  
- 반환값은 검증 성공한 숫자 문자열이다.
```

다음 4가지의 검증 메서드는 IllegalArgumentException을 발생시켜  
checkInputNumber 메서드에게 넘긴다.

```
// 검증1  
void checkParsingNumber()
- int로 파싱 가능해야 한다.
```

```
// 검증2  
void checkInputLength()
- 사용자 입력 문자열 길이는 INPUT_LENGTH 이다.
```

```
// 검증3
void checkInvalidNumber()
- "0"이 포함되지 않아야 한다.
```

```
// 검증4
void checkDuplicated()
- 사용자가 입력한 숫자문자열에서 중복숫자가 존재하지 않아야 한다.
```

<br>

▷ **1회 입력에 대한 결과 생성**

```
boolean getResult()  
- 사용자의 숫자 입력 시도 1회에 대해, 성공/실패의 힌트를 제공한다.  
- return 성공/실패 여부
```

```
int countStrike()  
- return 스트라이크 개수
```

```
int countBall()  
- return 볼 개수
```
