Gateway Bootcamp
================

## 依赖

* nacos 可参考 [Nacos Docker](https://nacos.io/en-us/docs/quick-start-docker.html)


## 说明

![gateway-bootcamp](docs/gateway-bootcamp.png)

* sp-api 后台服务 
* sp-auth 认证服务，提供token验证
* sp-gateway API网关，通过token换取用户ID，并透传给后台服务