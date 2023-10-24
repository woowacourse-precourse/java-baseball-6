<p align="center">
    <img src="./BullsandCows.png" alt="숫자야구이미지" width="500px">
</p>

# 1주차 미션 - 숫자 야구
> 1주차 미션 숫자 야구를 구현한 저장소입니다.

<div style="text-align:center;">
    <img src="./Application.gif" alt="기능실행이미지" width="700px" style="border: 1px solid #000;">
</div>

## 목차
 - [실행하기](#실행하기)
 - [기능](#기능)
	- [게임 시작](#게임-시작)
	- [맞추기](#맞추기)
	- [반복](#반복)

<br>

## 실행하기
현재 Repository를 Clone한 후 Eclipse(혹은 그 외 IDE)를 통해 실행합니다.
```git
git clone -b ilot12 https://github.com/ilot12/java-baseball-6.git
```
<br>

## 기능

### 게임 시작
- 최초 시작시에 `숫자 야구 게임을 시작합니다.`가 출력됩니다.
- 게임을 시작하면(재시작 할 때마다) 1 ~ 9까지의 서로 다른 숫자로 이루어진 세자리 수가 생성됩니다.

### 맞추기
- `숫자를 입력해주세요 : `가 출력됩니다.
- 세자리 수를 입력합니다.
	- 세자리가 아닌 입력을 하면 `IllegalArgumentException`가 발생한 후 종료됩니다.
	<div style="text-align:center;">
		<img src="./Exception_short.gif" alt="세자리 아닌 수 입력 예외" width="700px" style="border: 1px solid #000;">
	</div>
	<br>
	
	- 0을 입력하거나 숫자가 아닌 입력을 해도 `IllegalArgumentException`가 발생한 후 종료됩니다.
	<div style="text-align:center;">
		<img src="./Exception_input0.gif" alt="0 입력 예외" width="700px" style="border: 1px solid #000;">
	</div>
	<div style="text-align:center;">
		<img src="./Exception_input_ohter.gif" alt="숫자 아닌 입력 예외" width="700px" style="border: 1px solid #000;">
	</div>
	<br>

	- 올바른 입력을 받을 시 규칙에 따라 `n볼 m스트라이크` 혹은 맞는 게 없다면 `낫싱`과 같이 출력됩니다.
	
	
### 반복
- 세자리 수를 모두 맞추고 나면 `3스트라이크`가 출력되고 이후 
```
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```
가 출력됩니다.
- 이후 1을 입력하면 `게임 시작`부터 다시 반복하고 2를 입력하면 종료합니다.
