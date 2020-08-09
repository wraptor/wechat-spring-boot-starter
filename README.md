## wechat-spring-boot-starter

集成微信小程序接口

- jsCode转openId
- accessToken获取

## spring boot starter依赖
```xml
<dependency>
    <groupId>com.seepine</groupId>
    <artifactId>wechat-spring-boot-starter</artifactId>
    <version>1.0.1</version>
</dependency>
```

## 使用方法

### 1.配置文件

```
we-chat:
  app-id: ${your key}
  app-secret: ${your secret}
```

### 2.代码使用
注入template
```java
@Autowire
private WeChatTemplate weChatTemplate;
```
方法使用
```java
String openId = weChatTemplate.getOpenId(jsCode);
String accessToken = weChatTemplate.getAccess();
```
