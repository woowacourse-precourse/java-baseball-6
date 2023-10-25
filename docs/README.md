# ⚾&nbsp;&nbsp;Precourse-Week1 Mission **[숫자 야구]**

## 💌&nbsp;&nbsp;목차

- [📦&nbsp;&nbsp;패키지 구조](#패키지-구조)
- [✨&nbsp;&nbsp;기능 구현 목록](#기능-구현-목록)
- [🎨&nbsp;&nbsp;구현 간 고민했던 내용들](#구현-간-고민했던-내용들)

---

## 📦&nbsp;&nbsp;패키지 구조

<div align="center">
<table>
    <tr>
        <th align="center">Package</th>
        <th align="center">Class</th>
        <th align="center">Description</th>
    </tr>
    <tr>
        <td><b>🕹&nbsp;&nbsp;controller</b></td>
        <td><b>Game</b></td>
        <td>게임 로직을 메인으로 동작하는 컨트롤러 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>💻&nbsp;&nbsp;domain</b></td>
        <td><b>Number</b></td>
        <td>사용자에게 입력받는 숫자와, 컴퓨터가 생성하는 숫자 클래스
        </td>
    </tr>
    <tr>
        <td><b>Result</b></td>
        <td>Ball Count와 Strike Count에 대한 결과 클래스</td>
    </tr>
    <tr>
        <td><b>&nbsp;&nbsp;&nbsp;&nbsp;↘️&nbsp;&nbsp;/ constants</b></td>
        <td><b>ResultType</b></td>
        <td>각 결과에 따라 다른 출력 방법에 대해 정의된 Enum</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td><b>📃&nbsp;&nbsp;global</b></td>
        <td><b>GameConfig</b></td>
        <td>전역으로 작용하는 설정과 제약조건에 대한 Enum</td>
    </tr>
    <tr>
        <td rowspan="2"><b>&nbsp;&nbsp;&nbsp;&nbsp;↘️&nbsp;&nbsp;/ exception</b></td>
        <td><b>BaseballException</b></td>
        <td>전역으로 처리하는 예외상황에 대한 Exception 클래스<br/></td>
    </tr>
    <tr>
        <td><b>ErrorMessage</b></td>
        <td>각 예외 상황에서 전역으로 던져질 예외의 메세지 Enum</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td><b>✅&nbsp;&nbsp;validator</b></td>
        <td><b>InputValidator</b></td>
        <td>사용자가 입력하는 숫자에 대한 제약조건 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>💬&nbsp;&nbsp;view</b></td>
        <td><b>InputView</b></td>
        <td>사용자 요청을 처리하는 클래스</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>사용자에게 응답을 출력하는 클래스</td>
    </tr>
    <tr>
        <td><b>&nbsp;&nbsp;&nbsp;&nbsp;↘️&nbsp;&nbsp;/ constants</b></td>
        <td><b>StaticNotice</b></td>
        <td>사용자에게 응답할 정적 메세지를 담은 열거형 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td colspan="3" align="center"><b>Package Structure Overview</b></td>
    </tr>
    <tr>
        <td colspan="3"><img src="https://github.com/woowacourse-precourse/java-baseball-6/assets/112257466/f37d479a-d211-4c79-93cf-c0a4be1a7443" width="99%"></td>
    </tr>

</table>
</div>

---

## ✨&nbsp;&nbsp;기능 구현 목록

✅ `a ~ b` 사이의 서로 값이 다른 `n자리`의 정수를 랜덤으로 생성한다.

    ▪️  Default Setting : `1 ~ 9`사이의 서로 값이 다른 `3자리`의 정수

✅&nbsp;&nbsp;게임 시작 문구 출력<br/>
✅&nbsp;&nbsp;사용자에게 `a ~ b 사이의 서로 값이 다른 n자리의 정수`를 입력 받는다.

    ▪️  입력받은 input이 비어있을 경우 예외처리<br/>
    ▪️  입력받은 input이 숫자가 아닌 문자가 포함될 경우 예외처리
    ▪️  입력받은 input에 중복된 숫자가 있을 경우 예외처리

✅&nbsp;&nbsp;사용자 input 숫자와 랜덤 생성 정수의 자리수를 비교해 출력할 힌트를 계산한다.

    ▪️  숫자의 값은 같지만 자리수가 다른 경우의 수 n개 : `n볼`
    ▪️  숫자의 값과 자리수가 모두 같은 경우의 수 m개 : `n스트라이크`

✅&nbsp;&nbsp;계산된 힌트를 아래 양식으로 출력한다

    ▪️ 볼 n개, 스트라이크 0개가 존재할 때 : `n볼`
    ▪️ 볼 0개, 스트라이크 n개가 존재할 때 : `n스트라이크`
    ▪️ 볼 n개, 스트라이크 m개가 존재할 때 : `n볼 m스트라이크`
    ▪️ 볼 0개, 스트라이크 0개가 존재할 때 : `낫싱`

✅ 게임 클리어 여부 판단

    ▪️ n스트라이크가 아니라면`, 다시 사용자에게 입력을 숫자를 받고, 힌트를 출력한다.
    ▪️ n스트라이크를 맞추었다면`, 아래 메세지를 출력하고 사용자에게 플래그를 입력받는다.
    ▪️ n개의 숫자를 모두 맞히셨습니다! 게임 종료`
    ▪️ 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
      ▪️  입력받은 input이 1과 2가 아닌 숫자일 경우 예외처리 
      ▪️  입력값에 따라 게임을 재시작하거나 종료한다.

--------------------------------------------------------

## 🎨&nbsp;&nbsp;구현 간 고민했던 내용들

### 1️⃣&nbsp;&nbsp;&nbsp;확장에는 열려있고, 변경에는 닫혀있는 OCP 설계

- input 숫자의 범위가 변하더라도(1~9), 자리수가 변하더라도 대응이 손쉽게 가능해야 한다.</br>
  `GameConfig` 파일에서 `NUMBER_LENGTH` 변수의 value를 변경해 손쉽게 변경이 가능하다.<br/>
  개발 요구사항에서 자릿수 요청까지 처리하는 문제였다면, 더욱 OCP를 준수하는 코드 작성이 가능했을 것 같다.

    <div align="center">

<table>
    <tr>
        <th align="center">숫자 3자리</th>
        <th align="center">숫자 4자리</th>
        <th align="center">숫자 5자리</th>
    </tr>
    <tr>
        <td align="center"><img src="https://github.com/woowacourse-precourse/java-baseball-6/assets/112257466/0b5b10f6-357f-4274-9b42-ea68d18edf85" height="50%"/></td>
        <td align="center"><img src="https://github.com/woowacourse-precourse/java-baseball-6/assets/112257466/33d19627-775a-4d56-b2c1-88c186a95336" height="50%"/></td>
        <td align="center"><img src="https://github.com/woowacourse-precourse/java-baseball-6/assets/112257466/e41b3fc0-2d6f-4f6c-abe4-f765abcb7aad" height="50%"/></td>
    </tr>
</table>


--------------------------------------------------------

### 2️⃣ 4번의 대규모 리팩토링, 그리고 얻어낸 값진 `Number`

- 영감을 얻게 해줬던 한 마디
  ```bash
  객체는 '자율적인 존재'라는 점을 명심하라.
  < 중략 >
  객체는 스스로의 행동에 의해서만 상태가 변경되는 것을 보장함으로써 객체의 자율성을 보장한다.
  
  - 객체지향의 사실과 오해 中
  ```

- First-class collection + Static Factory Method 활용
    ```java
  public class Number {
        private final List<Integer> numbers;
      
        // Player Input Number Constructor
        private Number(String input) {
            validateEmpty(input);
            validateNumberLength(input);   
            validateContainOnlyNumber(input);
            validateContainDuplicatedNumber(input);
    
            this.numbers = convertInputNumber(input);
        }
            
        // Computer Generated Number Constructor
        private Number(List<Integer> computerNumber) {
            this.numbers = computerNumber;
        }
    }
    ```

- 일급 컬렉션과 생성자 검증을 사용해 `numbers`에 유효하게 검증이 끝난 숫자만 들어오도록 설계
- playerNumber와, computerNumber의 생성자는 서로 다른 파라미터를 지니기 때문에, 개발자가 사용 간 혼동 가능<br/>
  해당 문제를 해결하기 위해, 생성자를 `private`으로 제한하고, 의미있는 메소드로만 생성자를 호출하도록 설계

  ```java
    // Computer Generated Number Constructor
    public static Number generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_LENGTH.getValue()) {
            int number = pickNumberInRange(RANDOM_NUMBER_MINIMUM.getValue(), RANDOM_NUMBER_MAXIMUM.getValue());
            if (!hasDuplicatedNumber(randomNumbers, number)) {
                randomNumbers.add(number);
            }
        }
        return new Number(randomNumbers);
    }
          
    // Player Number Static Factory Method
    public static Number inputPlayerNumbers() {
        String playerNumbers = InputView.askPlayerNumbers();
        return new Number(playerNumbers);
    }
  ```
- 정적 팩토리 메소드 명에 의미를 부여하고, 개발자가 직관적으로 해석할 수 있도록 했고,<br/>
  일급 컬렉션을 활용해 검증이 끝난 유효한 값만 리스트에 담을 수 있게 되었다!
