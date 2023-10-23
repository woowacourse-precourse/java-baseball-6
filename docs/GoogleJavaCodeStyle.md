원본 : [https://google.github.io/styleguide/javaguide.html](https://google.github.io/styleguide/javaguide.html)

[Google Java Style Guide

1 Introduction This document serves as the complete definition of Google's coding standards for source code in the Java™
Programming Language. A Java source file is described as being in Google Style if and only if it adheres to the rules
herein. Like ot

google.github.io](https://google.github.io/styleguide/javaguide.html)

번역에 추가적인 내용을 추가했다.

우테코 스타일로 넘어가면서 달라진 점은 대체했다.

---

## **2\. 소스 파일**

### **2.1 파일 이름**

1) 최상위 클래스들의 이름을 포함한다.

2) 대소문자를 구별한다.

3) .java 확장자를 가지고 있다.

### **2.2 파일 인코딩 : UTF-8**

소스 파일은 UTF-8로 인코딩한다.

### **2.3 특수 문자들**

#### **2.3.1 공백 문자**

줄 종결자 문장을 제외하고, 소스 파일의 어느 곳에나 나타나는 공백 문자는 ASCII 가로 공백 문자(0x20)가 유일하다.

줄 종결자 문장은 줄 끝을 나타내는데 사용되는 모든 문장이며 \\n 또는 \\r을 의미한다.

1) 문자열 및 문자 리터럴의 다른 모든 공백 문자는 이스케이프 처리된다.

이스케이프 문자 앞에는 백슬래시를 붙여 표시한다. 예를 들어 개행 문자는 \\n으로 표시한다. 또한 탭 문자를 쓸 땐 실제로 삽입하지 않고 \\t를 사용하여 표시한다.

2) 탭 문자는 들여쓰기에 사용되지 않는다.

탭 문자 대신 공백을 사용한다.

#### **2.3.2 특수 이스케이프 문자**

특수 이스케이프 문자(\\b, \\t, \\n, \\f, \\r, \\", \\', \\\\)는 8진수(\\012) 또는 유니코드(\\u000a)를 사용하지 않고 사용한다.

> \- \\b : 백스페이스  
> \- \\t : Tab  
> \- \\n : 개행  
> \- \\f : 양식 피드  
> \- \\r : 캐리지 리턴  
> \- \\" : 큰따옴표  
> \- \\' : 작은따옴표  
> \- \\\\ : 백슬래시

#### **2.3.3 Non-ASCII 문자들**

Non-ASCII 문자의 경우, 실제 유니코드 문자 또는 동등한 유니코드 이스케이프를 사용한다. 문자열 리터럴 및 주석 이외의 유니코드 이스케이프는 강력히 권장하지 않는다.

> 💡 : 유티코드 이스케이프나 실제 유니코드 문자일 경우 주석은 매우 도움이 될 수 있다.

예시 :

| 예시 | 토론 |
| --- | --- |
| `String unitAbbrev = "μs";` | Best: 코멘트 없이도 완벽하게 명확하다. |
| `String unitAbbrev = "\u03bcs"; // "μs"` | 허용되지만, 이렇게 할 이유가 없다. |
| `String unitAbbrev = "\u03bcs"; // Greek letter mu, "s"` | 허용되지만, 어색하고 실수하기 쉽다. |
| `String unitAbbrev = "\u03bcs";` | Poor: 독자는 이것이 무엇인지 전혀 모른다. |
| `return '\ufeff' + content; // byte order mark` | Good: 인쇄할 수 없는 문자에 이스케이프를 사용하고, 필요한 경우 주석을 단다. |

> 💡 : Non-ASCII 문자를 제대로 처리하지 못할 수도 있다는 우려 때문에 코드를 읽을 수 없게 만들지 말아야 한다. 만약 그런 일이 일어난다면, 그 프로그램은 망가졌다는 뜻이고 고쳐야만 한다.

## **3\. 소스 파일 구조**

소스 파일은 **순서대로** 구성되어 있다.

1) 존재하는 경우, 라이선스 또는 저작권 정보

2) Package 구문

3) Import 구문

4) 정확히 하나의 최상위 클래스

**정확히 하나의 빈 줄**이 각 섹션을 구분한다.

### **3.2 Package 구문**

1) **줄바꿈하지 않는다.**

2) 열 제한(120줄)은 적용되지 않는다.

### **3.3 Import 구문**

#### **3.3.1 와일드카드 제한**

정적이든 아니든 **와일드카드는 사용되지 않는다.**

와일드카드 사용 예시 :

```
import java.util.*;
```

#### **3.3.2 줄바꿈 없음**

1) **줄바꿈하지 않는다.**

2) 열 제한(120줄)은 적용되지 않는다.

#### **3.3.3 순서와 공간**

Imports는 다음과 같은 순서를 따른다.

1) 하나의 블럭 안에 static import

2) 하나의 블럭 안에 non-static import

static, non-static import가 모두 있다면, 두 블럭을 빈 칸으로 분리한다. 이 외에 어떠한 다른 빈 칸이 있으면 안된다.

