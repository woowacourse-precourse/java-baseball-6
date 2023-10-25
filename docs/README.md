# 회고

"왜?" 에 대해 애기해보고자 한다.

예로, 단순 '객체지향'이라는 단어를 맹목적으로 좇기보다는 문제 발생 -> 문제 고민 -> 문제 해결을 통해 왜 '객체지향'의 방법론이 필요한 것인가? 를 직접 느끼고자 했다.
따라서, 지금까지 겪었던 정형화된 프로세스(객체지향, MVC 패턴 등)를 다시 밟기 보다는 바닥에서 뒹굴어보고 더 나은 방법에 대해 고민해본 것을 충분히 작성해보고자 한다.

그럼 이 생각을 할 수도 있을 것 같다. "왜 그렇게 하는데?".
바로 쪽팔려서다. "나 개발 좀 알어"라고 당당하게 말하고 다녔는데, 겉햝기 식으로 알고 있었단게 스스로 느끼는 순간이 있었다.
그래서 다시 처음부터 돌아가기로 했다.

가장 시간을 많이 투자한 부분은 '설계'다.
다만, 처음부터 고도화된 설계를 하기 보다는 구현 후 이를 개선하는 작업을 지향했다.
이에, 구현된 프로젝트를 분리하고 재설계하는 과정을 통해서 앞서 얘기한 "왜 이런 것이 등장했을까?"것에 대해 몸으로 배울 수 있었고 이해가 더 쉬웠다.

---

# 구현할 기능 목록

- [x] 사용자에게 3자리 숫자 입력받기
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 1 ~ 9까지 서로 다른 수로 이루어진 3자리 수를 입력받음
- 유효성 검증

  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

    - 중복된 수가 있을 경우

    - 3자리가 아닌 경우

    - 숫자를 입력하지 않은 경우
- [x] 컴퓨터가 3자리 랜덤 숫자 만들기
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- [x] 사용자와 컴퓨터 숫자 비교하기
- 결과 반환하기
  1. 1볼 1스트라이크
  2. 1볼
  3. 낫싱
- [x] 결과 출력하기
- "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
- [x] 게임을 새로할 건지 확인하기
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- ""게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
- 해당 입력값 유효성 검증

---

# 고민한 목록

1. 매개변수 인라인화

