

/*
 1. Singleton Pattern
The Singleton Pattern ensures that a class has only one instance and provides a global point of access to that instance.
It is used in scenarios when a user wants to restrict instantiation of a class to only one.
*/

/*
Steps to create Singleton Pattern
1. Create a private static instance of the class.
2. Create a private constructor to restrict instantiation of the class.
3. Create a public static method to return the instance of the class.

 */


class Singleton {
    private static Singleton singleton;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}

/*
Use Cases of Singleton Pattern
1. Database Connections - Ensures a single connection pool is used.
2. Logger - Ensures a single logger instance is used.
3. Configuration - Ensures a single configuration instance is used.
4. Cache Management - Ensures a single point of caching.
5. Thread Pool Management - Ensures a single thread pool is used.
*/
