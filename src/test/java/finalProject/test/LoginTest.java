package finalProject.test;

import finalProject.Base.BaseUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseUITest {
    @Test
    public void loginWithValidCredentialAndValidateUserNavigatesToCustomerServicePortalPage(){
        clickOnElement(loginPage.loginBtn);
        sendText(loginPage.userName,"supervisor");
        sendText(loginPage.userPassword,"tek_supervisor");
        clickOnElement(loginPage.signInBtn);

        boolean isCustomerServicePortalTitleDisplayedAfterLogin = isElementDisplayed(loginPage.customerServicePortalPage);
        Assert.assertTrue(isCustomerServicePortalTitleDisplayedAfterLogin,
                "User should be taken to customer service portal page after successful login");

    }
}
