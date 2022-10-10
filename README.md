# SpringBootStore

第一个商城项目

## 4 增收货地址-业务层

### 4.1 规划异常

如果用户是第一次插入用户的收货地址，规则：当用户插入的地址是第一条时，需要将当前地址作为默认的收货地址，如果查询到统计总数为0则将当前地址的
is_default值设置为1.查询统计的结果为0不代表异常。查询到的结果大于20了，这时候需要抛出业务控制的异常AddressCountLimitException。

```java
/**
 * 收货地址总数超出限制的异常（20条）
 */
public class AddressCountLimitException extends ServiceException {
    // ...
}
```

### 4.2 接口与抽象方法
1.创建一个IAddressService接口，在其中定义业务的抽象方法。

2.创建一个AddressServiceImpl实现类

3.
### 4.3 实现抽象方法

## 5 新增收货地址-控制器

### 5.1 处理异常

### 5.2 处理请求





























