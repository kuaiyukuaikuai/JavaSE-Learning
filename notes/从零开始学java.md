# day04-数组

## 静态初始化

```java
public static void radomCall(){
    String[] names = {"小王","小李","小张","小赵","小钱","小孙","小1","小2","小3","小4","小5","小6","小7","小8"};
    int index = (int)(Math.random()*names.length);//Math.random()生成0-1的随机数,[0,1)  names.length是15 *是乘
    System.out.println(names[index]);
}
```

## 动态初始化

```java
//动态化初始化数组,只确定数据类型和存储数据的容量
//数据类型[] 数组名 = new 数据类型[长度];
double[] scores = new double[8];
```

## 二维数组

```java
//动态初始化数组
String[][] classroom2 = new String[3][];
```

## 创建键盘输入

```java
Scanner scanner = new Scanner(System.in);//创建一个扫描器对象,用来获取键盘输入
scores[i] = scanner.nextDouble();//nextDouble()方法获取键盘输入
```

# day05-面向对象编程入门

## 构造器

```java
//构造器: 创建对象时调用,无返回值,构造器的名称与类名相同
//类自带一个无参数构造器,如果写了有参数构造器,则无参数构造器将不再存在
//1.无参数构造器
public Student(){

}
//2.有参数构造器
public Student(String name,int age){
    this.name = name;
    this.age = age;
}
```

## this

```java
// this是一个变量，指向当前对象
//哪个对象调用这个方法,this就拿到哪个对象
public void printHobby(String name){
    System.out.println(this.name + "爱好是"+name);
}
```

## 封装

```java
//1.使用private修饰符(私有,隐藏)修饰成员变量,只能在本类中被直接访问
private int age;
//2.提供public方法,合理暴露,对成员变量进行操作
//成员变量的取值和赋值
public void setAge(int age){
    this.age = age;
    if(age < 0 || age > 120){
        System.out.println("年龄不合法");
        this.age = 0;
    }
}
public int getAge(){
    return age;
}
```

## 实体类(特殊类)javabean

- 要求1:类中成员变量全部私有,并且提供public修饰的getter/setter方法
- 要求2:类中==必须==提供一个无参数构造器,有参构造器可选
- 应用场景:实体类只负责数据存储,对数据的业务操作交个其他类的对象来完成,以实现数据和数据业务处理相分离

## static

- 静态变量(类变量):有static修饰,属于类,被类的全部对象共享
  - 访问方式:==类名.静态变量(推荐)==/对象.静态变量(不推荐)
  - 在类中访问可不加**类名.**直接访问
- 实例变量(对象的变量):无static修饰,属于每个对象
- 静态方法同理可得,应用在==工具类==中，静态方法不用创建对象，直接==类名.方法==,工具类没有创建对象的需求,建议将构造器进行私有
- 1. 静态方法可以直接访问静态成员,不可直接诶访问实例成员
  2. 实例方法可直接访问静态成员,也可访问实例成员
  3. 实例方法可以使用this关键字,静态不可以

# day06-继承

![image-20250920135825118](./从零开始学java.assets/image-20250920135825118.png)

## extends

- 子类继承父类的非私有成员(成员变量,成员方法)

- 子类的对象是由子类,父类共同完成的

- 继承

  - java的类只能单继承,不支持多继承,支持多层继承

  - 一个类默认继承Object,或者间接继承

  - 继承后子类访问特点:就近原则

  - ```java
    class Fu{
        String name="父类的name";
    }
    class Zi extends Fu{
        String name="子类的name";
        public void show()
        {
            String name="show的name";
            System.out.println(name);//输出show的name
            System.out.println(this.name);//输出子类的name
            System.out.println(super.name);//输出父类的name
        }
    ```

## 权限修饰符

- 用于限制类中成员(成员变量,成员方法,构造器)能被访问的范围
  - private:只能本类
  - 缺省:本类,同一包中的类
  - protected:本类,同一包中的类,子孙类
  - public:任意位置

## 方法重写

```java
public class Animal {
    public void eat()
    {
        System.out.println("吃东西");
    }
}

class Cat extends Animal{
    @Override//方法重写的校验注解(标志)
    public void eat() {
        System.out.println("喵喵喵的吃");
    }
}
```

- @Override//方法重写的校验注解(标志)
- 子类重写父类方法时,访问权限范围==必须==＞＝父类该方法的权限范围
- 重写方法返回值类型,==必须==＜＝被重写返回值类型
- 私有,静态方法不能重写
- **重写规范:声明不变,重新实现**

## 子类的构造器

- 子类构造器必须先调用父类构造器,再执行自己的构造器
- 子类构造器代码第一行默认Super(),会调用父类无参构造器,若父类没有无参构造器,需自行在子类构造器中第一行写入super(...)调用父类的有参构造器
- this调用兄弟构造器
- super(...),this(...)必须写在构造器的第一行,并且两者不能同时出现

##  多态

- ```java
  //对象多态,行为多态
  Animal animal1=new Tortoise();
  animal1.run();//方法:编译看左边,运行看右边
  System.out.println(animal1.name);//成员变量:编译看左边,运行也看左边
  Animal animal2=new Wolf();
  animal2.run();
  System.out.println(animal2.name);
  }
  ```

- ![image-20250921103718589](./从零开始学java.assets/image-20250921103718589.png)运行结果(成员变量无多态性)

- 前提:有==继承/实现==关系,存在父类引用子类对象,==存在方法重写==

- 好处:右边对象是解耦合的

- ```java
  public static void go(Animal animal){
      animal.run();
  }
  ```

- ```java
  //多态调用不了子类独有功能,因为编译看左边,父类中没有该函数
  animal1.eatSheep();
  //强制转化后即可调用
  Wolf wolf1 = (Wolf) animal1;
  wolf1.eatSheep();
  ```

- **instanceof**判断对象真实类型   animal1 instanceof Wolf 正确返回1

# day07-面向对象编程高级

## final(最终的意思)

- 修饰类:最终类,不能被继承

- 修饰方法:最终方法,不能被重写

- 修饰变量:该变量有且仅能被赋值一次  

