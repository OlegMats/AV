package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Tests extends BaseTest {

    @Test(dataProvider = "UsersData")
    public void LoginTest(String email, String password) {
        MainPage.GoTo(MainPage.other);
        OtherPage.GoToLoginForm();
        LoginPage.LoginByMail(email, password);

        Assert.assertTrue(OtherPage.CheckForQuitButtonPresence());
    }

    @Test(dataProvider = "CarsData")
    public void SearchTest(String brand, String model) {
        SearchPage.SearchWithParams();
        SearchWithParamsForm.SearchForCar(brand, model);
        SearchWithParamsForm.ShowResults();

        Assert.assertTrue(SearchResultsPage.GetFirstResult().contains(brand));
        Assert.assertTrue(SearchResultsPage.GetFirstResult().contains(model));
    }
}
