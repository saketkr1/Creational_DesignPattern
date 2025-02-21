
/*
3. Abstract Factory Pattern
The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

 */

interface OnePlusBrand {
    String getOnePlusModel();
}

class OnePlus8 implements OnePlusBrand {
    @Override
    public String getOnePlusModel() {
        return "OnePlus 8";
    }
}

class OnePlus8T implements OnePlusBrand {
    @Override
    public String getOnePlusModel() {
        return "OnePlus 8T";
    }
}

class OnePlusFactory {
    public static OnePlusBrand createOnePlus(String model) {
        if (model == null) {
            return null;
        }
        if (model.equalsIgnoreCase("OnePlus8")) {
            return new OnePlus8();
        } else if (model.equalsIgnoreCase("OnePlus8T")) {
            return new OnePlus8T();
        }
        return null;
    }
}

interface IphoneBrand {
    String getIphoneModel();
}

class Iphone11 implements IphoneBrand {
    @Override
    public String getIphoneModel() {
        return "Iphone 11";
    }
}

class Iphone12 implements IphoneBrand {
    @Override
    public String getIphoneModel() {
        return "Iphone 12";
    }
}

class IphoneFactory {
    public static IphoneBrand createIphone(String model) {
        if (model == null) {
            return null;
        }
        if (model.equalsIgnoreCase("Iphone11")) {
            return new Iphone11();
        } else if (model.equalsIgnoreCase("Iphone12")) {
            return new Iphone12();
        }
        return null;
    }
}

interface SamsungFactory {
    String getSamsungModel();
}

class SamsungGalaxyS20 implements SamsungFactory {
    @Override
    public String getSamsungModel() {
        return "Samsung Galaxy S20";
    }
}

class SamsungGalaxyS21 implements SamsungFactory {
    @Override
    public String getSamsungModel() {
        return "Samsung Galaxy S21";
    }
}

class SamsungFactoryFactory {
    public static SamsungFactory createSamsung(String model) {
        if (model == null) {
            return null;
        }
        if (model.equalsIgnoreCase("SamsungGalaxyS20")) {
            return new SamsungGalaxyS20();
        } else if (model.equalsIgnoreCase("SamsungGalaxyS21")) {
            return new SamsungGalaxyS21();
        }
        return null;
    }
}

class PhoneFactory {
    public static Object createPhone(String brand, String model) {
        if (brand == null) {
            return null;
        }
        if (brand.equalsIgnoreCase("OnePlus")) {
            return OnePlusFactory.createOnePlus(model);
        } else if (brand.equalsIgnoreCase("Iphone")) {
            return IphoneFactory.createIphone(model);
        } else if (brand.equalsIgnoreCase("Samsung")) {
            return SamsungFactoryFactory.createSamsung(model);
        }
        return null;
    }
}

class AbstractFactory {
    public static void main(String[] args) {
        // Factory Pattern
        System.out.println("Factory Pattern");
        OnePlusBrand onePlus = (OnePlusBrand) PhoneFactory.createPhone("OnePlus", "OnePlus8");
        System.out.println(onePlus.getOnePlusModel());

        IphoneBrand iphone = (IphoneBrand) PhoneFactory.createPhone("Iphone", "Iphone11");
        System.out.println(iphone.getIphoneModel());

        SamsungFactory samsung = (SamsungFactory) PhoneFactory.createPhone("Samsung", "SamsungGalaxyS20");
        System.out.println(samsung.getSamsungModel());
    }
}