각각의 블럭의 imports는 ASCII 순서로 정렬되어야 한다.

예시 :

```
 import apple.Alpha;
 import banana.Beta;
 import cherry.Charlie;
```

(참고 : '.'가 ';' 앞에 오기 때문에 imports 문이 ASCII 정렬 순서인 것과는 다르다.)

import package.name;과 같이 import문에 마침표가 포함되지만 이 부분은 정렬에 있어서 관여를 하지 않는다.

즉, 전체 문이 아닌 패키지 및 클래스 이름 자체의 순서에 중점을 두어야 한다.

#### **3.3.4 클래스에는 static import가 사용되지 않는다.**

정적 중첩 클래스에 static import가 사용되지 않는다. 일반 imports를 사용한다.

\- 정적 중첩 클래스 (Static Nested class)

: 클래스 내에 정의된 클래스를 중첩 클래스라고 한다. 정적 중첩 클래스는 static 키워드가 표시된 중첩 클래스로, 외부 클래스의 인스턴스가 없어도 접근이 가능하다.

\- Static import

: static import를 사용하면 클래스 이름으로 한정하지 않고도 클래스의 static member에 직접 접근할 수 있다.

static import 예시 :

```
import static com.example.MyClass.myStaticMethod;
```

코드에서 \`MyClass.\`를 붙이지 않고도 \`myStaticMethod\`를 사용할 수 있다.

일반적인 import 예시 :

```
import com.example.MyClass.MyStaticNestedClass;
```

코드에서 \`MyStaticNestedClass\`를 사용하고자 할 때 \`MyStaticNestedClass\`를 참조하면 된다.

### **3.4 Class 선언**

#### **3.4.1 정확히 하나의 최상위 Class 선언**

각 최상위 Class는 자체 소스 파일에 존재한다.

#### **3.4.2 Class 내용의 순서**

유지 관리자가 질문할 경우 설명할 수 있는 **논리적 순서**를 사용한다. 예를 들어, 새로운 메소드를 추가할 땐 아무 이유 없이 클래스의 말미에 삽입되는 것이 아니다. 이 경우, 논리적 순서가 아닌 '날짜별 시간
순서 추가' 순서를 사용하고 있는 것이다.

동일한 이름을 공유하는 Class의 Method는 사이에 다른 멤버가 없이 연속되어 나타난다.

동일한 이름을 가진 여러 생성자나 static, private과 같이 수식어가 다를 때에도 적용이 된다.

## **4\. 포맷**

(**용어 참고** : block은 class, method, 혹은 생성자를 나타낸다. 모든 배열 이니셜라이저는 선택적으로 블록과 같은 구조인 것처럼 취급될 수 있다.)

### **4.1 중괄호**

#### **4.1.1 선택적 중괄호 사용**

if, else, for, do, while과 함께 사용할 때는 본문이 비어있거나 단 하나의 구문만 존재한다고 하더라도 중괄호와 사용한다.

람다 표현식과 같은 중괄호는 선택사항이다.

#### **4.1.2 비어 있지 않은 블록 : K & R 스타일**

중괄호는 비어 있지 않은 블록이나 block-like cunstruct는 Kermighan과 Ritchie 스타일("이집트 괄호")을 따른다.

1) 괄호 열기 전 줄바꿈을 하지 않는다.

2) 괄호 열고 줄바꿈을 한다.

3) 괄호 닫기 전 줄바꿈을 한다.

4) 중괄호가 Method, 생성자, 클래스의 본문을 끝내는 경우에만 괄호 닫은 후 줄바꿈을 한다. 만약, 중괄호 뒤에 else문이나 \`,\`가 온다면 줄바꿈을 하지 않는다.

예시 :

```
return () -> {
  while (condition()) {
    method();
  }
};

return new MyClass() {
  @Override public void method() {
    if (condition()) {
      try {
        something();
      } catch (ProblemException e) {
        recover();
      }
    } else if (otherCondition()) {
      somethingElse();
    } else {
      lastThing();
    }
    {
      int x = foo();
      frob(x);
    }
  }
};
```

#### **4.1.3 빈 블록 : 간결할 수 있다.**

빈 블록이나 block-like construct는 K & R 스타일을 준수할 수 있다. 중괄호 사이에 문자가 없거나 줄바꿈만 있다면 열자마자 중괄호를 끝낼 수 있다. 하지만 멀티 블럭(if/else,
try/catch/finally)에서는 할 수 없다.

가능한 예시 :

```
// This is acceptable
void doNothing() {}

