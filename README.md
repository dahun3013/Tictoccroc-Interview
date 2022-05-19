# Tictoccroc-Interview
 서버개발자 1차 면접과제

# ERD 설계
<ul>
 
## 요구사항<br>
1.각 지역에 매장을 보유하고 있다.<br>
2.매장마다 수업이 존재한다.<br>
3.각 수업은 하루에 한번 진행한다.<br>
4.예약 가능 일자는 현재일로 부터 14일 이내이며 당일과 과거로는 예약할 수 없다.<br>
5.한 수업에 참여할 수 있는 아이 수 가 제한 되어있다.<br>
6.동일인이 동일 매장, 동일 수업에 중복하여 예약을 할 수 없다.<br>

## 객체추출<br>
1.매장<br>
2.수업<br>
3.부모<br>

## 관계추출<br>
1.예약<br>
2.수업개설<br>
3.예약이력<br>

## ERD
![ERD](https://user-images.githubusercontent.com/82797327/169296031-bdde0866-b7a9-47cc-a6fd-51eafac143ce.PNG)

 ![Model](https://user-images.githubusercontent.com/82797327/169302099-340b79e9-8ef6-4227-8300-6a9c1decbebf.PNG)

 
 </ul>
 
# FlowChart

<ul>
 
 ## 예약하기
 
![lessonReservation](https://user-images.githubusercontent.com/82797327/169298717-9b2ce934-9b74-43bc-bf02-b375560123ca.PNG)

## 예약취소
![lessonCancel](https://user-images.githubusercontent.com/82797327/169298733-f4ccd183-e24e-4095-a3ae-29194e470ae1.PNG)

## 예약자 현황
![getSubscriber](https://user-images.githubusercontent.com/82797327/169298739-1ba541ed-7730-44fe-9c88-dbb325c5ed35.PNG)

## 예약 이력
![getHistory](https://user-images.githubusercontent.com/82797327/169298750-28753841-c13e-47dc-b529-f7c8f0a8c4a3.PNG)

 </ul>
 
# Swagger API Documents

![swagger](https://user-images.githubusercontent.com/82797327/169298829-23e3a2d8-140c-4e8b-a1d2-19a512c955a9.PNG)


![RESTAPI_예약이력조회 매장](https://user-images.githubusercontent.com/82797327/169298882-4c71bd94-199e-4299-bb45-a4494e91a0b4.PNG)


![RESTAPI_예약조회 매장](https://user-images.githubusercontent.com/82797327/169298942-7e4776cc-553e-46b2-9de1-97730775971f.PNG)


![RESTAPI_예약이력조회 수업](https://user-images.githubusercontent.com/82797327/169298961-32975fe9-dd4f-42d5-8840-28f63ea7e4dd.PNG)


![RESTAPI_예약조회 수업](https://user-images.githubusercontent.com/82797327/169298974-3202d43b-4bfa-4d6c-a5aa-0179f01a7659.PNG)


![RESTAPI_예약취소](https://user-images.githubusercontent.com/82797327/169299018-1e338771-49a0-4630-b6e5-19df247e2203.PNG)


![RESTAPI_예약](https://user-images.githubusercontent.com/82797327/169299040-e3e20e69-3274-4a2b-b5b3-6473ffa3a354.PNG)


![RESTAPI_Schemas](https://user-images.githubusercontent.com/82797327/169299067-037a47e4-b2e1-426b-874d-a607b73edda7.PNG)


