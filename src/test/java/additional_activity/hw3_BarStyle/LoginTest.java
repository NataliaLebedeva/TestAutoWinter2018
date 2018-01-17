//package homework.homework_3;
//
//import homework.TestBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class LoginTest extends ApplicationTestBase {
//
//    @Test
//    public void loginTest() {
//        app.open();
//        app.performLogin();
//
//        //asserts should be here:
//
//        app.quit();
//    }
//
//    @Test
//    //(dataProviderClass = innerDataProvider.class, dataProvider = "data")
//    public void login2Test() {
////String locator, String textBelowPic
//        //3. Assert Browser title
//        wait.until(ExpectedConditions.titleIs(innerDataProvider.TITLE));
//
//        //4. Perform login
//        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
//        driver.findElement(By.id("Login")).sendKeys(innerDataProvider.USERLOGIN);
//        driver.findElement(By.id("Password")).sendKeys(innerDataProvider.USERPASS);
//        driver.findElement(By.cssSelector(".uui-button")).click();
//
//        //5. Assert User name in the left-top side of screen that user is logined
//        WebElement profileInfo = driver.findElement(By.cssSelector(".profile-photo span"));
//        Assert.assertTrue(innerDataProvider.USERNAME.equalsIgnoreCase(profileInfo.getText()));
//
//        //6. Assert Browser title
//        wait.until(ExpectedConditions.titleIs(innerDataProvider.TITLE));
//
//        //7. Assert that there are 4 images on the Home Page and they are displayed
//        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
//        Assert.assertEquals(images.size(), 4);
//        for (WebElement img : images) {
//            Assert.assertTrue(img.isDisplayed());
//        }
//
//        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
//        List<WebElement> textBelowImg = driver.findElements(By.cssSelector(".benefit-txt"));
//        Assert.assertEquals(textBelowImg.size(), 4);
//
//        String commonLocator = "//span[contains(@class,'%s')]/../../span";
//        //Assert.assertEquals(textBelowPic, driver.findElement(By.xpath(String.format(commonLocator, locator))).getText());
//        softAssert.assertEquals(innerDataProvider.PRACTICES,  driver.findElement(By.xpath(String.format(commonLocator,"practise"))).getText().replaceAll("\n", " "));
//        softAssert.assertEquals(innerDataProvider.CUSTOM,     driver.findElement(By.xpath(String.format(commonLocator,"custom"))).getText().replaceAll("\n", " "));
//        softAssert.assertEquals(innerDataProvider.MULTI,      driver.findElement(By.xpath(String.format(commonLocator,"multi"))).getText());
//        softAssert.assertEquals(innerDataProvider.BASE,       driver.findElement(By.xpath(String.format(commonLocator,"base"))).getText().replaceAll("\n", " "));
//
//        //9. Assert that there are the main header and the text below it on the Home Page
//        WebElement actualMainTitle = driver.findElement(By.cssSelector(".main-txt"));
//        Assert.assertEquals(innerDataProvider.MAIN_TEXT, actualMainTitle.getText());
//        WebElement actualMainTxt = driver.findElement(By.cssSelector(".main-title"));
//        Assert.assertEquals(innerDataProvider.MAIN_TITLE, actualMainTxt.getText());
//
//        softAssert.assertAll();
//
//    }
//}
