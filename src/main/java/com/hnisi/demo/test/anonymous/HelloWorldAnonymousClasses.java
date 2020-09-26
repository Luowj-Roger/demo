package com.hnisi.demo.test.anonymous;

/**
 * 匿名内部类创建
 *
 * new 类名或接口名(){
 *     重写方法;
 * }；     //注意分号
 * //以上就是内部类的格式，其实这整体就相当于是new出来的一个对象
 *
 * ​我们在开发的时候，会看到抽象类，或者接口作为参数。
 *
 * 而这个时候，实际需要的是一个子类对象。
 *
 * 如果该方法仅仅调用一次，我们就可以使用匿名内部类的格式简化。
 */
public class HelloWorldAnonymousClasses {

    /**
     * 包含两个方法的HelloWorld接口
     */
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello() {

        // 1、局部类EnglishGreeting实现了HelloWorld接口
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        // 2、匿名类实现HelloWorld接口
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        // 3、匿名类实现HelloWorld接口
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }

}
