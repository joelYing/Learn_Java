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

### 继承

```
    1:Override和Overload的区别?Overload能改变返回值类型吗?
	Override:重写
	Overload:重载

	方法重写：子类中出现和父类中一模一样的方法声明的现象。
	方法重载：同一个类中出现的方法名相同，参数列表不同的现象。

	Overload能改变返回值类型，因为它和返回值类型无关。

    2:this关键字和super关键字分别代表什么?以及他们各自的使用场景和作用。
	this:本类对象的引用
	super:父类存储空间的标识。(可以理解为父类对象的引用)

	使用场景：
		成员变量：
			this.变量 本类的成员变量
			super.变量 父类的成员变量
		构造方法：
			this(...) 本类的构造方法
			super(...) 父类的构造方法
		成员方法：
			this.方法名(...) 本类的成员方法
			super.方法名(...) 父类的成员方法
```

### 多态

```
        多态：同一个对象在不同时刻表现出现的不同状态。

	举例：
		A:水(水，冰，水蒸气)

		B:猫和动物。
			把右边的值赋值给左边，如果能读通过，就说明可以。
			动物 d = new 动物();
			动物 dd = new 猫();
			猫 m = new 猫();
			猫 mm = new 动物();  错误

			动物 dd = new 猫();

	代码如何体现呢?
		A:有继承关系	
		B:有方法重写	
		C:有父类引用指向子类对象
```

### 抽象

```
        抽象类的特点：
		A:抽象类和抽象方法必须用abstract关键字修饰
		B:抽象类的子类
			a:要么是抽象类
			b:要么重写抽象类中的所有抽象方法
		C:抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
		D:抽象类不能实例化
			那么如何使用抽象类的功能呢?
			按照多态的方式使用。抽象类多态。
```

### 权限修饰符

```
+ private: Java语言中对访问权限限制的最窄的修饰符，一般称之为“私有的”。被其修饰的属性以及方法只能被该类的对象访问，其子类不能访问，更不能允许跨包访问。
+ default：即不加任何访问修饰符，通常称为“默认访问权限“或者“包访问权限”。该模式下，只允许在同一个包中进行访问。
+ protected: 介于public 和 private 之间的一种访问修饰符，一般称之为“保护访问权限”。被其修饰的属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。
+ public： Java语言中访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且允许跨包访问。

```

### Tomcat 控制台打印 log 中文乱码解决办法
在 IDEA 安装文件的 bin 目录下的 idea.exe.vmoptions 和 idea64.exe.vmoptions 分别都添加 **-Dfile.encoding=UTF-8** 即可  
若是在控制台 server 中打印的中文为乱码 则要在 run -> edit configurations 中 VM options 添加 -Dfile.encoding=UTF-8

### SLF4J 冲突

```
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Program%20Files/maven/lib/maven-slf4j-provider-3.5.4.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Program%20Files/maven/repo/org/slf4j/slf4j-log4j12/1.7.23/slf4j-log4j12-1.7.23.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.MavenSimpleLoggerFactory]
```

解决途径：删除 pom.xml 中的
```
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.23</version>
        </dependency>
```
