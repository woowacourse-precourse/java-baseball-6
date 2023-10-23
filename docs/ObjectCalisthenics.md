## **객체지향 생활체조란?**

좋은 객체 지향 디자인을 하기 위한 9가지 규칙

유지 관리가 용이하고 가독성이 높으며 테스트 가능한 코드를 만드는 것을 목표

---

### **1\. 한 메소드에 한 단계의 들여쓰기만 한다.**

#### **Only One Level of Indentation Per Method**

**\- Without Rules**

```
public void someMethod(List<String> items) {
    for (String item : items) {
        if (item != null) {
            System.out.println(item);
        }
    }
}
```

1차적으로 for문에서 들여쓰기가 되었고, 2차적으로 for문 내부에서 if문에 의해 들여쓰기가 되었다.

**\- With Rules**

```
public void someMethod(List<String> items) {
    for (String item : items) {
        printItemIfNotNull(item);
    }
}

private void printItemIfNotNull(String item) {
    if (item != null) {
        System.out.println(item);
    }
}
```

### **2\. ELSE 예약어를 쓰지 않는다.**

#### **Don't use the ELSE Keyword**

**\- Without Rules**

```
public String describeNumber(int number) {
    if (number > 0) {
        return "Positive";
    } else if (number < 0) {
        return "Negative";
    } else {
        return "Zero";
    }
}
```

**\- With Rules**

1) if문 두 번 사용

```
public String describeNumber(int number) {
    if (number > 0) {
        return "Positive";
    }
    if (number < 0) {
        return "Negative";
    }
    return "Zero";
}
```

2) 다형성 사용

```
interface NumberCategory {
    String describe();
}

class PositiveNumber implements NumberCategory {
    public String describe() { return "Positive"; }
}

class NegativeNumber implements NumberCategory {
    public String describe() { return "Negative"; }
}

class ZeroNumber implements NumberCategory {
    public String describe() { return "Zero"; }
}
```

일반적으로 1)번 방법을 사용하도 충분하나 코드가 복잡할 경우 2)번 방법을 사용하는 것이 좋고 더 객체지향적이다.

더 나아가서 2)번 코드를 사용해보자.

2)번 코드는 양수, 음수, 0일 경우로 나누어 각각의 경우에 맞는 String을 반환하지만 문제는 양수, 음수, 0임을 판단하는 코드가 없다는 것이다.

2)번 코드를 사용하기 위해서는 숫자를 판단하는 로직이 더 필요하다. 마찬가지로 if-elseif-else문을 사용할 수 있지만 객체지향 생활체조 원칙을 사용해보도록하자.

먼저, 위의 코드를 다음과 같이 바꾼다.

```
interface NumberCategory {
    boolean appliesTo(int number);
    String describe();
}

class PositiveNumber implements NumberCategory {
    public boolean appliesTo(int number) {
        return number > 0;
    }

    public String describe() {
        return "Positive";
    }
}

class NegativeNumber implements NumberCategory {
    public boolean appliesTo(int number) {
        return number < 0;
    }

    public String describe() {
        return "Negative";
    }
}

class ZeroNumber implements NumberCategory {
    public boolean appliesTo(int number) {
        return number == 0;
    }

    public String describe() {
        return "Zero";
    }
}
```

interface에 appliesTo() 메소드를 추가했다. 이 메소드가 숫자를 판단해주는 코어 로직이 될 것이다.

```
import java.util.List;

public class NumberCategoryProvider {
    private final List<NumberCategory> categories;

    public NumberCategoryProvider() {
        // Initialize with all possible strategies
        this.categories = List.of(new PositiveNumber(), new NegativeNumber(), new ZeroNumber());
    }

    public NumberCategory determineCategory(int number) {
        // Loop through strategies and find the first that applies
        return this.categories.stream()
            .filter(category -> category.appliesTo(number))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No category available for number: " + number));
    }
}
```

interface를 주입해 만든 클래스들을 하나의 리스트에 저장하고 appliesTo 메소드를 통해 해당 number가 어디에 속하는지 찾아내 해당 객체를 반환한다.

```
public class NumberDescriber {
    private final NumberCategoryProvider categoryProvider;

    public NumberDescriber() {
        this.categoryProvider = new NumberCategoryProvider();
    }

    public String describe(int number) {
        NumberCategory category = categoryProvider.determineCategory(number);
        return category.describe();
    }
}

public class Main {
    public static void main(String[] args) {
        NumberDescriber describer = new NumberDescriber();

        System.out.println(describer.describe(10));  // Output: Positive
        System.out.println(describer.describe(-5));  // Output: Negative
        System.out.println(describer.describe(0));   // Output: Zero
    }
}
```

appliesTo를 통해 숫자를 판별하고 반환된 해당 객체의 describe 메소드를 이용해 String을 출력한다.

### **3\. 모든 원시값과 문자열을 포장한다.**

#### **Wrap All Primitives and Strings**

**\- Without Rules**

```
public class Book {
    private String title;
    private String author;
    private int year;

public class Library {
    public void addBook(String title, String author, int year) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
    }
}
```

**\- With Rules**

```
public class Title {
    private String value;

    public Title(String value) {
        this.value = value;
    }
}

public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }
}

public class Year {
    private int value;

    public Year(int value) {
        this.value = value;
    }
}

public class Book {
    private Title title;
    private Author author;
    private Year year;
}

public class Library {
    public void addBook(Title title, Author author, Year year) {
        Book book = new Book(title, author, year);
    }
}
```

### **4\. 일급 클래스를 사용한다.**

#### **First Class Collections (Collections should only contain other objects, not methods)**

**\- Without Rules**

