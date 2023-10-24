# 테스트 코드
지금은 기능 하나를 추가해도 다른 기능에 피해가 가지 않을 정도의 스케일이지만 나중에 가서는 하나 추가하면 여러곳에서 에러가 나올 수 있을 것 같다는 생각에 테스트 코드를 학습하고 직접 적용하려고 한다.
(https://assertj.github.io/doc/, https://yozm.wishket.com/magazine/detail/1964/, https://velog.io/@new_wisdom/assertJ-%EA%B3%B5%EC%8B%9D%EB%AC%B8%EC%84%9C%EC%99%80-%ED%95%A8%EA%BB%98%ED%95%98%EB%8A%94-assertJ-%EC%A0%95%EB%A6%AC)

- @Test: 테스트 어노테이션. 메서드에 이 어노테이션이 붙으면 테스트 메서드가 된다.

## AssertJ
테스트하기 위한 Assertion 도구. JUnit 테스트 도구가 있지만 assertThat을 통해 직관적으로 사용하기 위해 AssertJ를 자주 사용한다.

`Assertions.assertThat(T)`를 입력하면 Assertion이 나온다. 이 assertion를 다른 오브젝트와 비교해서 같은지 확인하는 식으로 테스트를 한다.

- boolean : `assertThat(object).isFalse()`  : false인지 검사
- object : `assertThat(object).isEqualTo(3)` : 3이 맞는지 검사. isNotEqualTo도 있다.
- iterable : `assertThat(iter)`
    - `.filteredOn(student -> student.getName().contains("송")` : 필터를 통해 조건에 맞는 오브젝트만 남긴다.
    - `.isContain("a")` : 포함하는지 검사
    - `.isEmpty()` : 비어있는지 검사


```
@Test 
void 판정테스트() {
	Assertions.assertThat(result1[1]).isEqualTo(3);
}
```
result1[1]이 3이라면 테스트 성공이다.

- exception : 예외가 처리되었는지 테스트 할 수 있다.

```
@Test  
void 재시작입력예외처리테스트(){  
	Display display = new Display();Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {  
        display.getSplitedUserInput(" 12");  
    });
```

`display.getSplitedUserInput(" 12")`은 일부러 IllegalArgumentException을 발생시키는 명령이다. 이 명령으로 인해 예외가 발생하면 테스트 성공.

- exception
  - assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {...}) : {...} 안에서 코드가 돌아갈 때 타깃 예외가 일어나는지 검사한다. 
  - assertThatNoException().isThrownBy(() -> {...}) : {...} 안에서 아무 예외가 일어나지 않는지 검사한다.
## 메서드 분리
테스트 코드를 작성하던 중에 살짝 곤혹스러웠던 부분이 있었다. 테스트를 할 때 기능이 분리되어있지 않아 예외처리 테스트를 할 때 어떻게 콘솔 입력을 해야할 지 고민했었다. 하지만 기능을 분리하여 해결할 수 있었다.
(Mock을 통해 콘솔 입력을 하는 방법이 있다.)

```
public boolean getRestartInput(){
	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	String trimRestartInput = Console.readLine().trim();
	validateOneOrTwo(trimRestartInput);
	if(trimRestartInput.equals("1")){
		return true;
	}
	printEndText();
	return false;
}
```

이것이 이전 코드다. 입력을 받고 1인지 2인지 판별한 후에 리턴한다. 이 메서드는 두 기능을 수행한다.
1. 사용자로부터 입력을 받는다.
2. 1인지 2인지 판별한다.
   하지만 여기서 테스트 코드에서 getRestartInput을 호출해서 에러처리테스트를 하고 싶다면 콘솔에 원하는 값을 입력하는 방법을 찾아야한다. 하지만 이것보다 쉬운 방법이 있다. 아래와 같이 메서드의 기능을 분리하는 것이다.

```
public boolean getRestartInput(){  
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");  
    boolean oneOrTwo = getOneOrTwo(Console.readLine());  
    return oneOrTwo;  
}  
public boolean getOneOrTwo(String input){  
    String trimInput = input.trim();  
    validateOneOrTwo(trimInput);  
    if(trimInput.equals("1")){  
        return true;  
    }  
    printEndText();  
    return false;
}
```

입력이 올바른지 테스트하고 싶다면 getOneOrTwo 를 사용하면 된다.

```
Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {  
    display.getSplitedUserInput("12 ");  
});
```

