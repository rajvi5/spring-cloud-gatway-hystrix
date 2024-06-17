# spring-cloud-gateway-hystrix

Includes:
	
1. Distributed tracing using Zipkin and Sleuth.  
Reference: https://www.youtube.com/watch?v=M19XC0zJUrA
https://www.youtube.com/watch?v=qXXgxZhwEuc
Zipkin url: http://localhost:9411/zipkin
Eureka url: http://localhost:8761
2. Fault Tolerance using Hystrix and Resilience 4J 
Circuit breaker implementation - cloud-gateway
Reference: https://www.youtube.com/watch?v=b6R4dElDtRc
3. Centralized logging using AOP - order-service 
Reference: https://www.youtube.com/watch?v=RVvKPP5HyaA

API-GateWay
-----------
```bash
URL : http://localhost:8989/order/bookOrder
HTTP Method : POST
```
Json Request :
```json
{
	"order":{
		"id":103,
		"name":"Mobile",
		"qty":1,
		"price":8000
		
	},
	"payment":{}
}
```
Json Response :
```json
{
    "order": {
        "id": 26,
        "name": "ear-phone",
        "qty": 5,
        "price": 4000
    },
    "amount": 4000,
    "transactionId": "9a021fa6-2061-4332-bdb7-b1358b3430c2",
    "message": "payment processing successful and order placed"
}

```
```bash
URL : http://localhost:8989/payment/103
HTTP Method : GET
```
Json Response :
```json
{
    "paymentId": 1,
    "transactionId": "d86cfeca-0b26-455e-a1a2-ac3e53707829",
    "orderId": 103,
    "paymentStatus": "SUCCESS",
    "amount":4000
}
```

```bash
URL : http://localhost:8989/order/getOrders
HTTP Method : GET
```
````
returns all orders
````
```bash
URL : http://localhost:8989/payment/getPayments
HTTP Method : GET
```
````
returns all payments
````