- ```java
  public class FinalDemo1 {
      // 目标:认识final关键字的作用
      //3. final修饰变量
      //变量包括:
      // a.静态变量，实例变量
      // b.局部变量
      public static final String STUDENT_NAME="张子儒";//静态变量(常量),命名规范:大写英文单词,中间用下划线连接
  
      private final int c= 20;//实例变量(一般不用)
      public static void main(String[] args) {
          final int a = 10;//局部变量
          //a = 20;
      }
  }
  
  //1. final修饰类
  final class A {
  }
  
  //2. final修饰方法
  class B {
      final void show() {
          System.out.println("show()");
      }
  }
  
  class C extends B {
      //    @Override
      //    void show(){
      //        final int a = 10;
      //        //a = 20;
      //    }
  }
  ```

- final修饰基本类型变量,变量存储的数据不能改变

- final修饰引用类型的变量,变量存储的地址不能被改变,但地址所指向对象的内容可以被改变

- ```java
  final int d = 10;
  //d = 20;第二次赋值报错
  
  final int[] arr={1,2,3};
  //arr = new int[]{1,2,3};第二次赋值报错
  arr[0] = 20;//指向的内容可以修改
  ```

## 单例类(设计模式)

```java
//饿汉式单例(拿对象时,对象已经创建)
public class A {
    //1.私有化构造器
    private A(){}
    //2.创建静态变量
    private static A a = new A();
    //3.创建静态方法
    public static A getInstance(){
        return a;
    }
}

//懒汉式单例
public class B {
    //1、私有化构造方法
    private B(){}
    //2、创建静态变量
    private static B b = null;
    //3、创建静态方法
    public static B getInstance(){
        if(b == null){
            b = new B();
        }
        return b;
    }
}
```

## 枚举类(用于信息分类和标志)

- 枚举类为最终类,不可被继承,继承java.lang.Enum类的
- ==枚举类的第一行,只能罗列枚举对象的名称,这些名称本质是常量==
- 构造器私有,因此不能创建对象

```java
public static void move2(Direction direction) {
    switch (direction) {
        case Up:
            System.out.println("向上");
            break;
        case Down:
            System.out.println("向下");
            break;
        case Left:
            System.out.println("向左");
            break;
        case Right:
            System.out.println("向右");
            break;
    }
}
```

```java
public enum Direction {
    Up, Down, Left, Right
}
```

## 抽象类 abstract

- abstract修饰类/方法,称为抽象类/方法
- 类有的成员:成员变量,方法,构造器,抽象类都可以有
- 抽象类中不一定有抽象方法,==**有抽象方法的类必须是抽象类**==
- 抽象类==**不能创建对象**==,仅作为一种特殊父类,让子类继承实现
- 一个类继承抽象类,必须重写全部抽象方法,否则该类也必须定义为抽象类

## 模版方法设计模式

- 解决方法中重复代码
- 定义一个抽象类,在里面定义2个方法,一个是模版方法:放相同代码,一个是抽象方法:具体实现交给子类
- 模版方法用final关键字修饰,防止被更改

## 接口 interface

- 接口==**不能创建对象**==

- 接口是用来被类==**实现**==的,实现接口的类被称为==实现类==,==**一个类可以同时实现多个接口**== 

- 实现类实现多个接口,==**必须重写完全部接口的全部抽象方法**==,否则这个类必须定义成抽象类

- 可以看做特殊的抽象类

- ```java
  public class Test {
      public static void main(String[] args) {
          //接口弥补了类单继承的不足,让类拥有更多的角色,让类功能更强大
          People people1 = new Student();
          Driver driver = new Student();//多态
          BoyFriend boyFriend = new Student();
  
          //接口可以实现面向接口编程,更利于解耦合
          Driver driver1 = new Teacher();
          BoyFriend boyFriend1 = new Teacher();
      }
  }
  
  interface Driver { }
  interface BoyFriend { }
  class People{}
  class Student extends People implements Driver, BoyFriend { }
  class Teacher extends People implements Driver, BoyFriend { }
  ```

- ```java
  // 接口
  public interface A {
      //JDk 8之前,接口只能定义常量和抽象方法
      //1.常量
      public static final String NAME = "张子儒";
      String AGE = "18";//public static final可以省略不写,默认会加
  
      //2.抽象方法
      public abstract void cry();//public abstract可以省略不写,默认会加
      void run();
  }
  ```

- ```java
  class C implements A, B {
      @Override
      public void play()
      {
          System.out.println("C play");
      }
      @Override
      public void cry()
      {
          System.out.println("C cry");
      }
      @Override
      public void run()
      {
          System.out.println("C run");
      }
  }
  ```

- ```java
  //1.继承和实现关系
  //类与类:一个类继承一个类
  //类与接口:一个类实现多个接口
  //接口与接口:多继承,一个接口继承多个接口
  interface A {
      void show1();
  }
  interface B {
      void show2();
  }
  interface C extends A, B {
      void show3();
  }
  class D implements C {
      public void show1()
      {
          System.out.println("show1");
      }
      public void show2()
      {
          System.out.println("show2");
      }
      public void show3()
      {
          System.out.println("show3");
      }
  }
  
  //2.一个接口继承多个接口,如果多个接口中存在签名冲突,则此时不支持多继承,也不支持多实现(了解)
  interface A1 {
      void show();
  }
  interface B1 {
      void show();//如果为String show()则报错
  }
  interface C1 extends A1, B1 {
      void show();
  }
  class D1 implements C1 {
      public void show()
      {
          System.out.println("show");
      }
  }
  
  
  //3.一个类继承父类,又实现接口,如果父类和接口中有同名方法,实现类优先用父类
  interface A2 {
      default void show(){
          System.out.println("接口的show");
      }
  }
  class C2 {
      public void show()
      {
          System.out.println("父类的show");
      }
  }
  class People extends C2 implements A2 {
      public void go()
      {
          System.out.println("go");
          show();//父类的show
          super.show();//父类的show
          A2.super.show();//接口的show
      }
  }
  
  
  //4.一个类实现了多接口,如果多接口中存在同名的默认方法,可以不冲突,重写即可
  interface A3 {
      default void show()
      {
          System.out.println("接口A3的show");
      }
  }
  
  interface B3 {
      default void show()
      {
          System.out.println("接口B3的show");
      }
  }
  class C3 implements A3, B3 {
      @Override
      public void show()
      {
          System.out.println("C3的show");
          A3.super.show();//接口A3的show
          B3.super.show();//接口B3的show
      }
  }
  ```

## 接口和抽象类区别

- 抽象类体现模版思想,更利于做父类,实现代码复用性
- 接口更适合做功能解耦合,解耦合性更强更灵活

# day08-面向对象高级

## 代码块