// This is equally acceptable
void doNothingElse() {
}
```

가능하지 않은 예시 :

```
// This is not acceptable: No concise empty blocks in a multi-block statement
try {
doSomething();
} catch (Exception e) {}
```

### **4.2 블록 들여쓰기: +4 공백**

새 블록 또는 블록과 유사한 구조(block-like construct)가 열릴 때마다 들여쓰기가 네 칸씩 증가한다. 블록이 끝나면 들여쓰기는 이전 들여쓰기 단계로 돌아간다. 들여쓰기 단계는 블록 전체의 코드와 주석
모두에 적용된다.

### **4.3 한 줄에 하나의 구문**

각 구문 뒤에 줄 바꿈이 있다.

### **4.4 열 제한: 120**

120자의 열 제한이 있다. 다음 예외 사항을 제외하고 줄 바꿈 규칙에 의해 줄 바꿈 되어야 한다.

> 💡 각 유니코드는 디스플레이 너비와 상관없이 한 문자로 계산된다. 전폭 문자를 사용하는 경우에 일찍 줄 바꿈을 할 수 있다.  
> 전폭문자 (fullwidth characters)  
> : 일반 문자보다 더 많은 공간을 차지한다.  
> 한중일이나 라틴어가 포함된 문자에 해당한다.

예외 :

1) 열 제한을 준수할 수 없는 줄 (ex: JavaDoc의 긴 URL 또는 긴 JSNI 메소드 참조)

2) package와 import

3) 셸에 복사하여 붙여넣을 수 있는 주석의 명령줄

4) 드물게 요구되는 매우 긴 식별자의 경우 열 제한을 초과할 수 있다. 주변 코드에 대한 유효한
   래핑은 [google-java-format](https://github.com/google/google-java-format)에 의해 생성된다.

### **4.5 줄 바꿈**

(용어 참고 : 합법적으로 한 줄을 차지할 수 있는 코드가 여러 줄로 나뉘면 줄 바꿈이라고 한다.)

모든 상황에서 줄 바꿈을 정확히 어떻게 해야하는지 보여주는 포괄적이고 결정론적인 공식은 없다. 종종 같은 코드를 줄 바꿈하는 몇 가지 유효한 방법이 있다.

> 🗒️ 줄 바꿈의 일반적인 이유는 열 제한이 넘쳐나는 것을 피하기 위한 것이지만, 실제로 열 제한에 맞는 코드조차도 재량에 따라 줄 바꿈 될 수 있다.

> 💡 method나 local variable을 추출하면 줄 바꿈 없이 문제를 해결할 수 있다.

#### **4.5.1 줄바꿈을 하는 곳**

줄 바꿈의 주요 지침은 다음과 같다.

1) 더 높은 구문 수준에서 줄 바꿈하는 것을 선호한다.

2) 비할당 연산자에서 줄 바꿈이 일어날 경우 줄 바꿈은 기호 이전에 위치한다.

예시 :

```
int result = aLongExpressionThatExceedsLineLength
    + anotherLongExpressionThatExceedsLineLength;
```

\- 점 구분 기호(.)

예시 :

```
object.method()
    .anotherMethod()
    .yetAnotherMethod();
```

\- method 참조의 두 콜론 (::)

예시 :

```
something.stream()
    .map(entry::getValue)
    .collect(Collectors.toList());
```

\- 타입 바운딩의 앰퍼센드 기호 (<T extends Foo & Bar>)

예시 :

```
class MyClass<T extends Serializable 
    & Comparable<T>> {
// class body
}
```

\- catch 블럭의 파이프 (catch (FooException | BarException e))

예시 :

```
try {
    methodThatThrowsExceptions();
} catch (IOException 
    | SQLException e) {
    handleException(e);
}
```

3) 할당 연산자에서 줄 바꿈이 일어날 경우 줄 바꿈은 기호 다음에 위치하지만 바뀌어도 상관없다.

예시 :

```
someVariable = 
    someLongExpressionThatExceedsLineLength;

//or

someVariable
    = someLongExpressionThatExceedsLineLength;
```

\- 향상된 for문 (for each)의 \`assignment-operator-like\`에도 적용된다.

예시 :

```
for (Type item :
    collection) {
    // loop body
}
```

4) Method나 생성자의 이름에 여는 괄호가 있을 때

예시 :

```
someMethod(
    argument1, argument2, argument3);
```

5) 앞에 토큰에 연결된 콤마가 있을 때

예시 :

```
someMethod(argument1,
    argument2,
    argument3);
```

6) 람다의 인접한 화살표에서는 줄 바꿈이 일어나지 않는다. 하지만 람다의 내용이 한 줄로 되어 있다면 줄 바꿈이 가능하다.

예시 :

```
MyLambda<String, Long, Object> lambda =
    (String label, Long value, Object obj) -> {
        ...
    };

Predicate<String> predicate = str ->
    longExpressionInvolving(str);
