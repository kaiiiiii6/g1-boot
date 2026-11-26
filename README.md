# g1-boot

毕业设计[智汇]的后端骨架，S1阶段用于练习Spring Boot 分层、统一响应与全局异常处理。

## 环境

- JDK 21 (Alibaba Dragonwell 21.0.11)
- Spring Boot 4.1.3
- Maven 3.9.14

## 启动步骤

1.用 IDEA 打开本目录，等待 Maven 依赖下载完成。
2.运行`src/main/java/com/example/demo/DemoApplication.java`，
或在本目录执行：`mvn spring-boot:run`
3.控制台出现`Started DemoApplication in ... seconds` 表示启动成功。
4.浏览器访问 `http://localhost:8080/hello` 应返回一段问候语。

## 已实现接口

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/hello` | 返回问候语，可带`?name=` |
| GET | `/hello/{name}` | 从路径段取值 |
| GET | `/greet` | 返回固定语句 |
| GET | `/boom` | 故意抛异常，验证全局异常值 |
| POST | `/echo` | 原样返回请求体 JSON |
| POST | `/hello/json` | 校验 `name` 非空，空值返回 400 |

## 说明

本仓库为学习与毕业设计过程中的练习工程，提交信息遵循 `feat:` / `docs:` 前缀。
































