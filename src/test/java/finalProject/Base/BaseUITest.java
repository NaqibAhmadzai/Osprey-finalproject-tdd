package finalProject.Base;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import finalProject.Pages.CreateAccountPage;
import finalProject.Pages.HomePage;
import finalProject.Pages.LoginPage;
import finalProject.utility.SeleniumUtilites;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners({ExtentITestListenerAdapter.class})
public class BaseUITest extends SeleniumUtilites {
        public HomePage homePage;
        public CreateAccountPage createAccountPage;
        public LoginPage loginPage;
        @BeforeMethod
        public void initiateTestMethod(){
            super.openBrowser();
            homePage = new HomePage();
            createAccountPage = new CreateAccountPage();
            loginPage = new LoginPage();
        }
        @AfterMethod
        public void endTestMethod (ITestResult result) throws InterruptedException {
            // Thread.sleep(20000);
            if(result.getStatus()== ITestResult.FAILURE){
                TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
                String screenShot = takesScreenshot.getScreenshotAs(OutputType.BASE64);
                ExtentTestManager.getTest().fail("Test Failed Taking Screen Shot"
                        , MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
            }
            super.closingBrowser();
        }

    }