테스트 코드를 여러개 작성해봤는데 생각보다 귀찮은 작업이 아니었고 단위적으로 테스트 하기 좋은 도구라는 생각이 들었다.
테스트 코드를 먼저 작성해야하는지 아니면 기능을 구현하고 테스트 코드를 먼저 작성해야하는지 모르겠다. 자연스레 TDD에 흥미가 생기는 것 같다.

## input을 시뮬레이팅
기능을 분리하긴 했지만 생각해보면 getOneOrTwo 같은 분리된 메서드는 클래스 안에서만 사용하기 때문에 public으로 바꾸는 것은 옳지 않다고 생각했다. private 접근자로 바꾸고도 테스트가 가능하도록 input에 대해서 시뮬레이트하도록 하는 방법을 서칭했다.
(https://www.baeldung.com/java-junit-testing-system-in)
방법은 Scanner의 동작 방식을 이용하는 것이었다. Scanner는 생성될 때 System.in에서 유저가 입력한 문자 스트림을 가져오는 형식인데 우리가 넣고 싶은 문자를 넣어 Scanner가 가져가도록 유도하면 가능하다.

다음은 입력에 넣고 싶은 문자를 넣는 코드이다.
```
void inputStringToSystemIn(String data){  
    ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());  
    System.setIn(testIn);  
}
```
입력 스트림을 System.in을 ByteArrayInputStream()으로 바꾼다. 
이를 통해 사용자의 입력을 시뮬레이트하면서 테스트 할 수 있었다.
```
@Test  
void 유저입력예외처리테스트_길이가3이아닌입력(){  
    inputStringToSystemIn("12 ");  
	    Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {  
        display.getUserInput();  
    });  
}
```

그러나 두 테스트를 연속으로 실행할 때는 `java.util.NoSuchElementException` 예외가 나왔다. 현재 스트림에 아무것도 없다는 뜻이다. 해결하기 위해 삽질을 했지만 답은 가까이에 있었다.

```
void inputStringToSystemIn(String data){  
    ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());  
    System.setIn(testIn);  
    display.close();
}
```
`System.setIn`은 말 그대로 System.in을 다른 스트림으로 바꾸는 명령이다. 
`display.getUserInput()`은 처음으로 Scanner를 사용하는 명령이기 때문에 Scanner는 바꿔준 `ByteArrayInputStream`을 가지고 입력을 받는다. 
그래서 첫번째 테스트는 성공했다. 하지만 Scanner가 close되지 않고 계속 사용된다면 아무리 `System.setIn`을 해봤자 이전에 설정한 `ByteArrayInputStream`을 가지고 입력을 받으니 아무 입력을 받지않아 `java.util.NoSuchElementException` 예외가 나오는 것이다.
때문에 `display.close();`를 통해 Scanner를 종료해주고 바뀐 입력스트림을 가지고 다시 생성되도록 유도한 것이다. 

## 콘솔 Output 을 테스트에 사용
```
Assertions.assertThat(result1.strikeCount).isEqualTo(3);
```
이전 테스트 코드 중 일부인데 `strikeCount` 접근자가 private로 바꾸었기 때문에 더이상 이 명령문은 작동하지 않는다. 그래서 실제 콘솔의 Output을 받아서 예상한 결과값이 나오는지 테스트하는 코드를 작성하려고 했다.

위에서 콘솔 Input을 우리가 입맛대로 조정하는 것처럼 콘솔 Output도 조정이 가능하다.
```
@Test  
void 판정테스트(){  
    ByteArrayOutputStream testOut = new ByteArrayOutputStream();  
    System.setOut(new PrintStream(testOut));
```
이렇게 `System.out`을 `ByteArrayOutputStream`으로 변경함으로써 아래처럼 콘솔에 나오는 출력값을 가져올 수 있다.
```
result1.printResult();  
Assertions.assertThat(testOut.toString()).isEqualTo("3스트라이크\n");  
testOut.reset();
```
`printResult()`는 결과를 출력하는 메서드다.
`testOut.toString()`으로 결과를 문자열로 바꿔서 테스트를 했다.

```
result1.printResult();  
Assertions.assertThat(testOut.toString()).isEqualTo("3스트라이크\n");  
result2.printResult();
Assertions.assertThat(testOut.toString()).isEqualTo("3볼\n");
```
`reset()`을 하는 이유는 위와 같이 두번 출력을 하게되었을 때 리셋을 하지 않으면 "3스트라이크\n 3볼\n"처럼 이어져서 나오기 떄문이다. 