- 静态代码块

  - 格式:static{}

  - 特点:类加载时自动执行,由于类只会加载一次,所以静态代码块也只会执行一次

  - 作用:完成类的初始化,例如:对静态变量的初始化赋值 

  - ```java
    public class CodeDemo1 {
        //静态代码块,有static修饰,属于类,与类一起优先加载,自动执行一次
        //基本作用: 对类的静态资源的初始化
        public static String schoolname;
        public static String[] cards =new String[54];
        static {
            System.out.println("静态代码块");
            cards[0] = "大王";
            cards[1] = "小王";
        }
        public static void main(String[] args) {
            System.out.println("main方法");
        }
    }
    ```

- 实例代码块

  - 格式:{}

  - 特点:每次创建对象时,执行实例代码块,并在构造器前执行

  - 作用:和构造器一样,用来完成对象的初始化,例如对实例变量进行初始化 

  - ```java
    public class CodeDome2 {
        //实例代码块,无static修饰,属于对象,每次创建对象,都会优先执行一次
        //基本作用:初始化对象的实例资源
        {
            System.out.println("实例代码块");
        }
        public static void main(String[] args) {
            CodeDome2 c = new CodeDome2();
            CodeDome2 c1 = new CodeDome2();
            CodeDome2 c2 = new CodeDome2();
        }
    }
    ```

## 内部类

- 成员内部类  场景:当一个类的内部,包含一个完整事务,而且这个事务没必要单独设计时,可以把这个事务设计为内部类

- ```java
  // 创建内部类对象
  //格式: 外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
  Outer.Inner inner = new Outer().new Inner("张子儒");
  //成员内部类访问外部类成员的特点
  
  //1. 成员内部类对象可以访问外部类的静态成员/方法,也可访问外部类的实例成员/方法
  inner.show();
  
  //2.成员内部类的实例对象中,可以直接拿外部类的实例成员变量
  People.Heart heart = new People().new Heart();
  heart.show();
  }
  ```

- ```java
  class People {
      private int heartBeat = 100;
  
      public class Heart{
          private int heartBeat = 90;
          public void show(){
              int  heartBeat = 80;
              System.out.println(heartBeat);//内部类局部变量
              System.out.println(this.heartBeat);//内部类成员变量
              System.out.println(People.this.heartBeat);//外部类成员变量
          }
      }
  }
  ```

## 静态内部类

- 有static修饰的内部类,属于外部类自己持有

- 可以直接访问外部类的静态成员,不能直接访问外部类的实例成员

- ```java
  public class Outer {
      public static String schoolName;
      public int  age;
      //静态内部类,属于外部类本身持有
      static class Inner {
          private String name;
          public void show()
          {
              //静态内部类可以访问外部类的静态成员变量
              System.out.println(Outer.schoolName);
              //静态内部类不可以访问外部类的实例成员变量
              //System.out.println(age);!!!报错
          }
      }
  }
  ```

- ```java
  public class InnerClassDemo1 {
      public static void main(String[] args) {
          //创建对象: 外部类名.内部类名 对象名 = new 外部类名.内部类名();
          Outer.Inner inner = new Outer.Inner();
          inner.show();
      }
  }
  ```

## 局部内部类(了解)

- 定义在方法中,代码快中,构造体等执行体中

## 匿名内部类

- 是一种特殊的局部内部类

- 所谓匿名,指的是程序员不需要为这个类声明名字,默认有个隐藏的名字

- **特点**:匿名内部类本质就是一个子类,并会立即创建出一个子类对象

- **作用**:用于方便的创建一个子类对象  

- ```java
  public static void main(String[] args) {
      //认识匿名内部类,搞清楚其基本作用
      //匿名内部类实际有名字:外部类名$编号.class
      //本质是一个子类,同时立即构建一个子类对象
      //格式: new 抽象类/接口(参数值) {类体(一般是方法重写)}
      Animal a=new Animal() {
          @Override
          public void cry() {
              System.out.println("喵喵喵");
          }
      };//名称为 Test$1.class
      a.cry();
  }
  ```
  
- ==**通常作为一个对象参数传给方法**==

- ```java
  public class Test2 {
      public static void main(String[] args) {
          //需求:学生,老师都要参加游泳比赛
          Swim s = new Swim() {
              @Override
              public void swimming() {
                  System.out.println("学生的swimming");
              }
          };
          start(s);
  
          start(new Swim() {
              @Override
              public void swimming() {
                  System.out.println("老师的swimming");
              }
          });
      }
  
      public static void start(Swim s) {
          s.swimming();
      }
  }
  
  interface Swim {
      void swimming();
  }
  ```

- **开发中的真实使用场景**

  ```java
  package com.zzrjava.innerclass3;
  import java.lang.reflect.Array;
  import java.util.Arrays;
  import java.util.Comparator;
  
  public class Test4 {
      public static void main(String[] args) {
          //目标:完成给数组排序,理解其中匿名内部类的用法
          //准备一个学生类型的数组,存放6个学生对象
          Student[] students = new Student[6];
          students[0] = new Student("小王", 18, 154, '男');
          students[1] = new Student("小张", 19, 140, '女');
          students[2] = new Student("小李", 17, 170, '男');
          students[3] = new Student("小赵", 16, 190, '女');
          students[4] = new Student("小孙", 15, 150, '男');
          students[5] = new Student("小周", 14, 140, '女');
  
          //需求:将数组中的学生对象按照年龄进行排序,可以用sun.util.Arrays中的sort方法
          //public static <T> void sort(T[] a, Comparator<T> c)
          //参数一:需要排序的数组
          //参数二:需要给sort声明一个Comparator比较器对象(指定排序的规则)
          /*        比较器（Comparator）的作用：
  自定义排序规则：当默认排序（如对象的自然顺序）不满足需求时，可以通过Comparator定义新的排序逻辑。
  灵活多排序：同一个类可以创建多个Comparator实现，支持按不同属性或规则排序（例如，学生按年龄排序、按成绩排序等）。
  控制排序方向：可以轻松实现升序或降序排列。
          Comparator接口的核心方法：
          Comparator接口中有一个必须实现的方法：
          int compare(T o1, T o2);
  参数：两个待比较的对象（o1和o2）。
  返回值：
          负整数：表示o1应排在o2之前（不交换）。
          正整数：表示o1应排在o2之后（交换）。
          零：表示两个对象相等（顺序不变）。*/
          Arrays.sort(students, new Comparator<Student>() {
              @Override
  //            public int compare(Student o1, Student o2) {
  //                if (o1.getAge() > o2.getAge())
  //                    return 1;
  //                else if (o1.getAge() < o2.getAge())
  //                    return -1;
  //                else
  //                    return 0;
  //            }
              public int compare(Student o1, Student o2) {
                  return o1.getAge() - o2.getAge();//按照年龄升序
                  //return o2.getAge() - o1.getAge();//按照年龄降序
              }
          });
  
          System.out.println("排序后:");
          for (Student student : students) {
              System.out.println(student.getName() + ":" + student.getAge());
          }
  
      }
  }
  ```

