package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class SwiggyAutomation {
    public static void main(String[] args) throws InterruptedException {

        String phoneNumber = "9876543210";
        String deliveryLocation = "Bengaluru";
        String restaurantName = "Domino's Pizza";
        String doorFlatNumber = "101, Tech Park";
        String landmark = "Near Main Road";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/");


        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(3000);

        //Login
        System.out.println(" Step 1: Logging in ");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div/span[2]"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement phoneInput = driver.findElement(By.xpath("//input[@id='mobile']"));
        phoneInput.sendKeys(phoneNumber);
        Thread.sleep(1000);

        WebElement clickLogin = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/form/div[2]/a"));
        clickLogin.click();
        Thread.sleep(3000);



        System.out.println("\n⚠️ Please enter the OTP manually in the browser.");
        System.out.println("   Waiting for 15 seconds...");
        Thread.sleep(15000); // Pause for manual OTP entry

        WebElement submitotp = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/div[2]/form/div[2]/div[2]/a"));
        submitotp.click();
        Thread.sleep(3000);

        // Enter Location for Delivery
        System.out.println("\n Step 2: Setting Delivery Location ");
        WebElement location = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/div/span[1]/span"));
        location.click();
        Thread.sleep(1000);
        WebElement locationInput = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[2]/div[2]/div/input"));
        locationInput.sendKeys(deliveryLocation);
        Thread.sleep(2000);

        WebElement locationSuggestion = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/div[1]"));
        locationSuggestion.click();
        Thread.sleep(2000);


        WebElement skipAddress = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div[3]/a[2]/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(skipAddress).click().perform();
        System.out.println("Location set to: " + deliveryLocation);
        Thread.sleep(4000);

        // Search for a Restaurant
        System.out.println("\n Step 3: Searching for a Restaurant ");
        WebElement searchLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[5]/div/a/span[2]"));
        searchLink.click();
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div/form/div/div[1]/input"));
        searchBox.sendKeys(restaurantName);
        Thread.sleep(3000);

        WebElement firstRestaurant = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/button[1]/div[2]/div[1]/b[1]"));
        firstRestaurant.click();
        Thread.sleep(2000);

        WebElement dominos = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div[3]/div[1]/div/a/div[2]/div[1]/div"));
        dominos.click();
        System.out.println("Selected restaurant: " + restaurantName);
        Thread.sleep(5000);

        //scrolling the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1250)");
        Thread.sleep(2000);

        // Select a Food Item and Add to Cart
        System.out.println("\n Step 4: Adding item to cart ");

        Thread.sleep(1000);

        // Navigate to Cart and Increase Quantity
        System.out.println("\n Step 5: Increasing item quantity ");
        WebElement viewCartButton = driver.findElement(By.xpath("//*[@id=\"cid-Recommended\"]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div/button[2]/div"));
        viewCartButton.click();
        Thread.sleep(1000);
        WebElement continueButton = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[3]/div/div[2]/div/button/span"));
        continueButton.click();
        Thread.sleep(500);
        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[3]/div/div[2]/div/button/span"));
        addToCartButton.click();
        Thread.sleep(1000);

        WebElement viewCart = driver.findElement(By.xpath("//*[@id=\"view-cart-btn\"]/span/span[2]/span"));
        viewCart.click();
        Thread.sleep(2000);
        WebElement increaseQtyButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]"));
        increaseQtyButton.click();
        Thread.sleep(500);
        WebElement repeatLastOrder = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/button[2]"));
        repeatLastOrder.click();


        System.out.println("Increased item quantity to 2.");
        Thread.sleep(2000);

        //Enter Delivery Address
        System.out.println("\n Step 6: Entering Delivery Address ");
        WebElement addNewAddressButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[3]"));
        addNewAddressButton.click();
        Thread.sleep(2000);

        WebElement doorInput = driver.findElement(By.xpath("//*[@id=\"building\"]"));
        doorInput.sendKeys(doorFlatNumber);

        WebElement landmarkInput = driver.findElement(By.xpath("//*[@id=\"landmark\"]"));
        landmarkInput.sendKeys(landmark);

        WebElement addressTypeHome = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div[3]/div[3]/div[3]/div[1]"));
        addressTypeHome.click();
        System.out.println("Address details entered.");
        Thread.sleep(1000);

        WebElement saveAddressButton = driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div[4]/div/div/a"));
        saveAddressButton.click();
        System.out.println("Address saved.");
        Thread.sleep(3000);

        // Proceed to Payment Page
        System.out.println("\n Step 7: Proceeding to Payment ");
        WebElement proceedToPayButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[1]/div/div[2]/div/button"));
        proceedToPayButton.click();
        Thread.sleep(5000); // Wait for payment page to load

        System.out.println("\nSuccessfully reached the payment page.");
        System.out.println("Automation script finished.");

        // Closing the browser
        Thread.sleep(5000);
        driver.quit();
    }
}