```

> 🗒️ 줄 바꿈의 주요 목표는 가장 적은 줄 수에 맞는 코드를 작성하는 것이 아닌 명확한 코드를 작성하기 위함이다.

#### **4.5.2 들여쓰기 지속은 최소 +8 스페이스**

줄 바꿈 시 그 다음 줄은 원래 줄에서 +8 이상 들여쓴다.

### **4.6 공백**

#### **4.6.1 수직 공백**

하나의 빈 줄이 항상 나타난다.

1) 연속적인 멤버나 Class의 초기화: 필드, 생성자, Method, 중첩 Class, 정적 초기화, 인스턴스 초기화

\- **예외** : 두 개의 연속된 필드의 공백은 선택적이다. 이러한 빈 줄은 논리적인 필드 그룹을 만드는데 필요에 따라 사용된다.

\- **예외** : enum의 공백

2) 이 문서의 다른 섹션에서 요구하는 대로 (ex : 3. 소스파일 구조 및 3.3 import 구문)

단일 빈 줄은 가독성을 향상시키는 모든 곳에 나타날 수 있다. 예를 들어, 코드를 논리적 하위 섹션으로 구성하기 위한 문 사이에 나타날 수 있다.

첫 번째 멤버 또는 이니셜라이저, 마지막 멤버 또는 이니셜라이저 후의 빈 칸은 권장되지도 비권장되지도 않는다.

#### **4.6.2 수평 공백**

언어 또는 기타 스타일 규칙에서 요구하는 것 외에도, 리터럴, 주석 및 Javadoc을 제외하고 단일 ASCII 공간 또한 다음 **장소에서만** 나타난다.

1) if, for, catch와 같은 예약어 이후 나오는 여는 괄호에서 사용

2) if, for, catch와 같은 예약어 이후 나오는 닫는 중괄호에서 사용

3) 중괄호를 여는 모든 경우에 사용

예외 :

```
@SomeAnnotation({a, b})
```

```
String[][] x = {{"foo"}};
```

4) 임의의 이항 또는 삼항 연산자 양쪽에 사용하며 \`operator-like\`기호에도 적용된다.

\- 인접한 타입 바운딩의 앰퍼센드 연산자에서 : <T extends Foo & Bar>

\- 예외처리의 파이프에서 : catch (FooException | BarException e)

\- 향상된 for문 (for-each)에서

\- 람다의 화살표에서 : (String str) -> str.length()

예외 :

\- 두 개의 콜론(::)에서는 공백이 오지 않는다. : Object::toString

\- dot(.)에서는 공백이 오지 않는다. : Object.toString()

5) ',:;'나 닫는 괄호(')') 뒤에서 사용

6) 모든 주석을 시작하는 이중 슬래시(//) 사이에 사용되며 여러 빈칸이 허용된다.

7) 이중 슬래시(//)와 주석 사이에 사용되며 여러 빈칸이 허용된다.

8) 선언의 타입과 변수 사이에 사용된다. : List list

9) 배열 초기화의 두 중괄호 안에 사용되며 선택사항이다.

\- new int\[\] {5, 6} or new int\[\] { 5, 6 }

10) 타입 어노테이션과 \[\] 또는 ...

이 규칙은 줄의 시작이나 끝에 추가 공간을 요구하거나 금지하는 것으로 해석되지 않는다. 내부 공간만 다룬다.

#### **4.6.3 수평 정렬 : 절대 필요하지 않다.**

(**용어 참고** : 수평 정렬은 특정 토큰이 이전 줄의 특정 다른 토큰 바로 아래에 나타나도록 하기 위해 코드에 가변 수의 추가 공백을 추가하는 관행이다.)

이 관행은 허용되지만, 절대 요구되지 않는다. 이미 사용된 곳에서 수평 정렬을 유지할 필요가 없다.

```
private int x; // this is fine
private Color color; // this too

private int   x;      // permitted, but future edits
private Color color;  // may leave it unaligned
```

> 💡 정렬은 가독성을 도울 수 있지만 향후 유지 보수에 문제를 일으킨다. 한 줄을 수정해야할 때 이전에 만족했던 포맷을 망가뜨린다. 더욱 인근 라인의 공백을 조정하도록 촉구하며 이것은 일련의 재포맷을 촉발할 수도 있다. 그 한 줄의 변화는 '폭발 반경'을 가지고 있다. 이것은 최악의 경우 무의미한 바쁜 일을 초래할 수도 있지만, 버전 기록 정보를 손상시키고, 검토자의 속도를 늦추고, 병합 충돌을 악화시킨다.

### **4.7 괄호 그룹화 : 추천**

선택적 괄호 그룹화는 저자와 검토자가 괄호 없이도 코드가 잘못 해석될 가능성이 없다는데 동의하는 경우에만 생략된다.

모든 독자가 전체 자바 연산자 우선 순위 테이블을 암기했다고 가정하는 것은 합리적이지 않다.

예시 :

```
//bad :
int result = a + b * c;

//good : 
int result = a + (b * c);
```

### **4.8 특정한 constructs**

#### **4.8.1 Enum Classes**

Enum 상수를 따르는 각 쉼표 뒤에 줄 바꿈은 선택 사항이다.

추가 줄 바꿈도 허용된다.(보통 하나만)

```
private enum Answer {
  YES {
    @Override public String toString() {
      return "yes";
    }
  },

