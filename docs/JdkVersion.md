우테코를 시작하기에 앞서, Spring 3.x를 사용하면서 JDK17 버전을 사용하긴 했으나..

무슨 특징이 있는지 모르고 그냥 막무가내로 사용하기만 했었다.

이전 버전도 무슨 특징이 있는지 모르고 사용했었는데 이번 기회에 정리하고 사용할 기회가 있으면 사용해보려고 한다.

---

### **JDK 8**

#### **Lambda 표현식**

단일 메소드 인터페이스 (함수형 인터페이스)의 인스턴스를 훨씬 더 간결하고 표현력이 뛰어나며 가독성 있는 방식으로 작성할 수 있다.

```
List<String> items = new ArrayList<>();
//... add items
items.forEach(item -> System.out.println(item)); // using lambda
```

#### **Stream API**

선언적 방식으로 데이터를 처리할 수 있는 새로운 추상화이다.

멀티스레드 코드를 한 줄도 작성하지 않고 멀티코어 아키텍쳐를 활용할 수 있다.

```
items.stream()
     .filter(s -> s.startsWith("C"))
     .map(String::toUpperCase)
     .forEach(System.out::println); // using Stream API
```

#### **날짜 및 시간 API (JSR 310)**

포괄적인 날짜 및 시간 모델을 제공하는 새로운 패키지 세트

```
LocalDate now = LocalDate.now(); // current date
```

#### **기본 메소드**

인터페이스의 기존 구현을 손상시키지 않고 인터페이스에 새 메소드를 추가할 수 있다.

```
interface MyInterface {
  default void myDefaultMethod() {
      System.out.println("Default implementation");
  }
}
```

### **JDK 9**

#### **Modules**

Java 플랫폼에 표준 모듈 시스템을 도입하여 더 적은 장치에 맞게 플랫폼을 더 쉽게 축소할 수 있다.

```
module com.example.myapp { 
  requires com.example.mymodule; 
}
```

#### **jshell**

언어 기능을 테스트하고 탐색하기 위한 대화형 Java REPL

```
  $ jshell
```

#### **Private 인터페이스 메소드**

인터페이스에 private helper 메소드를 추가할 수 있다.

```
interface MyInterface {
  private void myPrivateMethod() {
      System.out.println("Private implementation");
  }
}
```

### **JDK 10**

#### **지역 변수 타입 추론**

이니셜라이저가 있는 지역 변수의 타입 추론을 확장하도록 Java 언어가 개선되었다.

```
var list = new ArrayList<String>(); // infers ArrayList<String>
var stream = list.stream(); // infers Stream<String>
```

#### **어플리케이션 클래스-데이터-공유(CDS)**

어플리케이션 클래스를 공유 아카이브에 배치할 수 있도록 기존 클래스-데이터 공유 기능을 확장하여 시작 시간과 설치 공간을 최적화한다.

### **JDK 11**

#### **표준 HTTP 클라이언트**

HTTP/2 및 WebSocket을 기본적으로 지원한다.

```
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
  .uri(URI.create("http://example.com"))
  .build();
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
```

#### **문자열 API 업데이트**

isBlank(), lines(), repeat(), strip()과 같은 메소드가 String 클래스에 추가되었다.

```
" ".isBlank(); // true - check if string is empty or contains only white space
"AB\nCD\nEF".lines().forEach(System.out::println); // iterates over "AB", "CD", "EF"
"Echo!".repeat(3); // "Echo!Echo!Echo!"
" ABC ".strip(); // "ABC" - removes leading and trailing white space
```

#### **Epsilon (No-Op Garbage Collector)**

메모리 할당을 처리하지만 실제 메모리 회수 메커니즘을 구현하지 않는 가비지 컬렉터

### **JDK 12**

#### **Switch 표현식 (Preview)**

Switch 문을 확장하여 구문이나 표현식으로 사용할 수 있도록 한다.