## 函数式编程

- ```java
  public static void main(String[] args) {
      //目标:认识Lambda表达式.搞清楚其基本作用
      Animal animal = new Animal() {
  
          @Override
          public void cry() {
              System.out.println("猫叫");
          }
      };
      animal.cry();
  
      //错误示范:Lambda表达式只能代替函数式接口的匿名内部类
      //        Animal animal1= ()-> {
      //                System.out.println("狗叫");
      //            }
      //        };
      //    animal1.cry();
  
      Swim s1 = new Swim() {
          @Override
          public void swimming() {
              System.out.println("狗 swimming");
          }
      };
      s1.swimming();
  
      Swim s2=()-> {
          System.out.println("猫 swimming");
      };
      s2.swimming();
  
  }
  //函数式接口,只有一个抽象方法的接口
  @FunctionalInterface//声明函数式接口
  interface Swim {
      void swimming();
  }
  ```

- JDK 8开始新增的一种语法形式,表示函数,  使用Lambda函数替代某些匿名内部类对象 

- Lambda省略:

  - 具体类型可以全部省略不写

  - 如果只有一个参数,参数类型省略同时"()"也可以省略,多个参数则不能省略"()"

  - 如果Lambda表达式只有一行代码,大括号可以不写,同时省略分号";",如果这行代码是语句,也必须去掉return

  - ```java
    Arrays.sort(students, (Student o1, Student o2) -> {
        return o1.getAge() - o2.getAge();//按照年龄升序
        //return o2.getAge() - o1.getAge();//按照年龄降序
    });
    
    Arrays.sort(students, (o1, o2) -> {
        return o1.getAge() - o2.getAge();//按照年龄升序
    });
    
    Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
    ```

  ```java
  //java要求必须给这个按钮添加一个点击事件监听器对象,这样可以监听到点击事件
  //开发中不要我们要主动写匿名内部类,而是用别人的功能的时候,别人可以让我们写一个匿名内部类,我们才会写
  btn.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("点击了登录按钮");
      }
  });
  //也可以用lambda表达式(简化版)
  btn.addActionListener(e -> System.out.println("点击了登录按钮(简化版)"));
  ```

## 方法引用

- ### 静态方法的引用

  - 类名::静态方法

  - 使用场景:某个Lambda表达式里只是调用一个静态方法,并且"->"前后的参数的形式一致,就可以使用静态方法引用

  - ```java
    Arrays.sort(students,(o1, o2) ->Student.compareByAge(o1,o2));
    Arrays.sort(students,Student::compareByAge);
    ```

- ### 实例方法的引用

  - 对象名::实例方法

  - 使用场景:某个Lambda表达式里只是调用一个实例方法,并且"->"前后的参数的形式一致,就可以使用实例方法引用

  - ```java
    Student t=new Student();
    Arrays.sort(students, (o1, o2) -> t.compareByHeight(o1,o2));
    Arrays.sort(students,t::compareByHeight);
    ```

- ### 特定类的方法引用

  - 特定类的名称::实例方法

  - 使用场景:某个Lambda表达式里只是调用一个特定类型的实例方法,并且前面参数列表中的第一个参数是作为方法的主调,后面的所有参数作为该实例方法的入参的,就可以使用特定类型的实例方法引用

  - ```java
    String[] names = {"Tom", "Jerry", "Mike", "Kate", "Jim", "angela","曹操","Lucy", "Mary","Andy"};
    Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));
    Arrays.sort(names, String::compareToIgnoreCase);
    ```

    ![image-20251005162718964](./从零开始学java.assets/image-20251005162718964.png)

- ### 构造器引用

  - 类名::new

  - 使用场景:如果某个Lambda表达式只是在创建对象,并且"->"前后参数情况一致,就可以使用构造器引用

  - ```java
    //目标:理解构造器引用
    //创建了接口的匿名内部类对象
    /*        CarFactory cf = new CarFactory() {
                @Override
                public Car getCar(String name) {
                    return new Car(name);
                }
            };*/
    //   CarFactory cf = (name) -> new Car(name);
    CarFactory cf = Car::new;
    
    
    Car c1 = cf.getCar("法拉利");
    ```

## 常用API-String

- 以"..."方式写出的字符串对象,会存储到字符串常量池,并且相同内容的字符串只存储一份
- 通过new方式创建字符串对象,每new一次都会产生一个新的对象放在堆内存中 

## 常用API-ArrayList集合

- 集合是一种容器,用来装数据的,类似于数组

- 集合大小可变(数组固定),功能丰富,开发中用的更多

- ```java
  ArrayList<String> list1 = new ArrayList<>();//只能操作字符串
   ArrayList list2 = new ArrayList();//操作所有变量
  ```

# Java高级进阶Day01

## 异常

### Java的异常体系

- Java.lang.Throwable
  - Error(系统级别错误)
  - Exception
    - RuntimeException(运行时异常 )
    - 其他异常

### 异常的基本处理

- 抛出异常(throws)

  - throws Exception抛出所有异常

- 捕获异常(try...catch)

- ```java
  public static void main(String[] args) {
      //目标:认识异常的体系,搞清楚异常的基本作用
      /*        System.out.println("show程序开始");
          show();
          System.out.println("show程序结束");*/
  
      try {
          show2();
      } catch (ParseException e) {
          e.printStackTrace();//输出异常信息
      } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      }
  
  }
  
  public static void show2() throws ParseException, FileNotFoundException {
      System.out.println("show2方法开始");
      //编译异常
      String str="2024-07-09 11:12:13";
      //把字符串时间解析成Java中的一个日期对象
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = sdf.parse(str);//编译时异常,提示程序很容易出错
      System.out.println(date);
  
      InputStream is= new FileInputStream("d:/a.txt");
      System.out.println("show2方法结束");
  }
  ```

### 异常的作用

- 用来定位程序bug的关键信息

- 可以作为方法内部的一种特殊返回值,以便通知上级调用者,方法的执行问题

