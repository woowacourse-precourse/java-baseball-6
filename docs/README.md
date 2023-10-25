# Contents

**1. 프로그램 설명서**
- 프로그램의 전체 설계 구조
- 패키지 클래스 구조

**2. 구현 기능(함수) 목록 및 설명서**
    



---

# 1. 프로그램 설명서


## (1). 프로그램의 전체 설계 구조 (MVC 등)
MVC 설계 방식은 Model-View-Controller 설계 방식을 의미한다. Application을 구성할 때 Model 은 핵심 두뇌(생산) 기능을 수행하도록 설계하고, Controller 는 Application 전체를 관장하고 통제하도록 한다. 그리고 View는 입출력을 담당하도록 설계한다.


기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
해당 게임에서 맞춰야하는 정답은, 주어진 메소드를 활용하여 랜덤으로 주어지도록 한다.
이후, 플레이어로부터 서로 다른 3자리의 수를 입력받아 정답과 비교한다.
비교 결과는 경우에 따라 ball/strike/낫싱의 정보로 출력한다.
게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력받는다.


해당 문제는 총 8개의 Class로 구성할 수 있고, MVC 설계 구조는 다음과 같다.

--- 
### ⭐️[**C**ontroller : Class "AppContorller"]
- Application의 run()에서 하는 일을 담당한다. 맞춰야 하는 정답의 숫자를 초기화하고, 게임을 위한 반복 여부와 3자리의 수의 정보를 입력받을 것을 지시한다. 입력받은 정보로 게임을 진행하도록 지시한다. 유효하지 않은 값을 입력받으면 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료한다.




### 👀[**V**iew : Class “AppView” ]
- 입력과 출력을 담당한다. 각종 형식에 맞는 값을 출력하도록 한다.


### 🤖[ Model ]
- Class `ComputerGenerator` : 게임의 정답에 사용 될 서로 다른 3자리 숫자를 리스트 형태로 초기화하고 반환한다.
- Class `ScoreBoard` : Ball 수와 Strike 수의 정보를 담을 용도로 사용되는 자료형 클래스이다.
- Class `TurnBasedPlay` : 정답과 사용자가 제시한 숫자를 비교한다. 이 때, `CalculScore` 메소드를 사용한다.



추가적으로 프로그램이 시작하는 곳을 포함하는 특별한 Class `Application` 과 Util 클래스가 있다.
- Class `Application` : main()을 위한 class 이고, 앱이 실행되도록 해주는 일이 전부이다.
- Class `GameConstant` : 게임에 사용되는 상수 조건들을 저장하고 있는 클래스이다.
- Class `InputValidate` : 사용자로부터 입력받는 값이 유효한지 체크한다. 유효하지 않은 값을 입력받으면 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료하도록 한다.

---

# 2. 기능(함수) 목록 및 설명서
- init
    - 정답에 해당하는 서로 다른 3자리 숫자를 배열에 담아서 초기화
    - 자리수 별로 배열 초기화 (배열이 가지는 index 참조의 이점 활용)
    - 서로 다른 숫자의 조건은 set 자료형 활용
        ```java
        private static boolean isUniqueValue (String aNumber) {
            Set<Character> set = new HashSet<>();
            for (char number : aNumber.toCharArray()) {
                set.add(number);
            }
            return set.size() == GameConstant.LENGTH;
        }
        ```
    
- 반복, 입력과 대조
    - 유효성 체크하면서 입력 받기 (정수형, 서로 다른 숫자의 조건은 정규식을 사용)
      ```java
      public static final int LENGTH = 3;
      public static final String REGEX = "[1-9]{" + LENGTH + "}";
      
      // 중략...
      
      if (aNumber.matches(GameConstant.REGEX)) {
        return Integer.parseInt(aNumber);
      }
      ```
      
    - 정답 확인 하기 (배열의 완전 탐색)
      ```java
        for (int i = computer.length - 1; i >= 0; i--) {
            int current = (number / (int)Math.pow(10, i)) % 10;
            //...
        }
      ```
- 출력 하기
  
    - 별도의 output, outputLine 함수 구현
  
        ```java
        public static void output (String aString) {
            System.out.print(aString);
        }
        public static void outputLine (String aString) {
            System.out.println(aString);
        }
        ```
- 입력 값 유효성 체크
    - 문자열 정규식 활용