  NO,
  MAYBE
}
```

Method가 존재하지 않고 이에 대한 문서가 없는 Enum 클래스는 배열 이니셜라이저인 것처럼 선택적으로 포맷될 수 있다.

```
private enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }
```

Enum 클래스도 클래스이기 때문에 클래스를 포맷하기 위한 다른 모든 규칙이 적용된다.

#### **4.8.2 변수 선언**

1) 한 번에 하나의 변수만 선언 가능하다. int a, b;는 사용되지 않는다.

예외 : for문의 헤더에서는 여러 개의 변수를 선언할 수 있다.

2) 지역 변수는 시작 부분에서 습관적으로 선언되지 않는 대신, 범위를 최소화하기 위해 처음 사용되는 지점에 가깝게 선언된다. 지역 변수 선언은 일반적으로 이니셜라이저를 가지고 있거나, 선언 직후에 초기화된다.

#### **4.8.3 배열**

1) 모든 배열 이니셜라이저는 선택적으로 block-like construct와 같은 포맷을 가질 수 있다. 예를 들어서 다음은 모두 유효하다.

```
new int[] {           new int[] {
  0, 1, 2, 3            0,
}                       1,
                        2,
new int[] {             3,
  0, 1,               }
  2, 3
}                     new int[]
                          {0, 1, 2, 3}
```

2) C-스타일 배열을 선언하지 않는다. String args\[\]가 아닌 String\[\] args를 사용한다.

#### **4.8.4 Switch 문**

(용어 참조 : Swith block은 하나 또는 여러 구문의 그룹이다. 각각의 구문은 하나 또는 더 많은 switch label(case Foo: or default: )를 포함한다.)

1) 들여쓰기는 +4이다. 스위치 라벨 후, 줄 바꿈이 있고, 들여쓰기가 +4 증가한다. 스위치 라벨 이후에는 이전 들여쓰기 수준으로 돌아간다.

2) switch 블럭 이내의 각 구문들은 갑자기 종료(break, continue, return 혹은 exception)될 수 있다. 혹은 다음 구문으로 실행되게 넘어가는 것으로 표시할 수 있다. 이 불발 상황에
   대해 주석을 남길 수 있다. 이 특별한 주석은 switch의 마지막에만 올 필요가 없다.

```
switch (input) {
  case 1:
  case 2:
    prepareOneOrTwo();
    // fall through
  case 3:
    handleOneTwoOrThree();
    break;
  default:
    handleLargeNumber(input);
}
```

3) 코드가 존재하지 않더라도 default 라벨이 존재한다.

예외 : enum 타입의 switch는 다른 모든 경우를 다 처리했다면 default를 생략할 수 있다. IDE나 다른 정적 분석 툴에서는 빠진 것들을 경고해준다.

#### **4.8.5 어노테이션**

1) 타입 어노테이션

\- 어노테이션이 달린 타입 바로 앞에 나타난다. @Target(ElementType.TYPE\_USE)의 메타 어노테이션일 경우 타입 어노테이션이라고 부른다.

```
final @Nullable String name;

public @Nullable Person getPersonByName(String name);
```

2) 클래스 어노테이션

\- 클래스에 적용되는 어노테이션은 documentation block 직후에 나타나며 하나의 줄 바꿈을 가지고 있다.

\- 들여쓰기 수준이 증가하지 않는다.

```
@Deprecated
@CheckReturnValue
public final class Frozzler { ... }
```

3) Method와 클래스 어노테이션

\- 이전 섹션과 동일하다.

```
@Deprecated
@Override
public String getNameIfPresent() { ... }
```

\- 예외 : 단일 어노테이션은 같은 줄에 나열될 수 있다.

```
@Override public int hashCode() { ... }
```

4) 필드 어노테이션

\- documentation 블록 뒤에 적용되지만 여러 어노테이션이 같은 줄에 나열될 수 있다.

```
@Partial @Mock DataLoader loader;
```

5) 매개 변수 및 지역 변수 어노테이션

\- 특정한 규칙이 없다. (타입 어노테이션인 경우를 제외하고)

#### **4.8.6 주석**

이 섹션에서는 구현 주석을 다룬다.

줄 바꿈 앞에 임의의 공백 문자와 그 뒤를 잇는 구현 주석이 올 수 있다. 이러한 주석은 그 행을 비어있지 않게 만든다.

1) 블록 주석 스타일

\- 블럭 주석 스타일은 둘러 쌓인 코드와 같은 들여쓰기 레벨을 가진다.

\- /\*...\*/나 // ... 의 스타일을 가진다.

\- 여러 줄일 경우 뒤이어 오는 줄은 \*로 시작해야하며, 그 이전 \*과 줄이 맞아야 한다.

```
/*
 * This is          // And so           /* Or you can
 * okay.            // is this.          * even do this. */
 */