- ```java
  public class ExceptionDemo2 {
      public static void main(String[] args) {
          //目标:搞清楚异常的作用
          try {
              System.out.println(div(10, 0));
              System.out.println("底层方法执行成功");
          } catch (Exception e) {
              e.printStackTrace();
              System.out.println("底层方法执行失败");
          }
          System.out.println("程序继续执行");
          System.out.println("程序结束");
      }
  
      //需求:求2个数的除的结果,并返回这个结果
      public static int div(int a, int b) throws Exception {
          if (b == 0) {
              System.out.println("除数不能为0");
              //返回一个异常给上层调用者,返回的异常还可告知上层底层是执行成功还是执行失败
              //            throw  new RuntimeException("除数不能为0");        //运行时异常,不需要处理,直接抛给调用者
  
              //替代return 直接返回一个异常,还可以让程序继续运行
              throw new Exception("除数不能为0");//抛出编译时异常,必须处理,要么try...catch,要么throws
          }
          int result = a / b;
          return result;
      }
  }
  ```

### 自定义异常

- 自定义编译异常(特点:编译阶段就报错,提示比较激进)

  - 定义一个异常类继承Exception

  - 重写构造器

  - 通过throw new 异常类(xxx)创建异常对象并抛出

  - ```java
    package com.itheima.demo1exception;
    
    public class ExceptionDemo3 {
        public static void main(String[] args) {
            //目标:认识自定义异常
            try {
                saveAge(300);
            } catch (AgeException e) {
                e.printStackTrace();
                System.out.println("保存年龄失败");
            }
        }
    
        //需求:我们公司的系统只要收到年龄小于1岁或者大于200岁就是一个年龄非法异常
        public static void saveAge(int age) throws AgeException {
            if (age < 1 || age > 200) {
                throw new AgeException("年龄非法");
            } else {
                System.out.println("保存年龄成功");
            }
        }
    }
    ```

- 自定义编译异常(特点:编译阶段不报错,运行时才可能出现)

  - 定义一个异常类继承RuntimeException

  - 重写构造器

  - 通过throw new 异常类(xxx)创建异常对象并抛出

### 异常的处理方法

- 方法1:底层异常层层往外抛,最外层捕获异常,记录下异常信息,并响应适合用户观看的信息进行提示

- ```java
  public class ExceptionDemo5 {
      public static void main(String[] args) {
          //目标:掌握异常的处理方案1:底层异常都抛出给最外层调用者,最外层捕获异常,记录异常,响应合适信息给用户观看
  
          System.out.println("show程序开始");
          try {
              show();
              System.out.println("show程序操作成功");
          } catch (Exception e) {
              e.printStackTrace();
              System.out.println("程序出现异常,请稍后再试");
          }
          System.out.println("程序继续执行");
          System.out.println("程序结束");
      }
  
      public static void show() throws Exception {
          System.out.println("show2方法开始");
          //编译异常
          String str = "2024-07-09 11:12:13";
          //把字符串时间解析成Java中的一个日期对象
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          Date date = sdf.parse(str);//编译时异常,提示程序很容易出错
          System.out.println(date);
  
          InputStream is = new FileInputStream("d:/a.txt");
          System.out.println("show2方法结束");
      }
  }
  ```

- 方法2:最外层捕获异常后,尝试重新修复 

- ```java
  public class ExceptionDemo6 {
      public static void main(String[] args) {
          //目标:掌握异常的处理方案2:捕获异常对象,尝试重新修复
          //接受用户的一个定价
  
          while (true) {
              try {
                  double price = userInputPrice();
                  System.out.println("商品定价是:"+ price);
                  break;
              } catch (Exception e) {
                  System.out.println("输入价格有误,请重新输入");
              }
          }
          System.out.println("程序结束");
      }
      public static double userInputPrice(){
          Scanner sc = new Scanner(System.in);
          System.out.println("请输入商品定价:");
          double price = sc.nextDouble();
          return price;
      }
  }
  ```

## 泛型

### 认识泛型

- 定义类、接口、方法时,**同时声明了一个或者多个类型变量(如:<E>)**称为泛型类,泛型接口,泛型方法,他们统称为泛型
- 作用:泛型提供了在编译阶段约束所能操作的数据类型,并且自动进行检查的能力,这样可以避免强制类型转换,及其可能出现的异常
- 本质:将具体的数据类型作为参数传给类型变量

### 泛型类

- ```java
  public class MyArrayList<E> {
      
  }
  ```

### 泛型接口

- ```java
  package com.itheima.demo3genericity;
  
  //自定义泛型接口
  public interface Data <T>{
      void add(T t);
      void delete(T t);
      void update(T t);
      T query(int id);
  }
  ```

### 泛型方法,通配符,上下限

- 泛型方法

- ```java
  public class GenericDemo4 {
      public static void main(String[] args) {
          //目标:学会定义泛型方法,搞清楚作用
          //需求:打印任意数组的内容
          String[] arr = {"张三", "李四", "王五"};
          printArray(arr);
          Integer[] arr1 = {10, 20, 30};//Integer是int的包装类
          printArray(arr1);
      }
      public static <T> void printArray(T[] arr){ //T是任意类型
          for (T t : arr) {
              System.out.println(t);
          }
      }
  }
  ```

- 通配符

- 就是"?",可以在"使用泛型"的时候代表一切类型,E T K V是在定义泛型的时候使用

- 上限:?extends Car:     ? 能接受的必须是Car或者其子类

- 下限:?super Car:         ? 能接受的必须是Car或者其父类

- ```java
  public class GenericDemo5 {
      public static void main(String[] args) {
          //目标:理解通配符和上下限
          ArrayList<Xiaomi> xiaomis = new ArrayList<>();
          xiaomis.add(new Xiaomi());
          xiaomis.add(new Xiaomi());
          xiaomis.add(new Xiaomi());
          go(xiaomis);
  
          ArrayList<BYD> byds = new ArrayList<>();
          byds.add(new BYD());
          byds.add(new BYD());
          byds.add(new BYD());
          go(byds);
  
          ArrayList<Dog> dogs = new ArrayList<>();
          dogs.add(new Dog());
          dogs.add(new Dog());
          dogs.add(new Dog());
          // go(dogs); //错误
      }
      //需求:开发一个极品飞车的游戏
      public static void go(ArrayList<?extends  Car> cars){//泛型通配符
          System.out.println(cars);
      }
  }
  ```

### 泛型支持的类型

- 泛型不支持基本数据类型,只能支持对象类  型(引用数据类型)

