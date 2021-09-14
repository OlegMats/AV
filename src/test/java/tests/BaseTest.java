package tests;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.util.LinkedList;
import java.util.List;

@Listeners({framework.listeners.CustomListener.class})
public class BaseTest {

    @DataProvider(name = "UsersConfigurations")
    public Object[][] RealDeviceUsersConfigurations() {
        return combine(DevicesData(), UsersData());
    }

    @DataProvider(name = "CarsConfigurations")
    public Object[][] RealDeviceCarsConfigurations() {
        return combine(DevicesData(), CarsData());
    }

    @DataProvider(name = "UsersData")
    public static Object[][] UsersData() {
        return new Object[][]{
                {"letmeshadowfiend@gmail.com", "Oleg5969396!"},
                {"alex30121968@gmail.com", "Alex30121968"}
        };
    }

    @DataProvider(name = "CarsData")
    public static Object[][] CarsData() {
        return new Object[][]{
                {"Audi", "100"},
                {"BMW", "X5"},
                {"Chevrolet", "Lacetti"},
                {"Honda", "Accord"}
        };
    }

    public static Object[][] DevicesData() {
        return new Object[][]{
                {"R58N803Q1ZA"},
                {"emulator-5554"}
        };
    }

    public static Object[][] combine(Object[][] a1, Object[][] a2) {
        List<Object[]> objectLoginList = new LinkedList<Object[]>();
        for (Object[] o1 : a1) {
            for (Object[] o2 : a2) {
                objectLoginList.add(concatAll(o1, o2));
            }
        }
        return objectLoginList.toArray(new Object[0][0]);
    }

    public static Object[] concatAll(Object[] first, Object[] second) {
        return ArrayUtils.addAll(first, second);
    }
}