```

\- 주석은 별표 또는 기타 문자로 그려진 박스에 넣지 않는다.

> 💡 여러 줄의 주석을 작성할 때 문단 형식으로 포맷팅하고 싶다면 /\*...\*/의 형식으로 작성한다. 대부분 포맷터들은 //...의 포맷팅을 지원하지 않는다.

#### **4.8.7 접근 제한자**

클래스 및 멤버 접근 제한자는 자바 언어 사양에서 권장하는 순서로 나타나나다.

```
public protected private abstract default static final transient volatile synchronized native strictfp
```

#### **4.8.8 숫자 리터럴**

Long은 대문자 L 접미사와 함께 쓴다. (숫자 1과 헷갈리지 않기 위함이다.)

예를 들어, 3000000000l보다 3000000000L을 쓴다.

## **5 네이밍**

### **5.1 모든 식별자에 공통된 규칙**

1) 식별자는 ASCII 숫자와 문자만을 쓴다.

2) 일부 경우 언더 스코어(\_)를 쓴다.

3) 유효한 식별자 이름은 정규식 \\w+와 매칭된다.

: \\w는 일반적으로 영숫자와 밑줄을 의미하는 모든 단어 문자이다. +는 이전 요소의 하나 이상의 발생을 의미한다. 따라서 \\w+는 \\w가 나타내는 문자 중 하나 이상과 일치한다.

구글 스타일에서 특별한 접미사나 접두사는 사용되지 않는다. 다음은 구글 스타일 네이밍이 아니다 : name\_, mName, s\_name, kName

### **5.2 식별자 유형별 규칙**

#### **5.2.1 Package 이름**

1) 소문자나 숫자만을 이용한다.2) 언더스코어(\_)는 사용되지 않는다.3) 연속된 단어는 붙여 사용한다.: com.example.deepSpace나 com.example.deep\_space 대신에
   com.example.deepspace를 쓴다.

#### **5.2.2 Class 이름**

1) UpperCamelCase로 작성된다.

2) 명사형으로 작성된다.

: Character이나 ImmutableList

3) 인터페이스 이름 또한 명사형으로 작성되지만, 형용사일 경우도 있다.

: List, Readable

4) 어노테이션 타입에 만들어진 규칙은 없다.

5) 테스트 클래스는 Test로 끝난다.

: HashIntegrationTest

#### **5.2.3 Method 이름**

1) lowerCamelCase로 작성된다.

2) 동사형으로 작성된다.

: sendMessage, stop

3) JUnit 테스트 방법에 언더스코어(\_)가 나타날 수 있으며 각 구성 요소는 lowerCamelCase로 작성된다. 테스트 방법을 명명하는 올바른 방법은 없다.

#### **5.2.4 상수 이름**

1) UPPER\_SNAKE\_CASE로 사용한다.

2) 모든 대문자, 각 단어는 다음 단어와 하나의 밑줄로 구분된다.

3) 명사형이다.

상수란 내용이 완전히 불변하며 감지 가능한 부작용이 없는 static final 필드이다. 예로 프리미티브, 문자열, 불변 값 클래스 및 null로 설정된 모든 것들이 있다. 인스턴스의 관찰 가능한 상태가 바뀔 수
있다면 그것은 상수가 아니다.객체를 절대 변형시키지 않으려고 하는 것만으로는 충분하지 않다.

예시 :

```
// Constants
static final int NUMBER = 5;
static final ImmutableList<String> NAMES = ImmutableList.of("Ed", "Ann");
static final Map<String, Integer> AGES = ImmutableMap.of("Ed", 35, "Ann", 32);
static final Joiner COMMA_JOINER = Joiner.on(','); // because Joiner is immutable
static final SomeMutableType[] EMPTY_ARRAY = {};

// Not constants
static String nonFinal = "non-final";
final String nonStatic = "non-static";
static final Set<String> mutableCollection = new HashSet<String>();
static final ImmutableSet<SomeMutableType> mutableElements = ImmutableSet.of(mutable);
static final ImmutableMap<String, SomeMutableType> mutableValues =
    ImmutableMap.of("Ed", mutableInstance, "Ann", mutableInstance2);
