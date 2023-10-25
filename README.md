# Курсовой проект «Сервис перевода денег»
## Описание проекта
REST-сервис. Сервис предоставляет интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации.
## Запуск приложения
* Запуск производится с помощь Docker Compose
> docker-compose up -d

* Приложение работает на порту 5500  
> http://localhost:5500/

 ## Пример запросов

* Пример POST запроса на инициализацию трансфера денежных средств
> Request URL: http://localhost:5500/transfer  
  Accept: application/json, text/plain  
  Content-Type: application/json;charset=UTF-8  
  Request Payload :  
{  
&ensp; "cardFromNumber": "1111111111111111",    
&ensp; "cardFromCVV": "123",  
&ensp; "cardFromValidTill": "12/24",
&ensp; "cardToNumber": "1111111111111112",
&ensp; "amount": {  
&emsp; "currency": "RUB",  
&emsp; "value": 100000  
&ensp; }  
}  
Response:  
> {  
> &emsp; "operationId":"1"  
> }

* Пример POST запроса на подтверждение трансфера денежных средств
> Request URL: http://localhost:5500/confirmOperation  
Accept: application/json, text/plain  
Content-Type: application/json;charset=UTF-8  
Request Payload :  
{  
&emsp; "code": "0000",  
&emsp; "operationId": "1"  
}  
Response:  
> {  
> &emsp; "operationId":"1"  
> }
