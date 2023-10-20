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