- ![image-20251011173852624](./从零开始学java.assets/image-20251011173852624.png)

- ```java
  public class GenericDemo6 {
      public static void main(String[] args) {
          //目标:泛型ii和集合不支持的基本数据类型,只能支持对象类型(引用数据类型)
          ArrayList<Integer> list = new ArrayList<>();
  
          //手工包装
          //Integer i = new Integer(10); //过时
          Integer it1 = Integer.valueOf(10);
          Integer it2 = Integer.valueOf(10);
          System.out.println(it1 == it2);// true
  
          Integer it3 = Integer.valueOf(130);
          Integer it4 = Integer.valueOf(130);
          System.out.println(it3 == it4);// false //超过127范围,会创建新的对象
  
          //自动包装:基本数据类型的数据可以直接变成包装对象的数据,不需要额外操作
          Integer it11 = 10;
          Integer it12 = 10;
          System.out.println(it11 == it12);// true
  
          //自动拆包装
          int i = it11;
          System.out.println(i);
  
          ArrayList<Integer> list1 = new ArrayList<>();
          list1.add(10);//自动包装
          list1.add(20);//自动包装
          int rs = list1.get(0);//自动拆包装
          System.out.println(rs);
  
          System.out.println("======================================");
  
          //包装类新增的功能
          //1.把基本类型的数据转化成字符串
          int j = 23;
          String rs1 = String.valueOf(j);
          System.out.println(rs1+1);//231
  
          Integer i2=j;
          String rs2 = i2.toString();
          System.out.println(rs2+1);//231
  
          String rs3=j+ "";// 将int类型数据变成字符串
          System.out.println(rs3+1);//231
  
          //2.把字符串转化成基本数据类型(很有用)
          String str = "98";
          // int rs4 = Integer.parseInt(str);
          int rs4 = Integer.valueOf( str);
          System.out.println(rs4+1);//99
  
          String str2 = "98.8";
          //double rs5 = Double.parseDouble(str2);
          double rs5 = Double.valueOf(str2);
          System.out.println(rs5+1);//99.8
      }
  }
  ```

## 集合框架

### 集合体系结构

- 迭代器

- ```java
  Iterator<String> it = list4.iterator();//游标处于初始位置（第一个元素之前）。不能直接获取任何元素，必须通过 next() 方法移动游标。
  it.next();//将游标向前移动到下一个元素,返回当前游标指向的元素。
  it.hasNext();//用于检查当前游标位置的下一个位置是否有元素。
  ```

- **Collection**单列集合,每个元素(数据)只包含一个值

- ![image-20251012135350983](./从零开始学java.assets/image-20251012135350983.png)

- ![image-20251012135430704](./从零开始学java.assets/image-20251012135430704.png)

- 遍历方法:

  - 迭代器遍历:Iterator<E> it 返回集合中的迭代器对象,该迭代器默认指向当前集合的第一个元素,通过迭代器获取集合元素,如果元素越界会出现NoSuchElementException异常

  - 增强for循环格式:   for(元素的数据类型 变量名 : 数组或集合){ }

  - Lambda表达式

  - ```java
    //        names.forEach(new Consumer<String>() {
    //            @Override
    //            public void accept(String s) {
    //                System.out.println(s);
    //            }
    //        });
    
    names.forEach(s-> System.out.println(s));
    ```

  - ![image-20251012154837151](./从零开始学java.assets/image-20251012154837151.png)

- List集合(支持索引)

  - ![image-20251013101511072](./从零开始学java.assets/image-20251013101511072.png)
  - ArrayList基于**数组**
    - 查询速度快
    - 增删数据效率低 
  - LinkedList基于**链表**(双链表)
    - 查询速度慢
    - 增删相较数组快,首尾操作快
    - ![image-20251013112200124](./从零开始学java.assets/image-20251013112200124.png)

- Set集合

  - HashSet集合的底层原理:![image-20251014110558317](./从零开始学java.assets/image-20251014110558317.png)![image-20251014115613933](./从零开始学java.assets/image-20251014115613933.png)![image-20251014115801579](./从零开始学java.assets/image-20251014115801579.png)
  - HashSet集合元素的去重操作:
    - 如果希望Set集合认为两个内容一样的对象是重复的,==必须重写对象的hashCode()和equals()方法==

- TreeSet集合

  - ![image-20251106111554440](./从零开始学java.assets/image-20251106111554440.png)

- ![image-20251118103814470](./从零开始学java.assets/image-20251118103814470.png)

- Map双列集合,每个元素包含两个值(键值对)

  - ![image-20251118104554598](./从零开始学java.assets/image-20251118104554598.png)

  - ![image-20251118104854595](./从零开始学java.assets/image-20251118104854595.png)

  - ![image-20251118111400055](./从零开始学java.assets/image-20251118111400055.png)

  - Map集合的遍历方法

  - ```java
    public class MapTraverseDemo3 {
        public static void main(String[] args) {
            //目标:Map集合的遍历方式
            //方法一:键找值
            Map<String, String> map = new HashMap<>();
            map.put("小张", "18");
            map.put("小王", "19");
            map.put("小张", "20");
            map.put("小李", "21");
            System.out.println(map);
            //1.获取所有的键到Set集合中
            Set<String> keys = map.keySet();
            //2.遍历Set集合,获取每一个键
            for (String key : keys) {
                //3.根据键获取值
                String value = map.get(key);
                System.out.println(key + "=" + value);
            }
    
            //方法二:键值对找键值对  Entry对象
            Set<Map.Entry<String, String>> entries = map.entrySet();//获取所有的键值对
            for (Map.Entry<String, String> entry : entries) {
                //获取键
                String key = entry.getKey();
                //获取值
                String value = entry.getValue();
                System.out.println(key + "=" + value);
            }
            //方法三:Lambda表达式
            map.forEach((key, value) -> System.out.println(key + "=" + value));
        }
    }
    ```


- Stream流

- ```java
  //1.先用传统方法,找出姓张的,名字为3个字,存入到新集合中
  List<String> newList = new ArrayList<>();
  for (String name : list) {
      if(name.startsWith("张") && name.length() == 3){
          newList.add(name);
      }
  }
  System.out.println(newList);
  //2.用Stream流,找出姓张的,名字为3个字,存入到新集合中
  List<String> newList2 =list.stream().filter(name -> name.startsWith("张") && name.length() == 3).collect(Collectors.toList());
  System.out.println(newList2);
  }
  ```
  
