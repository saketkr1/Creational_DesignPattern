

/*
  2. Factory Pattern

The Factory Pattern is a creational design pattern that provides an interface for creating objects
but allows subclasses to alter the type of objects that will be created.
It helps encapsulate object creation logic and makes code more maintainable and scalable.
Also, when we need to create objects based on certain conditions, we can use the Factory Pattern.
*/

interface Notification {
    void sendNotification();
}

class EmailNotification implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("Sending an email notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("Sending an SMS notification");
    }
}

class PushNotification implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("Sending a push notification");
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        Notification emailNotification = NotificationFactory.createNotification("EMAIL");
        emailNotification.sendNotification();

        Notification smsNotification = NotificationFactory.createNotification("SMS");
        smsNotification.sendNotification();

        Notification pushNotification = NotificationFactory.createNotification("PUSH");
        pushNotification.sendNotification();
    }
}

/*
 Use case of Factory Pattern:
1. Creating different types of database connections (MySQL, PostgreSQL, MongoDB) based on configuration.
2. Object creation logic is complex and should be centralized.
3. Object creation is required at multiple places in the code.
4. Logging frameworks that support multiple outputs (Console, File, Database).
 */
