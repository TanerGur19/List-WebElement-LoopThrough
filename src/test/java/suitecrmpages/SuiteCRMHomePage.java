package suitecrmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuiteCRMHomePage {

	private WebDriver driver;

	public SuiteCRMHomePage(WebDriver driver) {
		this.driver= driver;  // in order to call driver inside Actions() we need 
		PageFactory.initElements(driver, this);

		
	}

	@FindBy(linkText = "CREATE")
	public WebElement create;

	// create new item (Create Task)
	public void createNewItem(String itemType) {

		Actions action = new Actions(driver);
		action.moveToElement(create).perform(); // hovering over
		driver.findElement(By.linkText(itemType)).click(); // finding Create link

	}

}
