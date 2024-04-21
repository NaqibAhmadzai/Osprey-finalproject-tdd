package finalProject.Pages;

import finalProject.utility.SeleniumUtilites;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanPage extends SeleniumUtilites {
    public PlanPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a[2]")
    public WebElement planBtn;

}
