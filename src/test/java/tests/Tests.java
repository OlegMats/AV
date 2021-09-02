package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OtherPage;

@Listeners({framework.listeners.CustomListener.class})
public class Tests {

    @Test(dataProvider = "users")
    public void LoginTest(String email, String password) {
        MainPage.GoTo(MainPage.other);
        OtherPage.GoToLoginForm();
        LoginPage.LoginByMail(email, password);

        //Assert.assertEquals(OtherPage.GetUsername(), username, "Wrong username");
    }

    @DataProvider(name = "users")
    public Object[][] UsersData() {
        return new Object[][]{
                {"letmeshadowfiend@gmail.com", "Oleg5969396!"},
                {"alex30121968@gmail.com", "Alex30121968"}
        };
    }
}
