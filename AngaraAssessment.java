import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnagaraOrderAutomation {
public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

// Initialize WebDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to the website
    driver.get("https://anagara.in");

    // Add item to cart
    WebElement item = driver.findElement(By.xpath("//div[@class='product']/a"));
    item.click();

    // Wait for the Add to Cart button to be clickable
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to Cart')]")));
    addToCartButton.click();

    // Fill in shipping details
    WebElement nameInput = driver.findElement(By.id("name"));
    nameInput.sendKeys("John Doe");

    //Proceed to checkout
    WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(), 'Checkout')]"));
    checkoutButton.click();

    // Fill in payment details
    // Switching to iframe
    // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='payment-frame']")));

    // Fill in payment details like card number, expiry date, CVV, etc.

    // Submit order
    WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]"));
    placeOrderButton.click();

    //Verify order confirmation
    // You can check for a confirmation message or wait for an email confirmation

    // Close the browser
    driver.quit();
}