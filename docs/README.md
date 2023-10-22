# 프리코스 미션1 - 숫자 야구

## 기능 요구 사항 & 과제 진행 요구 사항
- start: [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
### 입출력
#### 입력
- 서로 다른 3자리의 수(string 형태로 입력)
```
String userInput = scanner.nextLine();
```
  - 각 자리별 숫자 비교를 위해 
  - random하게 생성된 세자리의 숫자의 경우 list내 elements의 자료형은 int형이므로 string 형태로 받은 데이터를 int로 변환후 list 형태로 생성
  - convertInputToNumbers(String) 기능 구현
    - 입력이 없거나, 3자리를 초과한 숫자 입력시 IllegalArgumentException() 조건으로 이동
    - 1자리나 2자리 입력 시, '002'나 '012'와 같이 앞에 0을 붙여줘서 3자리 형태의 int형의 list 생성
    - 각 자리의 숫자에 대하여, 1~9가 아닌 경우 IllegalArgumentException() 조건으로 이동
```java
public List<Integer> convertInputToNumbers(String input) {
    List<Integer> userNumbers = new ArrayList<>();
    // 입력이 없거나, 3자리를 초과한 숫자를 입력한 경우
    if (input.length() > DIGIT_COUNT || input.length() == 0) {
        throw new IllegalArgumentException();
    }
    // 3자리의 숫자 입력시
    if (input.length() == 3){
    for (char ch : input.toCharArray()) {
        int number = Character.getNumericValue(ch);
        // 1~9 외의 숫자 입력 시
        if (number < 1 || number > 9) {
        throw new IllegalArgumentException();
    }
    userNumbers.add(number);
    }
    // 1자리 숫자 혹은 2자리 숫자 입력시
    else{
        int zeroNum = DIGIT_COUNT - input.length();
        for (int i=0; i < zeroNum; i++){
        userNumbers.add(0);
        }
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            // 1~9 외의 숫자 입력 시
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
            userNumbers.add(number);
        }
    }
}
```
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수 입력
  - checkRestart : 재시작/종료 여부를 판단하는 변수
    - 'int checkRestart = Integer.parseInt(scanner.nextLine());'를 통해 입력
```java
// 1 입력 시, 재시작을 위한 랜덤수 생성
if (checkRestart == 1) {
    computerNumbers = generateRandomNumbers();
}
// 2 입력 시, 종료
else{
    break;     // end game
}
```


#### 출력
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
0볼 1스트라이크
숫자를 입력해주세요 : 134
2볼 0스트라이크
숫자를 입력해주세요 : 453
0볼 2스트라이크
숫자를 입력해주세요 : 463
0볼 2스트라이크
숫자를 입력해주세요 : 473
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 
```

### 구현할 기능 및 구현 내용
#### 랜덤 숫자 생성
- generateRandomNumbers(): 프로그램 실행 시, random한 세자리의 숫자 생성 기능
  - 12321
```java
public List<Integer> generateRandomNumbers() {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        // 각 자리에 대하여 중복되는 숫자(ex:112)가 들어가지 않도록 조건을 세워둠
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
    return computer;
}
```
- playGame(): 구현한 기능들을 바탕으로 main함수를 통해 본격적으로 진행하기 위한 기능
    - while 반복문 사용 : 조건에 따른 반복 실행을 위해 구성(세부 내용 아래 코드 확인)
```java
public void playGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    List<Integer> computerNumbers = generateRandomNumbers();    
    scanner = new Scanner(System.in);
    // 반복적 프로그램 실행을 위한
    while (true) {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();  // 숫자 입력
        List<Integer> userNumbers = convertInputToNumbers(userInput);

        int strikes = 0;
        int balls = 0;

        // compare userNumber
        for (int i = 0; i < DIGIT_COUNT; i++) {
            // 같은 숫자, 같은 자리일 경우
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
            strikes++;
            }
            // 같은 숫자 존재, 자리가 다를 경우    
            else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }
        // strike, ball 출력 조건(단, strike와 ball이 0인경우 다른 방식으로 설정)
        if (strikes > 0 || balls > 0){
            // 3strike이 경우, "3스트라이크" 출력 및 재실행/종료 여부 결정
            if (strikes == 3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int checkRestart = Integer.parseInt(scanner.nextLine());
                // 재실행 및 종료 여부 확인(1: 재실행, 2: 종료)
                if (checkRestart == 1) {
                    computerNumbers = generateRandomNumbers();
                }
                else{
                    break;     // end game
                }
            }
            // stike, ball 기본 출력 방식
            else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
            }
        }
        // strike, ball이 0인 경우, "낫싱" 출력
        else{
            System.out.println("낫싱");
        }

    }
}
```

--- 

## 프로그래밍 요구 사항
### 라이브러리 적용
- Randoms 및 Console 적용
  - Randoms API를 통하여, 3자리의 Random한 숫자를 찾아낸다.
```java
import camp.nextstep.edu.missionutils.Randoms;
```
  - Console API를 통하여, Scanner를 통한 문자열 및 숫자 입력
```java
import java.util.Scanner;
```
---
## test 결과
- ApplicationTest 실행 결과
![img_2.png](img_2.png)
  - 2개의 test 통과 확인!
  - OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended 오류(warning)
    - JDK 1.8 이후 추가된 클래스 로딩 시 Class Data Sharing(CDS)라는 기능 사용 시 발생
    - 경고(Warning)이므로 Application에는 직접적인 영향을 주지는 않는다!
