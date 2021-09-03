package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({framework.listeners.CustomListener.class})
public class BaseTest {

    @DataProvider(name = "users")
    public Object[][] UsersData() {
        return new Object[][]{
                {"letmeshadowfiend@gmail.com", "Oleg5969396!"},
                {"alex30121968@gmail.com", "Alex30121968"}
        };
    }

    @DataProvider(name = "cars")
    public Object[][] CarsData() {
        return new Object[][]{
                {"Audi", "100"},
                {"BMW", "X5"},
                {"Chevrolet", "Lacetti"},
                {"Honda", "Accord"}
        };
    }
}