[feat: 유저, 컴퓨터 번호 인라인화](https://github.com/JAY-Winter/java-baseball-6/commit/7d907e5d31de8caf79d88b0d3a675b078f553cbe) , 다음 commit 을 보며 확인해보자

기존 user, computer Number 를 확인 시, 매개변수로 전달 -> 전달 -> 전달 하는 로직이기에 오류가 날 수 있는 환경이 다분히 마련되어있다.

따라서 이를 개선하기 위해 user, computer Number 를 정적 변수로 변경 후, 이를 `get` 하는 메서드를 만들어 해당 변수에 접근하는 식으로 개선했다

그렇다면 아래 코드로 작성되어 있는 부분은 어떻게 개선해볼까?

아래 코드에서 유저가 입력한 값에 따라 ball, Strike 개수가 선정되고 해당 값을 갖고 답을 비교하는 과정에서 이를 매개변수로 사용하는 일이 많다.

이는 위 상황과 같이, 코드가 커져감에 따라 오류가 날 수 있는 가능성이 높아진다.

고로, 이를 어떻게 개선해볼까? 하는 생각에 '객체'를 떠올려보았다.(이는 user, computer Number 를 다루는 부분에도 적용됨)

'컴퓨터', '유저' 그리고 이들의 답들을 비교해주는 '게임' 객체가 서로 소통을 하는 구조를 만들어야 아래 코드와 같이 특정 메서드에서 특정 값에 접근하는 구조를 만들어 줄 수 있다고 판단했기 때문이다.

```java
private static String inferHint() {
  int strike = countingStrike();
  int ball = countingBall();
  return getResult(strike, ball);
}

private static String getResult(int strike, int ball) {
  if (isNothing(strike, ball)) {
    return "낫싱";
  }
  String strikeResult = getGameResult("스트라이크", strike);
  String ballResult = getGameResult("볼", ball);
  return ballResult + strikeResult;
}

private static String getGameResult(String type, int count) {
  if (count <= 0) return "";

  return switch (type) {
    case "스트라이크" -> String.format("%d 스트라이크", count);
    case "볼" -> String.format("%d 볼 ", count);
    default -> throw new IllegalArgumentException("Invalid type");
  };
}

...
  
private static boolean isNothing(int strike, int ball) {
    return strike == 0 && ball == 0;
}

private static boolean isAnswer(String hint) {
    return hint.equals("3 스트라이크");
}
```

2. 어떻게 게임 프로세스를 분리해볼까?

기존 코드 같은 경우에는 `main class` 에서 모든 활동이 일어났다. 컴퓨터의 수를 만들고 유저의 수를 받아 이를 비교하는 모든 과정말이다.

근데 이런 코드는 한 번 보기도 힘들고, 두 번 보기 더 힘들다. 어떤 일이 일어나고 있는지 한 줄 한 줄 따라가야하고, 함수 혹은 변수명을 보고 이해를 하는 것이 아닌 문맥(코드 그 자체)를 보고 이해해야하기 때문이다. 따라서, 6번과 같이 이들을 분리하기로 결심했다.

3. 어떤 객체를 만들어야할까?

6번에서 '게임', '유저', '컴퓨터' 총 3개의 객체로 우리가 하고자하는 숫자 야구 게임을 꾸려나가기로 했다. 
그럼 이들은 이 프로세스에서 어떤 역할을 해야할까? 그것이 문제다.

4. 검증

앞서 유저의 입력값을 검증하기 위해  [feat: Validator](https://github.com/JAY-Winter/java-baseball-6/commit/6b8a1dcce6e7c70e5ad6ddeb0aae00b46234a416) 해당 commit 에서 validator 인터페이스를 구현한 중복, 범위, 길이 validtor 를 유저에게 직접 주입시켰다.

```java
public class User {
    private String userNumber;
    private List<Validator> validators;

    public User() {
        this.validators = Arrays.asList(new LengthValidator(), new NoDuplicateValidator(), new RangeValidator());
    }
```

위 코드를 보면 확인할 수 있는데, 이게 과연 맞는 방향일까? 유저의 입력값을 검증하는 validator 는 시간이 지나 추가될 수도 있는데, 이때마다 User 생성자를 수정해야한다. 그리고, userInput 을 검증하는 걸 유저가 직접하는게 맞을까? 에 대한 고민이 뒤에 나올 결과물의 초석이 되었다.

결과적으로는 Game 객체가 userInput 값을 확인하는게 맞다고 판단했고, 이제 Game 객체가 어떻게 검증이라는 권한을 넘겨받을까? 에 대한 고민이 시작됐다.

4-1. 검증

```java
public static void main(String[] args) {
  // TODO: 프로그램 구현

  List<Validator> validators = Arrays.asList(new LengthValidator(), new NoDuplicateValidator(), new RangeValidator());
  Game game = new Game(validators);
}

private final List<Validator> validators;

public Game(List<Validator> validators) {
  this.computer = new Computer();
  this.user = new User();
  this.validators = validators;
  playBaseBallGame();
}

```

기존에 User 객체에서 담당하던 검증 과정을 Game 객체로 이전시켰고, Game 객체에게 Validate 권한을 주입시켰다. 
기존에, Game 생성자에서 자체적으로 Validator 를 주입하는 것은 꽤나 타이트한 의존 관계를 지니고 있었다. 왜냐하면 8번에서 작성했던 것 처럼 Validator 가 추가되거나 혹은 삭제되는 경우에 Game 생성자를 직접적으로 수정해야 하기 때문이다. 따라서, 이를 생성자 매개변수에 할당해 의존성 관계를 주입시킨다.

5. 의존성 주입

위 글을 읽다보면 `의존성 주입` 이라는 단어가 꽤나 많이 등장한다. 의존성 주입이란 무엇일까?

> 의존성 주입은 **프로그램 디자인이 결합도를 느슨하게 되도록하고 의존관계 역전 원칙과 단일 책임 원칙을 따르도록 클라이언트의 생성에 대한 의존성을 클라이언트의 행위로부터 분리**하는 것이다.

그렇다고 한다. 잘 와닿지 않는다. 나의 언어로 정리하는 의존성 주입이란 다음과 같다.

"분리 그리고 분리", 분리를 진행하다보면 어쩔 수 없이 기존에는 잘 돌아가던 것이 나의 영역(Scope) 에서 벗어나게 되어서 이를 불러와야한다. 이때, 함수의 매개변수 혹은 인라인화 혹은 `static` 객체에 접근하는 여러가지 방법이 있다. 위 과정에서 자연스럽게 단일 책임 원칙이 지켜지고 또 자연스럽게 의존성 주입이 발생하게 된다. 

지금까지 작성한 코드를 예시로 해보자. 

1. Game 객체가 유저의 입력값을 검증해야한다
2. Game 객체가 그러면 검증하는 것도 다 다뤄야할까?

2번에 대한 질문에서 또 한 번 분리가 발생하게 되고 자연스럽게 `Validator` 객체들이 만들어지게 된다.

그럼, 어쨌든 Game 객체에서 유저의 입력값을 검증해야하니까 위에서 구현한 `Validator` 를 써먹어야하는데 이때, 의존성 주입이 발생하는 것이다. 

결과적으로, 의존성 주입에 따라서 단일 책임 원칙이 지켜지고, 코드의 유지보수하는 부분에서도 꽤나 큰 이점을 얻게되는 것이다.

6. UI분리

[feat: GameUI 분리](https://github.com/JAY-Winter/java-baseball-6/commit/0b0607135ff867fe2f28c81123da8931c83e2990) 를 해보자.

왜 해야할까? 뭐 여기서 MVC 패턴 이라는 단어가 등장할 수도 있지만, 기존 코드가 읽기 힘든게 가장 큰 이유다.

안내 메시지를 출력을 담당하는 부분 또한 Game 객체가 다루고 있었다, 이는 앞서 말한 것 처럼 코드를 읽기 힘들게 만들었다.

따라서, `GameUI` 객체를 만들고 이를 Game 에 주입시켜 해당 메서드를 사용한다.

7. OCP

우선 코드를 읽어보자.

변경 전 코드를 읽어보면 `Game` 객체가 생성 될 때, `Computer, User` 객체를 직접적으로 주입시켜주는 로직을 지니고 있다.
과연 이는 좋은 코드일까? 뭐 생각해보면 크게 나쁜 코드는 아닌 것 같다. 하나의 게임이 한 명의 유저와 한 대의 컴퓨터를 다룬다는 관점에서 보면.

그러면 `Game` 에서 다루는 `User` 가 한 명이 아니라 여러 명이라면? 한 대의 컴퓨터가 만든 수를 유저 여러 명이 동시에 맞춰야하는 상황이라면?
지금 같은 구조에서는 이 같은 부분을 다룰 수 없다. 

따라서, 우리는 하나의 게임에 대해서 어떤 유저가 참여를 하던지 각 유저에 알맞는 값(컴퓨터가 만든 난수)을 제공해야한다.
따라서, 각 `Game` 인스턴스마다 `User` 객체를 매개변수로 할당해 이를 주입시키는 과정으로 전환했고, 이는 객체지향 원칙 중 하나인  `OCP`  에 알맞는 코드가 된다.

OCP 란 Open Closed Principle 으로 확장에는 열려있고 변경에는 닫혀있는 구조. 즉, 해당 객체를 건들지 않고 얼마나 이를 확장 시킬 수 있는가? 라는 개념이라고 생각하자.

(객체지향이라는 단어가 자주 등장하는데 이는 4주 동안 더 겪어보고 배워보자)

1. 변경 전 코드

```java
public class Game {
    private User user;
    private Computer computer;
    private final GameUI gameUI;
    private final GameLogic gameLogic;

		public Game(GameUI gameUI, GameLogic gameLogic) {
      this.computer = new Computer();
      this.user = new User();
      this.gameUI = gameUI;
      this.gameLogic = gameLogic;
		}
}
```

2. 변경 후 코드

```java
public class Game {

    private final User user;
    private final Computer computer;
    private final GameUI gameUI;
    private final GameLogic gameLogic;

    public Game(GameUI gameUI, GameLogic gameLogic, Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.gameUI = gameUI;
        this.gameLogic = gameLogic;
    }
```

8. 유효성 검증과 일급 컬렉션

```java
user.inputUserNumber();
gameLogic.validateUserInput(user.getUserNumber());
```

위 코드를 읽어보면 유저가 입력을 마치고 해당 유저의 값을 get 메서드를 통해 불러와 이를 검증한다.
위와 같은 구조는 항상 유저의 입력값을 받는 곳 마다 검증 절차가 필요하다. 
이 같은 코드가 좋은 코드일까? 답은 아니다. 
그러면, 어떻게 개선해볼 수 있을까? 올바른 숫자 3가지를 입력받고, 중복된 숫자가 없으며, 1 ~ 9 사이의 숫자만 갖고 있어야하는 자료구조를 만들어 보면 되지 않을까?

이를 **일급 컬렉션**이라고 부른다.

```java
public class UserNumber {

    private static final int VALID_LENGTH = 3;
    private final String userNumber;

    public UserNumber(String userNumber) {
        validateLength(userNumber);
        validateNoDuplicate(userNumber);
        validateNumberRange(userNumber);
        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }

    private void validateLength(String userInput) {
        if (userInput.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요.");
        }
    }

    private void validateNoDuplicate(String userInput) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : userInput.toCharArray()) {
            uniqueChars.add(ch);
        }
        if (uniqueChars.size() != VALID_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateNumberRange(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요");
            }
        }
    }
}

```

8-1. 일급 컬렉션

일급 컬렉션의 이점

1. 비즈니스에 종속적인 자료구조	

   비즈니스 로직 중 필요성에 의해 등장한 자료구조이므로 해당 비즈니스 로직에 종속적이다.

2. 불변성

   자료의 불변성이란 프로그래밍에서 상당히 중요한 요소다. 해당 자료가 어디서 어떻게 변하게될 지 모른다면 관리차원에서 상당히 까다로울 것이다.

   즉, 해당 데이터가 어디에서든지 변하지 않는 데이터다라는 것은 프로그래머에게 확신을 주기 때문에 더 이해하기 쉬워진다.

---

# Java 공부

1. print 출력차이

```java
System.out.println("숫자 야구 게임을 시작합니다");

System.out.print("숫자를 입력해주세요 : ");
Scanner scanner = new Scanner(System.in);
int userNumber = scanner.nextInt();
scanner.nextLine();

-> 숫자를 입력해주세요 : 123


```

- `println()` 경우 출력 마지막에 `\n` 개행문자가 붙는다

- `print()` 경우 출력 마지막에 `\n` 개행문자가 붙지 않아 입력한 값이 출력한 값 옆에 나온다

2. 문자열 탐색

   ```java
   for (int i = 0; i < convertedToStringUserNumber.length(); i++) {
       int number = convertedToStringUserNumber.charAt(i) - 48;
       System.out.println("number = " + number);
   }
   ```

- -48하는 이유는 문자로 표현된 숫자를 실제 정수 값으로 변환하기 위함이다

- 컴퓨터에서 문자는 아스키코드(또는 Unicode) 값으로 저장된다.

  아스키 코드에서 숫자 0 은 48로 표현된다

  따라서, `charAt(i)` 로 얻은 문자가 '0'일 경우, 그 아스키 코드 값은 48이 된다

  결과적으로 해당 값이 -48 을 하면 찾는 정수 0 이 된다

3. 자바 List, ArrayList 차이

1. List

   - Java 의 `java.utill` 패키지에 있는 인터페이스
   - 순서대로 요소들을 저장하는 컬렉션을 나타낸다. 요소들은 인덱스를 기반으로 접근할 수 있다
   - `ArrayList`, `LinkedList`, `Vector`, `Stack` 등 여러 구현을 가지고 있다

2. ArrayList

   - `List` 인터페이스의 구현 클래스 중 하나

   - 내부적으로는 동적 배열을 사용하여 요소들을 저장한다

   - 이로 인해, 인덱스를 기반으로 요소에 접근하는 속도가 빠르다

     하지만, 중간에 요소를 추가하거나 제거하는 작업은 비교적 느릴 수 있다

     특히, 리스트의 크기가 큰 경우

   - 기본적으로 크기가 변동되는 배열이기 때문에, 초기 크기를 넘어서 요소가 추가되면 내부 배열의 크기를 자동으로 증가시킨다.

3. `static`

`static` 은 정적 멤버 혹은 메소드를 의미한다.

런타임때  JVM이 해당 클래스 내의 `static` 으로 선언된 프로퍼티 혹은 메서드를 확인하고, 이를 `heap` 영역이 아닌 별도의 `method`(혹은 `static`이라고 부르는 )영역에 할당한다.