- ![image-20251128104635084](./从零开始学java.assets/image-20251128104635084.png)

- <img src="./从零开始学java.assets/image-20251128112923271.png" alt="image-20251128112923271" style="zoom:25%;" />

# Day03-File-IO

## 方法递归-文件搜索

```java
public class FileSearchTest4 {
    public static void main(String[] args) {
        //目标:使用递归实现文件搜索
        try {
            File dir = new File("D:\\");
            searchFile(dir, "QQ.exe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 递归方法实现文件搜索
     *
     * @param dir     要搜索的目录
     * @param keyword 要搜索的关键字
     */
    public static void searchFile(File dir, String keyword) throws Exception {
        //        1.判断极端情况
        if (dir == null || !dir.exists() || dir.isFile()) {
            return;
        }

        //2.获取目录下的所有一级文件或者文件夹对象
        File[] files = dir.listFiles();

        //3.判断当前目录下是否存在一级文件对象,存在才可以遍历
        if (files != null && files.length > 0) {
            //4.遍历一级文件对象
            for (File file : files) {
                //5.判断当前文件对象是否是文件
                if (file.isFile()) {
                    //6.判断文件名是否包含关键字
                    if (file.getName().contains(keyword)) {
                        System.out.println("找到文件:" + file.getAbsolutePath());
                        Runtime r=Runtime.getRuntime();
                        r.exec(file.getAbsolutePath());
                    }
                } else {
                    //7.递归搜索
                    searchFile(file, keyword);
                }
            }
        }
    }
}
```

## 字符集

![image-20251201110414067](./从零开始学java.assets/image-20251201110414067.png)

```java
public class CharSetDemo1  {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //目标:写程序实现字符编码和解码
        //1.编码
        String s = "中国abc5555";
        //byte[] bytes = s.getBytes(); // 默认编码
        byte[] bytes = s.getBytes("GBK");//指定编码
        System.out.println( bytes.length);
        System.out.println(Arrays.toString(bytes));

        //2.解码
        String s1 = new String(bytes,"GBK");//指定解码
        System.out.println(s1);
    }
}
```

## IO流

### io流的分类,体系

![image-20251201112429634](./从零开始学java.assets/image-20251201112429634.png)

![image-20251201112517360](./从零开始学java.assets/image-20251201112517360.png)

![image-20251201113133092](./从零开始学java.assets/image-20251201113133092.png)

- FileInputStream(**文件字节输入流**)

  - 作用:从磁盘文件中将数据以**字节**形式读入到内存中去

  - ![image-20251201201434315](./从零开始学java.assets/image-20251201201434315.png)

  - ```java
    public class FileInputStreamDemo1 {
        public static void main(String[] args) throws Exception {
            //目标:掌握文件字节输入流读取文件中的字节数组到内存中来
            //1.创建文件字节输入流管道与源文件接通
            InputStream is = new FileInputStream("day03-file-io\\src\\dilei02.txt");
            //2.创建字节数组,用于装文件字节数据
            byte[] bytes = new byte[1024];
            //3.读取文件字节数据到字节数组中
            int len = is.read(bytes);
            //4.把字节数组中的数据转换为字符串
            String text = new String(bytes, 0, len);
            System.out.println(text);
            //5.释放资源
            is.close();
            System.out.println("文件读取完毕!");
        }
    }
    ```

- FileOutputStream(**文件字节输出流**)

  - 作用:将数据以**字节**形式读出到磁盘文件中去

  - ![image-20251201205602948](./从零开始学java.assets/image-20251201205602948.png)

  - ```java
    public class FileInputStreamDemo1 {
        public static void main(String[] args) throws Exception {
            //目标:掌握文件字节输入流读取文件中的字节数组到内存中来
            //1.创建文件字节输入流管道与源文件接通
            InputStream is = new FileInputStream("day03-file-io\\src\\dilei02.txt");
            //2.创建字节数组,用于装文件字节数据
            byte[] bytes = new byte[1024];
            //3.读取文件字节数据到字节数组中
            int len = is.read(bytes);
            //4.把字节数组中的数据转换为字符串
            String text = new String(bytes, 0, len);
            System.out.println(text);
            //5.释放资源
            is.close();
            System.out.println("文件读取完毕!");
        }
    }
    ```

- 资源释放的方法

  - ![image-20251201213205905](./从零开始学java.assets/image-20251201213205905.png)

  - ```java
    public class CopyDemo1 {
        public static void main(String[] args) {
            copyFile("day03-file-io\\src\\dilei02.txt", "day03-file-io\\src\\dilei04.txt");
        }
        public static void copyFile(String srcPath, String destPath)  {
            try(
                    //这里只能放置资源对象,用完后最终会自动调用close()方法
                    InputStream fis = new FileInputStream(srcPath);
                    OutputStream fos = new FileOutputStream(destPath);
                    )
                {
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    while ((len = fis.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    System.out.println("文件复制完成！");
                }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    
      /*  public static void copyFile(String srcPath, String destPath) {
            InputStream fis = null;
            OutputStream fos = null;
            try {
                fis = new FileInputStream(srcPath);
                fos = new FileOutputStream(destPath);
                byte[] bytes = new byte[1024];
                int len = -1;
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                
                System.out.println("文件复制完成！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } */
    }
    ```

  - ![image-20251201215350947](./从零开始学java.assets/image-20251201215350947.png)

- FileReader(**文件字符输入流**)
  - 作用:从磁盘文件中将数据以**字符**形式读入到内存中去
  - ![image-20251202090114337](./从零开始学java.assets/image-20251202090114337.png)

- FileWriter(**文件字符输出流**)
  - 作用:从内存中将数据以**字符**形式读出到文件中去
  - ![image-20251202091615999](./从零开始学java.assets/image-20251202091615999.png)
- ![image-20251202100039859](./从零开始学java.assets/image-20251202100039859.png)

### 缓冲流

- ![image-20251202101311351](./从零开始学java.assets/image-20251202101311351.png)

  - ![image-20251202113227553](./从零开始学java.assets/image-20251202113227553.png)
  - ![image-20251202113312647](./从零开始学java.assets/image-20251202113312647.png)
  - ![image-20251202113338307](./从零开始学java.assets/image-20251202113338307.png)