static final Logger logger = Logger.getLogger(MyClass.getName());
static final String[] nonEmptyArray = {"these", "can", "change"};
```

#### **5.2.5 상수가 아닌 필드 이름**

1) lowerCamelCase로 작성한다.

2) 명사형이다.

: computedValues or index

#### **5.2.6 매개 변수 이름**

1) lowerCamelCase로 작성한다.

2) public Method에서 한 개의 문자를 가진 파라미터는 피해야 한다.

#### **5.2.7 지역 변수 이름**

1) lowerCamelCase로 작성한다.

2) 최종적이고 불변하더라도, 지역 변수는 상수로 간주되지 않고 상수로 지정되어서도 안된다.

#### **5.2.8 타입 변수 이름**

두 가지 스타일 중 하나로 명명된다.

1) 단일 대문자, 선택적으로 단일 숫자 (E, T, X, T2)

2) 클래스 이름의 형식에 대문자 T가 따라 오는 형식 (RequestT, FooBarT)

### **5.3 Camel case**

때때로 "IPv6" 또는 "iOS"와 같은 약어나 특이한 구성이 있을 때와 같이 영어 문구를 CamelCase로 변환하는 합리적인 방법이 하나 이상 존재한다. 예측 가능성을 개선하기 위해, 구글 스타일은 다음과
같은 (거의) 결정론적 계획을 명시한다.

1) 문구를 일반 ASCII로 변환하고 아포스트로피를 제거한다.

: "Müller's algorithm"은 "Muellers algorithm"이 된다.

2) 이 결과를 공백과 나머지 구두점(일반적으로 '-')을 나누는 단어로 나눈다.

: 권장 사항 - 어떤 단어가 이미 일반적인 사용법에서 전통적인 CamelCase 모양을 가지고 있다면, 이것을 구성 부분으로 나눈다. (예를 들어 "AdWords"는 "ad words"가 된다.)"iOS"와 같은
단어는 실제 CamelCase 모양을 따르지 않는다는 점에 유의해야한다. 이는 어떠한 관습도 무시하므로, 권장 사항이 적용되지 않는다.

3) 모든 것을 소문자로 하고(두문자어 포함), 첫 번째 문자만 대문자로 사용한다.

\- 각 단어(UpperCamelCase)

\- 첫 단어를 제외한 각 단어(lowerCamelCase)

4) 모든 단어를 단일 식별자로 결합한다

원래 단어의 케이스는 완전히 무시된다는 점에 유의한다.

예시:

| Prose form | Correct | Incorrect |
| --- | --- | --- |
| "XML HTTP request" | `XmlHttpRequest` | XMLHTTPRequest |
| "new customer ID" | `newCustomerId` | `newCustomerID` |
| "inner stopwatch" | `innerStopwatch` | `innerStopWatch` |
| "supports IPv6 on iOS?" | `supportsIpv6OnIos` | `supportsIPv6OnIOS` |
| "YouTube importer" | `YouTubeImporter` `YoutubeImporter`\* |   |

> 🗒️ 일부 단어는 영어로 모호하게 하이픈이 지정되어 있다. 예를 들어 "nonempty"나 "non-empty"는 둘 다 정확하므로, 메소드 이름 checkNonempty, checkNonEmpty 둘 다 정확한 표현이다.

## **6\. 프로그래밍 연습**

### **6.1 @Override : 항상 사용됨**

@Override를 사용할 수 있을 때마다 이 어노테이션을 사용한다.

이것은 클래스가 슈퍼 클래스의 메소드를 오버라이딩 하는 것을 나타내기도 하고, 인터페이스의 메소드를 구현하는 것을 나타내기도 하며 슈퍼 인터페이스의 메소드를 재구현하는 것을 나타낼 수도 있다.

**예외** : 부모 메소드가 @Deprecated때 @Override를 생략할 수 있다.

### **6.2 Exception 잡기 : 생략하지 않기**

아래에 언급된 것을 제외하고 잡힌 Exception에 대응하여 아무것도 하지 않는 것은 옳지 않다. (일반적인 응답은 그것을 기록하거나, "불가능"으로 간주되면 AssertionError를 다시 던진다.

catch 블록에서 어떠한 조치도 취하지 않는 것이 진정으로 적절할 때, 이것이 정당화되는 이유는 주석에 설명된다.

```
try {
  int i = Integer.parseInt(response);
  return handleNumericResponse(i);
} catch (NumberFormatException ok) {
  // it's not numeric; that's fine, just continue
}
return handleTextResponse(response);
```

**예외** : 테스트에서 잡힌 Exception의 이름이 expected로 시작되는 경우 주석 없이 무시될 수 있다. 다음은 테스트 중인 코드가 예상 유형의 Exception을 던지도록 하기 위한 매우 일반적인
관용어이므로 주석이 필요하지 않다.

```
try {
  emptyStack.pop();
  fail();
} catch (NoSuchElementException expected) {
}
```

### **6.3 Static 멤버 : Class를 사용할 수 있음**

정적 클래스 멤버에 대한 참조가 필요한 경우, 해당 클래스 유형의 참조나 표현식이 아니라 해당 클래스 이름으로 정규화된다.

정적 메소드나 정적 변수와 같이 클래스의 정적 멤버를 참조해야 할 때는 항상 클래스 이름 자체를 사용해야한다. 해당 클래스의 인스턴스나 해당 클래스의 인스턴스를 생성하는 표현식에 대한 참조를 사용해서는 안된다.

```
Foo aFoo = ...;
Foo.aStaticMethod(); // good
aFoo.aStaticMethod(); // bad
somethingThatYieldsAFoo().aStaticMethod(); // very bad
```

## **7\. Javadoc**

Javadoc은 Java 소스 코드 문서 생성을 위한 도구이다. 이 도구는 Java 소스 코드 파일(확장자가 .java인 파일)에서 HTML 형식의 API 문서를 생성한다. HTML 형식을 사용하면 관련 문서에 쉽게
연결하고 문서를 탐색할 수 있다. Javadoc은 메소드, 생성자, 인스턴스 변수 등 클래스의 공개 및 보호 멤버를 문서화하는데 자주 사용된다.

Javadoc은 "Javadoc 주석"이라는 특수한 형식의 주석 블록을 사용한다. Javadoc 주석은 '/\*\*'로 시작하여 '\*/'로 끝난다. 이러한 주석은 클래스, 필드, 생성자 또는 메소드 선언 앞에
위치하며 설명 및 기타 관련 정보를 제공한다.

```
/**
 * The {@code HelloWorld} class represents a simple program
 * that outputs "Hello, World!" to the console.
 * <p>
 * This serves as a basic example of Java's capabilities
 * for a first-time programmer.
 * 
 * @author John Doe
 * @version 1.0
 */
