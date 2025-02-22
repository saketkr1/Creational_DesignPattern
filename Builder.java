
/*
4. Builder Pattern
The Builder Pattern is used to construct a complex object step by step. It is used when a user wants to create an object with a large number of parameters.
It provides a way to construct an object by specifying the type and content of the object step by step.
*/


class Car {
    private String model;
    private String color;
    private int year;
    private boolean sunroof;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.sunroof = builder.sunroof;
    }

    public void showCarDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Car Color: " + color);
        System.out.println("Car Year: " + year);
        System.out.println("Sunroof: " + sunroof);
    }

    public static class CarBuilder {
        private String model;
        private String color;
        private int year;
        private boolean sunroof;

        public Car build() {
            return new Car(this);
        }

        CarBuilder(String model) {
            this.model = model;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }
    }
}


public class Builder {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("SUV")
                .setColor("Black")
                .setYear(2021)
                .setSunroof(true)
                .build();
        car.showCarDetails();
    }
}
