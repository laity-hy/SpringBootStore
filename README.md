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

插入数据时产生未知的异常InsertException，不需要再重复的去创建

### 4.2 接口与抽象方法

1.创建一个IAddressService接口，在其中定义业务的抽象方法。

```java
/**
 *收货地址业务层接口
 */
public interface IAddressService {
    void addNewAddress(Integer ui, String username, Address address);
}

```

2.创建一个AddressServiceImpl实现类

```java
/**
 * 新增地址的实现类
 */
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //调用收货地址统计的方法
        Integer count = addressMapper.countByUid(uid);
        if (count >= maxCount) {
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        //uid,idDefault
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;//1表示默认，0表示不默认
        address.setIsDefault(isDefault);
        //补全4项日志
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        //插入收货地址的方法
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入用户的收货地址产生未知异常");
        }
    }
}
```

在配置文件中定义数据。

```yaml
# Spring读取配置文件中数据
user.address.max-count: 20
```

在实现类中显示业务控制

3.测试业务层功能是否正常。AddressServiceTests测试类来测试业务功能。

```
    @Test
    public void insert() {
        Address address = new Address();
        address.setPhone("123456789");
        address.setName("男朋友");
        addressService.addNewAddress(12, "管理员", address);   
```

## 5新增收货地址-控制器

### 5.1 处理异常

业务层抛出了业务层收货地址总数超标的异常，在BaseController中进行处理

```
else if (e instanceof AddressCountLimitException) {
           result.setState(4003);
           result.setMessage("用户的收货地址超出上线的异常");
       }
```

### 5.2 设计请求

```
/addresses/add_new_address
post
Address address ,HttpSession session
JsonResult<Void>
```

### 5.3 处理请求

在控制层创建AddressController来处理用户收货地址的请求和响应

````java

@RequestMapping("/addresses")
@RestController
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
        addressService.addNewAddress(getUidFromSession(session), getUsernameFromSession(session), address);
        return new JsonResult<>(OK);
    }
}

````

先登录用户，然后访问测试。

## 新增用户地址-前端页面

```javascript

<script>
    $("#btn-add-new-address").click(function () {
    $.ajax({
        url: "/addresses/add_new_address",
        type: "post",
        data: $("#form-add-new-address").serialize(),
        dataType: "json",
        success: function (json) {
            if (json.state == 200) {
                alert("新增收货地址成功");
            } else {
                alert("新增收货地址失败");
            }
        },
        error: function (xhr) {
            alert("新增收货地址时产生未知的错误" + xhr.status);
        }
    });
});
</script>

```

## 获取省市区列表

### 1 获取省市区
