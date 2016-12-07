# 程序员计算器计算内核

## 项目简介

这是安卓应用 `程序员计算器` 的计算内核源代码，应用`程序员计算器`
你可以在 [这里](http://app.mi.com/details?id=com.example.calculatorforprogrammer) 找到。

代码提供了`long`、`int`、`short`、`byte`、`real number（实数）`、`double`、`float`
七种数据类型的进制转换、基础算术运算和部分数据类型的逻辑运算操作。并且支持在七种数据类型之间转换。

详细API目录参见：[CFP_Kernel_Document](http://yuanxiaokun.xyz/cfp_kernel_doc/)。

## 类型简介

- `CFPNumber` 类

主数据类，可自由切换数据的数据类型，并提供不同的操作。

- `CFPLong`、`CFPInteger`、`CFPShort`、`CFPByte` 类

整型数据类，提供进制转换、基础运算、逻辑运算操作。

- `CFPRealNumber` 类

实数数据类，提供进制转换、基础运算操作。

- `CFPDouble`、`CFPFloat` 类

浮点型数据类，提供进制转换、基础运算操作。

## 提供的操作

### 进制转换

提供`十六进制`、`十进制`、`八进制`、`二进制`四种进制转换操作。

### 基本算术运算

提供`加法`、`减法`、`乘法`、`除法`、`相反数`五种基本算数运算。

### 逻辑运算

提供`取模（mod）`、`或（or）`、`异或（xor）`、`与（and）`、`非（not）`
、`循环左移（RoL）`、`循环右移（RoR）`、`左移（Lsh）`、`右移（Rsh）`
九种逻辑运算操作。

## 相关说明

### 进制转换

#### 十六进制
根据数据类型的不同转换形式有所不同，区别如下：

`Long`、`Integer`、`Short`、`Byte`类型返回其补码的十六进制形式；

`RealNumber` 类型返回自然的十六进制形式；

eg：`-1342.598`转换为`-53E.9916872B020C49BA5E35……`；

`Double` `Float`类型返回Double、Float类`public static String toHexString(double d)`函数结果。

#### 八进制
根据数据类型的不同转换形式有所不同，区别如下：

`Long`、`Integer`、`Short`、`Byte`类型返回其补码的八进制形式；

`RealNumber` 类型返回自然的八进制形式；

eg：`-1342.598`转换为`-2476.46213207126010142233……`；

`Double` `Float`类型返回其IEEE754标准的八进制形式。


#### 二进制
根据数据类型的不同转换形式有所不同，区别如下：

`Long`、`Integer`、`Short`、`Byte`类型返回其补码的二进制形式；

`RealNumber` 类型返回自然的二进制形式；

eg：`-1342.598`转换为`-10100111110.10011001000101101……`；

`Double` `Float`类型返回Double、Float类`public static long doubleToLongBits(double value)`、 
`public static int floatToIntBits(float value)`函数结果。

### 异常处理

- 对于 `div（除法）`、`mod（取模）` 操作，如果除数为零，则会抛出 `CFPDivZeroException` 异常。 
- 对于 `CFPNumber` 对象数据类型设置为非整数类型，且试图执行不支持的逻辑运算操作时，
将抛出 `CFPNonsupportedOperation` 异常。

### 其他说明

- 对于数据类型转换过程的溢出，将直接按溢出后的结果转换。
- 当两个 `CFPNumber` 类对象进行基本算术运算或者逻辑运算时，如果两个对象数据类型不同，
则会将被作为传入参数的对象的数据类型强制转换为调用者的类型。eg：a.add(b)，如果a、b类型不同，
则会将b的类型强制转换为a的类型参与运算。

## 更新日志

### 0.9.6beta

1. 解除对 `Java 8 API` 的依赖。

### 0.9.5beta

1. 所有数据类实现 `Cloneable` 接口。
2. 所有数据类添加 `toStringa()` 方法，返回数的十进制字符串。
3. `CFPNumber` 类增加参数为 `int`、`float` 的构造函数。
4. `CFPNumber` 类 `compareTo()` 函数增加在比较前的强制类型转换。

### 0.9.4beta

1. `CFPNumber` 类增加 `public CFPDataType getDataType()` 函数。
2. `CFPBaseOperation` 接口增加 `int compareTo(T a)` 函数，相关类已全部实现该操作。
3. 增加 `CFPNonsupportedOperation` 异常，当对于 `CFPNumber` 
对象数据类型设置为非整数类型，且试图执行不支持的逻辑运算操作时，抛出此异常。
4. `CFPNumber` 类做双目运算时加入数据类型转换。

### 0.9.3beta

1. `CFPNumber` 类增加 `public CFPNumber setNumber(String s)` 、 
`public CFPNumber setDataType(CFPDataType dataType)`
方法。

### 0.9.2beta

1. `CFPNumbwe` 类增加 `public CFPNumber setNumber(String s)` 方法。

### 0.9.1beta

1. 添加 `CFPDivZeroException` 异常，当执行 `div`、`mod` 运算除数为零时抛出此异常。
2. 更改 `CFPNumber` 类数据类型转换返回值，更改后返回 `CFPNumber` 对象。
