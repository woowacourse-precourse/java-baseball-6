# 1주차 숫자야구

## 시스템 흐름

시작 → 숫자 야구 겜임을 시작합니다. (출력) → baseballPlay(함수 실행)

→ setComputerNumber(함수 실행) →

사용자 숫자입력 → userNumber(함수 실행) → numericalComparison(함수 실행) → 결과 출력 **→**

if문이 true일때까지 반복

****if(userNumber == computerNumber)baseballPlay(함수 종료) **→**

메인으로 함수로 가 ****게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. (출력) → 사용자 번호 입력

## 구현 함수

### baseballPlay

게임을 시작하는 함수

### setComputerNumber

컴퓨터 숫자를 할당해 주는 함수

```java
public static List<Integer> setComputerNumber(){
        List<Integer> computer=new ArrayList<>();
        while(computer.size()< 3){
        int randomNumber=Randoms.pickNumberInRange(1,9);
        if(!computer.contains(randomNumber)){
        computer.add(randomNumber);
        }
        }
        return computer;
        }
```

### userNumber

사용자가 입력한 숫자를 List에 저장하는 함수

```java
public static List<Integer> userNumber(int number){
        List<Integer> user=new ArrayList<>();
        String numberStr=Integer.toString(number); // 숫자를 문자열로 변환

        for(int i=0;i<numberStr.length();i++){
        char digitChar=numberStr.charAt(i); // 문자열에서 한 자릿수를 가져옴
        int digit=Character.getNumericValue(digitChar); // 문자를 정수로 변환
        user.add(digit); // List에 추가
        }

        return digits;
        }
```

### **numericalComparison**

user와 컴퓨터를 비교해 스트라이크와 인트를 반환

```java
public static BaseballReferee numericalComparison(List<Integer> computerNum,List<Integer> userNum){

        }
```

## Model

### B**aseballReferee**

private int strike

private int ball

## 예외처리

### 3자리 수가 아닌 수가 들어왓을때

### 같은 수가 있는 숫자일 때

### 숫자에 0이 포함되어 있을 때