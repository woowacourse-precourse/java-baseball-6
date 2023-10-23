# ⚾&nbsp;&nbsp;Precourse-Week1 Mission **[숫자 야구]**

## 💌&nbsp;&nbsp;목차

- [💌&nbsp;&nbsp;목차](#목차)
- [📦&nbsp;&nbsp;패키지 구조](#패키지-구조)
- [✨&nbsp;&nbsp;기능 구현 목록](#기능-구현-목록)

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
        <td><b>📃&nbsp;&nbsp;global</b></td>
        <td><b>GameConfig</b></td>
        <td>전역으로 작용하는 설정<br/>(숫자 길이 제약, 뽑을 숫자 범위) Enum</td>
    </tr>
    <tr>
        <td rowspan="2"><b>&nbsp;&nbsp;&nbsp;↘️&nbsp;&nbsp;exception</b></td>
        <td><b>BaseballException</b></td>
        <td>전역으로 처리하는 예외상황에 대한 Exception 클래스<br/></td>
    </tr>
    <tr>
        <td><b>ErrorMessage</b></td>
        <td>각 예외 상황에서 전역으로 던져질 예외의 메세지 Enum</td>
    </tr>
    <tr><td colspan="3"></td></tr>
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
        <td rowspan="2"><b>&nbsp;&nbsp;&nbsp;↘️&nbsp;&nbsp;exception</b></td>
        <td><b>ResultType</b></td>
        <td>볼, 스트라이크, 볼&스트라이크 상황에 대한 <br/>출력 방법이 정의된 열거형 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td><b>✅&nbsp;&nbsp;validator</b></td>
        <td><b>NumberValidator</b></td>
        <td>사용자가 입력하는 숫자에 대한 제약조건 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>💬&nbsp;&nbsp;view</b></td>
        <td><b>InputView</b></td>
        <td>사용자 요청을 받기 위한 Input View 클래스</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>사용자에게 다양한 응답을 출력하기 위한 Output View 클래스</td>
    </tr>
    <tr>
        <td><b>&nbsp;&nbsp;&nbsp;↘️&nbsp;&nbsp;constants</b></td>
        <td><b>StaticNotice</b></td>
        <td>사용자에게 응답할 정적 메세지를 담은 열거형 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td colspan="3" align="center"><b>Image</b></td>
    </tr>
    <tr>
        <td colspan="3"><img src="https://github.com/woowacourse-precourse/java-baseball-6/assets/112257466/9cf30277-2b69-4781-a80e-dfa9325598d7" width="99%"></td>
    </tr>

</table>
</div>

---

## ✨&nbsp;&nbsp;기능 구현 목록

- ✅ `a ~ b` 사이의 서로 값이 다른 `n자리`의 정수를 랜덤으로 생성한다.
    - Default Setting : `1 ~ 9`사이의 서로 값이 다른 `3자리`의 정수
- ✅ 게임 시작 문구 출력
- ✅ 사용자에게 `a ~ b 사이의 서로 값이 다른 n자리의 정수`를 입력 받는다.
    - 입력받은 input이 비어있을 경우 예외처리
    - 입력받은 input이 숫자가 아닌 문자가 포함될 경우 예외처리
    - 입력받은 input에 중복된 숫자가 있을 경우 예외처리
- ✅ 사용자 input 숫자와 랜덤 생성 정수의 자리수를 비교해 출력할 힌트를 계산한다.
    - 숫자의 값은 같지만 자리수가 다른 경우의 수 n개 : `n볼`
    - 숫자의 값과 자리수가 모두 같은 경우의 수 m개 : `n스트라이크`
- ✅계산된 힌트를 아래 양식으로 출력한다
    - 볼 n개, 스트라이크 0개가 존재할 때 : `n볼`
    - 볼 0개, 스트라이크 n개가 존재할 때 : `n스트라이크`
    - 볼 n개, 스트라이크 m개가 존재할 때 : `n볼 m스트라이크`
    - 볼 0개, 스트라이크 0개가 존재할 때 : `낫싱`

- ✅ 게임 클리어 여부 판단
    - `n스트라이크가 아니라면`, 다시 사용자에게 입력을 숫자를 받고, 힌트를 출력한다.
    - `n스트라이크를 맞추었다면`, 아래 메세지를 출력하고 사용자에게 플래그를 입력받는다.
        - `n개의 숫자를 모두 맞히셨습니다! 게임 종료`
        - `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
            - 입력받은 input이 1과 2가 아닌 숫자일 경우 예외처리
            - 입력값에 따라 게임을 재시작하거나 종료한다.