```
public class Classroom {
    private List<Student> students;
    public void addStudent(Student student) { /*...*/ }
    public void calculateAverageGrade() { /*...*/ }
}
```

**\- With Rules**

```
public class Students {
    private List<Student> studentsList;
    // methods for adding students, etc.
}

public class Classroom {
    private Students students;
    public void calculateAverageGrade() { /*...*/ }
}
```

3번과 4번 규칙의 차이점도 알아보도록 하자.

**\- Without Rules 3 and 4**

```
public class Library {
    private List<String> bookTitles;  // primitive collection

    // methods that operate directly on bookTitles
}
```

**\- With Rule 3 but without Rule 4**

```
public class Library {
    private List<Book> books;  // a collection of objects, but not a first-class collection

    // methods that operate directly on books
}

public class Book {
    private Title title;  // title is now an object, not a primitive

    // other properties and methods
}
```

3번 규칙에 의해 book과 title이 분리되었으며 title은 class의 멤버 변수에 속한다.

title 또한 Title 객체라는 것을 확인할 수 있는데 String title을 클래스로 포장한 것이다.

**\- With Rules 3 and 4**

```
public class Library {
    private BooksCollection books;  // books is now a first-class collection

    // methods delegate behavior to the books collection
}

public class BooksCollection {
    private List<Book> books;  // the collection is encapsulated in its own class

    // all methods that operate on the books collection
}

public class Book {
    private Title title;  // title is still an object

    // other properties and methods
}
```

4번 규칙에 의해 collection 또한 클래스로 포장되었음을 확인할 수 있다.

### **5\. 코드 한 줄에 하나의 점만 쓴다.**

#### **One Dot Per Line (Limit train wrecks)**

**\- Without Rules**

```
String name = student.getParent().getFather().getName();
```

**\- With Rules**

```
String name = student.getFatherName();
```

### **6\. 축약하지 않는다**

#### **Don’t Abbreviate**

**\- Without Rules**

```
public void calcAvg() { /*...*/ }
```

**\- With Rules**

```
public void calculateAverage() { /*...*/ }
```

### **7\. 모든 엔티티를 작게 유지한다.**

#### **Keep All Entities Smal**

**\- Without Rules**

```
public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> findBooksByAuthor(String author) {
    }

    public List<Book> findBooksByTitle(String title) {
    }

    // More methods that make this class over 50 lines
}
```

**\- With Rules**

```
public class Library {
    private final Books books;

    public Library() {
        this.books = new Books();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}

public class Books {
    private final List<Book> booksList;

    public Books() {
        this.booksList = new ArrayList<>();
    }

    public void add(Book book) {
        booksList.add(book);
    }

    public void remove(Book book) {
        booksList.remove(book);
    }

    public List<Book> findByAuthor(Author author) {
        return booksList.stream()
                .filter(book -> book.hasAuthor(author))
                .collect(Collectors.toList());
    }

    public List<Book> findByTitle(Title title) {
        return booksList.stream()
                .filter(book -> book.hasTitle(title))
                .collect(Collectors.toList());
    }
}

public class Book {
    private final Title title;
    private final Author author;

    public boolean hasAuthor(Author author) {
        return this.author.equals(author);
    }

    public boolean hasTitle(Title title) {
        return this.title.equals(title);
    }
}
```

가이드라인 : 클래스 50줄 이하, 메소드 10줄 이하

### **8\. 세 개 이상의 인스턴스 변수를 가진 클래스를 사용하지 않는다.**

#### **No Classes with More Than Two Instance Variables**

**\- Without Rules**

```
public class Person {
    private String name;
    private Address address;
    private Job job;
    private Hobby hobby;
}
```

**\- With Rules**

```
public class PersonalDetails {
    private Name name;
    private Address address;
}

public class Profession {
    private Job job;
    private Hobby hobby;
}
```

### **9\. Getter/Setter/Properties를 사용하지 않는다.**

#### **No Getters/Setters/Properties**

**\- Without Rules**

```
public class Order {
    private int totalCost;

    public int getTotalCost() {
        return totalCost;
    }
}
//...
Order order = new Order();
int cost = order.getTotalCost();
// do something with cost
```

**\- With Rules**

```
public class Order {
    private Cost totalCost; // Cost is a wrapper class over a primitive

    public Receipt processPayment(Payment payment) {
        // here, the action is happening inside the method, 
        // and it's not just returning the raw data.
        // ...
    }
}
```

언뜻 보면 3, 4번 규칙과 헷갈릴 수 있다.

3, 4번 규칙에서는 원시값과 Collection들을 포장하라고 했는데 이 때 Getter, Setter를 써야 접근이 가능하기 때문이다.

9번 규칙의 경우 완전하게 'Getter/Setter/Properties를 사용하지 마라'라고 이해하기 보다는 '**행동 중심적인 코드를 사용하라**'라고 이해하는 것이 좋을 것 같다.

위 예시에서도 totalCost는 Cost에 의해 포장되어 있지만 Cost class에서는 Getter/Setter를 통해 이 원시값을 반환/설정해야한다.

그 메소드들이 있어야 Order객체에서도 쓰일 수 있다.

하지만 Order에서마저 totalCost에 대한 getter/setter를 쓴다면 서비스 로직을 담당하는 것이 다른 클래스로 위임이 되버릴 것이다.

(예를 들면 main에서 서비스 코드가 쓰일 확률이 크다.)

그렇기 때문에 클래스 자체를 행동 중심적인 코드로 작성하라는 의미이다.

또, 3번과 4번 규칙에 의해 class로 포장해버리면 Order에서 totalCost에 대한 getter/setter를 만들 이유가 없다.