- ```java
  public class CopyDemo2 {
      public static void main(String[] args) {
          copyFile("day03-file-io\\src\\dilei02.txt", "day03-file-io\\src\\dilei04.txt");
      }
  
      public static void copyFile(String srcPath, String destPath) {
          try (
                  //这里只能放置资源对象,用完后最终会自动调用close()方法
                  //把低级流升级为高级流
                  InputStream fis = new FileInputStream(srcPath);
                  InputStream bis = new BufferedInputStream(fis);
                  OutputStream fos = new FileOutputStream(destPath);
                  OutputStream bos = new BufferedOutputStream(fos);
          ) {
              byte[] bytes = new byte[1024];
              int len = -1;
              while ((len = bis.read(bytes)) != -1) {
                  bos.write(bytes, 0, len);
              }
              System.out.println("文件复制完成！");
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  ```

### 性能分析

```java
public class TimeTest3 {
    private static final String SRC_FILE = "D:\\视频\\大疆actiong3拍摄\\2025.11.22福建(高清)\\第二个沙滩游玩 (2)_1.mp4";
    private static final String DEST_FILE = "D:\\视频\\";

    public static void main(String[] args) {
        //copyFile();//太慢了
        copyFile2();
        copyFile3();
        copyFile4();

    }

    public static void copyFile() {
        //获取当前 时间
        long start = System.currentTimeMillis();
        try (OutputStream fos = new FileOutputStream(DEST_FILE + "1.mp4");
             InputStream fis = new FileInputStream(SRC_FILE);
            ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }


    //
    private static void copyFile2() {
        long start = System.currentTimeMillis();
        try (OutputStream fos = new FileOutputStream(DEST_FILE + "2.mp4");
             InputStream fis = new FileInputStream(SRC_FILE);
            ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }

    private static void copyFile3() {
        long start = System.currentTimeMillis();
        try (
            OutputStream bos = new BufferedOutputStream(new FileOutputStream(DEST_FILE + "3.mp4"));
            InputStream bis = new BufferedInputStream(new FileInputStream(SRC_FILE));
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }

    private static void copyFile4() {
        long start = System.currentTimeMillis();
        try (
            OutputStream bos = new BufferedOutputStream(new FileOutputStream(DEST_FILE + "4.mp4"));
            InputStream bis = new BufferedInputStream(new FileInputStream(SRC_FILE));
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }
}
```

### 字符输入转换流

![image-20251203200823807](./从零开始学java.assets/image-20251203200823807.png)

### 打印流

![image-20251203202433938](./从零开始学java.assets/image-20251203202433938.png)

![image-20251203202529885](./从零开始学java.assets/image-20251203202529885.png)

****

![image-20251203202503742](./从零开始学java.assets/image-20251203202503742.png)

### 特殊数据流

![image-20251203203511036](./从零开始学java.assets/image-20251203203511036.png)

![image-20251203203447152](./从零开始学java.assets/image-20251203203447152.png)

![image-20251203203202745](./从零开始学java.assets/image-20251203203202745.png)

## IO框架

![image-20251203212517120](./从零开始学java.assets/image-20251203212517120.png)

## Day04-多线程

## 创建方式

1,继承Thread类

![image-20251203214743321](./从零开始学java.assets/image-20251203214743321.png)

![image-20251211093637004](./从零开始学java.assets/image-20251211093637004.png)

2.实现Runnable接口

![image-20251211095151051](./从零开始学java.assets/image-20251211095151051.png)

![image-20251211101727748](./从零开始学java.assets/image-20251211101727748.png)

**只有Thread类才可以执行线程操作start函数**

3.实现Callable接口

![image-20251212110221899](./从零开始学java.assets/image-20251212110221899.png)

![image-20251212110602759](./从零开始学java.assets/image-20251212110602759.png)

![image-20251212112421625](./从零开始学java.assets/image-20251212112421625.png)

**Thread 构造方法的限制**
Thread 类的构造方法只接受 Runnable 类型参数
而 Callable 接口与 Runnable 接口不兼容
FutureTask 起到了桥梁作用，它同时实现了 Runnable 接口

**FutureTask 的双重身份**
作为 Runnable: 实现了 Runnable 接口，可以传递给 Thread 构造方法
作为 Future: 实现了 Future 接口，可以获取异步执行结果

总结

**FutureTask是将Callable的实现类转化为Thread类可以执行的的类**

![image-20251212112439357](./从零开始学java.assets/image-20251212112439357.png)

## 常用方法

![image-20251212142424528](./从零开始学java.assets/image-20251212142424528.png)

## 线程安全的方案

**线程同步**

- 同步代码块![image-20251213113543949](./从零开始学java.assets/image-20251213113543949.png)![image-20251213114144625](./从零开始学java.assets/image-20251213114144625.png)

- 同步方法![image-20251213115134755](./从零开始学java.assets/image-20251213115134755.png)
- 同步对比![image-20251213115323775](./从零开始学java.assets/image-20251213115323775.png)
- Lock锁![image-20251213120439385](./从零开始学java.assets/image-20251213120439385.png)![image-20251213120938752](./从零开始学java.assets/image-20251213120938752.png)

## 线程池demo7executorService

- 创建线程池

![image-20251213131122721](./从零开始学java.assets/image-20251213131122721.png)![image-20251213141236489](./从零开始学java.assets/image-20251213141236489.png)

submit函数返回类型是Future<T>

当调用 submit(callable) 时，ExecutorService 内部会创建相应的 FutureTask

FutureTask 包装了 Callable 对象并负责执行任务
执行完成后，可以通过 Future.get() 获取 Callable.call() 的返回结果

![image-20251213132055902](./从零开始学java.assets/image-20251213132055902.png)

![image-20251213135609145](./从零开始学java.assets/image-20251213135609145.png)

![image-20251213140431438](./从零开始学java.assets/image-20251213140431438.png)

**Future 是一个接口，定义了异步计算的结果获取和操作方法**
**FutureTask 是 Future 接口的一个实现类**

![image-20251213154418408](./从零开始学java.assets/image-20251213154418408.png)

![image-20251213160650759](./从零开始学java.assets/image-20251213160650759.png)

## 并发/并进

![image-20251213163031537](./从零开始学java.assets/image-20251213163031537.png)

## Day05-Java网络编程

**BS架构**:浏览器与服务器端(主流)

CS架构:客户端与服务器端

## 网络编程三要素

![image-20251214103012032](./从零开始学java.assets/image-20251214103012032.png)

### ip

![image-20251214103211377](./从零开始学java.assets/image-20251214103211377.png)

![image-20251214103143564](./从零开始学java.assets/image-20251214103143564.png)![image-20251214103426537](./从零开始学java.assets/image-20251214103426537.png)

### 端口

### 协议
