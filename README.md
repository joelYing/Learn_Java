# Learn_Java
Java学习

## 18-12-5

JDK是Java开发所需要的环境，就跟我们想玩某个网游一样，玩之前一定是需要先安装相应的程序包的，那这个JDK就是我们准备登陆Java大陆前需要安装的一个程序包  
* javac -- 编译器，将源程序转换成字节码
* java  -- 运行编译后的.class文件

IDE是集成开发环境，一般集成开发环境都会带有JDK，可以使用自带的JDK也可以使用我们下载的JDK，不同的IDE配置不同。Java常用的IDE有Eclipse、MyEclipse、IntelliJ IDEA。IDE具备代码分析、补全、变异、调试等常用功能，可以大大的提高开发人员的编程效率  

JVM -- java虚拟机  

JRE -- java运行时环境包括JVM、JAVA核心类库和支持文件，若要运行java环境，下载安装JRE即可；若要开发就得使用JDK，JDK包含JRE  

### java命令行运行

命令行运行需要添加jdk下的bin目录路径到系统环境变量  

```
javac HelloWorld.java             # 生成.class文件 
java HelloWorld                   # 执行程序

```

### 构造方法

构造方法与类名相同，且没有返回值 


### 封装

```
        以 private 修饰的成员只能在本类中访问，外部需要调用get、set 方法才可访问修改

        (1)隐藏实现细节，提供公共的访问方式
	(2)好处：
		A:隐藏实现细节，提供公共的访问方式
		B:提高了代码的复用性
		C:提高了代码的安全性
	(3)使用原则
		A:把成员变量隐藏
		B:给出该成员变量对应的公共访问方式

```