public class HelloWorld {

    /**
     * This method is the entry point for the application.
     * <p>
     * When the application launches, this method is invoked
     * and outputs "Hello, World!" to the console.
     *
     * @param args A string array containing command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!"); // Prints the greeting to the console
    }
}
```

### **7.1 포맷팅**

#### **7.1.1 일반 양식**

Javadoc 블록의 일반 양식은 다음 예에서 볼 수 있다 :

```
/**
 * Multiple lines of Javadoc text are written here,
 * wrapped normally...
 */
public int method(String p1) { ... }
```

```
/** An especially short bit of Javadoc. */
```

기본 형식은 항상 받아들여질 수 있다. Javadoc 블록 전체(주석 포함)가 한 줄에 맞을 수 있을 때 한 줄 형식으로 대체될 수 있다. 이것은 @return같은 블록 태그가 없을 때만 적용된다는 점에 유의해야
한다.

#### **7.1.2 단락**

한 개의 빈 줄 - 하나의 공백 행 (즉, 정렬된 선행 별표 (\*)만 포함하는 행)은 단락 사이와 블록 태그 그룹 앞에 표시된다. 첫 번째 단락을 제외한 각 단락은 첫 단어 바로 앞에

가 빈칸 없이 표시된다.

이나

처럼 HTML 태그같은 다른 block 원소의 경우,로 표시되지 않는다.**7.1.3 블록 태그**사용되는 표준 "블록 태그"는 @param, @return, @throws, @deprecated 순서로 표시되며,
이 네가지 유형은 절대로 빈 설명과 함께 표시되지 않는다.블록 태그가 한 줄에 맞지 않을 때, 연속선은 @의 위치에서 네 개(또는 그 이상) 공간을 들여쓴다.

**7.2 요약 조각**

각 Javadoc 블록은 간략한 요약 조각으로 시작된다. 이 조각은 매우 중요하다: 그것은 클래스와 메소드 인덱스와 같은 특정 컨텍스트에 나타나는 텍스트의 유일한 부분이다.완전한 문장이 아닌 명사구 또는 동사구인
단편이다. 그것은 A {@code Foo} is a..., This method returns..., Save the record. 와 같은 완전한 명령 문장을 형성하지 않지만 마치 완전한 문장인 것처럼 대문자로
구분된다.

💡 /\*\* @return the customer ID \*/ 형식을 사용하는 간단한 Javadoc 실수가 발생할 수 있다. 이것은 /\*\* Returns the customer ID \*/로 바뀌어야 한다.

/\*\* @return the customer ID\*/  
: 이 코멘트는 @return 태그를 사용하지만 메소드가 수행하는 작업에 대한 설명 문장을 제공하지 않는다. 반환 값만 설명한다. @return은 일반적으로 반환 값의 특성에 대한 자세한 내용을 제공하는데 사용되며
전체 메소드의 목적을 설명하는데에는 사용되지 않는다.

/\*\* Returns the customer ID \*/  
: 메소드가 수행하는 작업, 즉 고객 ID를 반환하는 작업을 설명하는 설명 주석이다. 메소드의 이름이나 코드를 보지 않고도 메소드의 목적이 무엇인지 명확하게 알 수 있는 완전한 문장이다.

```
/**
 * Retrieves the unique identifier for the customer.
 *
 * @return the customer ID that uniquely identifies the customer in the database
 */
public int getCustomerID() {
    // method implementation here
}
```

**7.3 Javadoc이 사용되는 곳**최소한, Javdoc은 모든 public 클래스에 쓰이고 다음 예외를 제외한 클래스의 모든 public 또는 protected 멤버에 쓰인다.**7.3.1 예외 : 자가 설명
메소드**Javadoc은 "Returns the foo" 외에는 말할 가치가 없는 간단하고 명백한 getFoo()와 같은 경우 선택적이다.

> ⚠️ 일반적인 독자가 알아야 할 관련 정보를 생략하는 것을 정당화하기 위해 이 예외를 인용하는 것은 적절하지 않다. 예를 들어 일반적인 독자가 "canonical name"이라는 것을 모른다면 getCanonicalName이라는 메소드를 오직 /\*\*Returns the Canonical name\*/이라는 말로 생략하지 말아야한다.

**7.3.2 예외 - 오버라이드**Javadoc은 슈퍼 타입 메소드를 오버라이드 할 때 항상 존재하지는 않는다.**7.3.4 필요하지 않은 Javadoc**다른 클래스와 멤버들은 필요하거나 원할 때 Javadoc을
가지고 있다.구현 주석이 클래스 또는 멤버의 전반적인 용도 또는 동작을 정의하는데 사용이 된다면 해당 주석은 Javadoc으로 대신 작성한다. (/\*\* 사용)불필요한 Javadoc은 7.1.2, 7.1.3,
7.2절의 포맷 규칙을 엄격히 준수할 것을 요구하지는 않지만 권장된다.