```
String result = switch (day) {
  case MONDAY, FRIDAY -> "Monday or Friday";
  case TUESDAY -> "Tuesday";
  case WEDNESDAY, THURSDAY -> "Wednesday or Thursday";
  case SATURDAY, SUNDAY -> "Weekend";
  default -> throw new IllegalStateException("Invalid day: " + day);
};
```

#### **Shenandoah**

실행 중인 Java 프로그램과 동시에 더 많은 가비지 컬렉션 작업을 수행하여 GC 일시 중지 시간을 줄여주는 일시 중지 시간이 짧은 가비지 수집기

### **JDK 13**

#### **Text 블록 (Preview)**

대부분의 이스케이프 시퀀스가 필요하지 않고, 예측 가능한 방식으로 문자열의 형식을 자동으로 지정하며 개발자가 형식을 제어할 수 있는 여러 줄 문자열 리터럴

```
String html = """
  <html>
      <body>
          <p>Hello, world</p>
      </body>
  </html>
"""; // text block
```

#### **ZGC**

Z 가비지 컬렉터를 프로덕션에 사용할 수 있으며 macOS와 Windows에서 사용할 수 있다.

### **JDK 14**

#### **Records (Preview)**

얕은 불변 데이터에 대한 투명한 홀더인 클래스를 선언하기 위한 간결한 구문을 제공한다.

```
record Point(int x, int y) {}
Point p = new Point(1, 2); // x=1, y=2
```

#### **InstanceOf 패턴 매칭 (Preview)**

IntanceOf 연산자에 대한 패턴 일치로 Java 프로그래밍 언어를 향상시킨다.

```
if (obj instanceof String s) {
    // can use s here
} else {
    // can't use s here
}
```

### **JDK 15**

#### **봉인된 클래스 (Preview)**

클래스 또는 인터페이스 작성자가 구현을 담당하는 코드를 제어할 수 있다.

```
sealed class Shape permits Circle, Square, Rectangle {
    //...
}
final class Circle extends Shape {
    //...
}
non-sealed class Rectangle extends Shape {
    //...
}
```

#### **숨겨진 클래스**

런타임에 클래스를 생성하고 리플렉션을 통해 간접적으로 사용하는 프레임워크에서 사용하기 위한 것이다.

숨겨진 클래스는 다른 클래스의 바이트코드에서 직접 사용할 수 없다.

### **JDK 16**

#### **레코드**

JDK 14에서 프리뷰 기능으로 도입되었으며 JDK 16에서는 표준 기능으로 최종 확정되었다.

#### **InstanceOf 패턴 매칭**

JDK 14에서 프리뷰 기능으로 도입되었으며 JDK 16에서는 표준 기능으로 최종 확정되었다.

#### **Unix-Domain 소켓 채널**

Java 가상 머신이 Unix 도메인(로컬) 소켓에 액세스할 수 있다.

### **JDK 17**

#### **봉인된 클래스**

JDK 15에서 프리뷰 기능으로 도입되었으며 JDK 17에서는 표준 기능으로 최종 확정되었다.

#### **Switch에 대한 패턴 일치 (Preview)**

기존 스위치 표현식을 구문으로 사용할 수 있도록 확장하여 스위치 내에서 패턴 매칭을 허용한다.

```
Object obj = //...
switch (obj) {
    case Integer i -> System.out.println("Integer: " + i);
    case String s -> System.out.println("String: " + s);
    case default -> System.out.println("Other");
}
```

#### **새로운 macOS 렌더링 파이프라인**

기존 Quartz 파이프라인의 대안으로 Apple의 Metal 프레임워크를 사용하는 macOS용 새 렌더링 파이프라인이다.

'미리 보기 기능'은 개발자가 사용해 보고 피드백을 제공할 수 있도록 해당 버전에 도입된 기능이라는 의미이다.

---

일반적으로 프로덕션 환경에서는 미리 보기 기능을 사용하지 않는 것이 좋다.

해당 기능이 최종 확정되어 프로덕션 사용을 위해 JDK에 포함되면 표준 기능이 된다.