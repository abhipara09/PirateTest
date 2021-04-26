package datamodels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class WaitHelper {
    public static WebDriverWait wait;
    public static int SCREENHEIGHT = 1080;
    private WebDriver driver;


    /**
     * This is a constructor for this class
     *
     * @param driver
     */
    public WaitHelper(WebDriver driver) {

        this.driver = driver;
//        log.info("Wait Helper object has been created....");
    }


    /**
     * Wait For Text To Appear
     *
     * @param element
     * @param textToAppear
     */
    public void waitForTextToAppear(WebElement element, String textToAppear) {
        WebDriverWait wait = new WebDriverWait(driver, 180);
        //wait.until(ExpectedConditions.textToBePresentInElement(element,textToAppear));
    }

    /**
     * Wait for text to be present
     *
     * @param locator
     * @param timeOutInSeconds
     * @param text
     */
    public void waitForTextMatches(By locator, int timeOutInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(text)));
    }

    public void waitForTextToBePresentInElementLocated(By locator, int timeOutInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));

    }

    public void waitForInvisibilityOfElementWithText(By locator, int timeOutInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public void waitForInvisibilityofElment(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    /**
     * Wait for element to be CLICKABLE by Element
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
        // log.info("Waiting for :" + element.toString() + " for : " + timeOutInSeconds + "seconds");
        // log.info("Waiting for element to be clickable...." + timeOutInSeconds + "seconds");
        //  log.info("Waiting for Element to be clickable....");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        // log.info("Element is clickable now .... ");
    }


    /**
     * Waiting for element to be VISIBLE
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
        // log.info("Waiting for :" + element.toString() + " for : " + timeOutInSeconds + "seconds");
        // log.info("Waiting for element to be Visible ...." + timeOutInSeconds + "seconds");
        //log.info("Waiting for Element to be Visible....");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        //log.info("Element is Visible now .... ");
    }

    /**
     * Waiting for ALL element to be VISIBLE
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForAllElementVisible(WebElement element, int timeOutInSeconds) {
        // log.info("Waiting for :" + element.toString() + " for : " + timeOutInSeconds + "seconds");
        // log.info("Waiting for element to be Visible ...." + timeOutInSeconds + "seconds");
        //  log.info("Waiting for All Element to be Visible....");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        // log.info("Element is Visible now .... ");
    }


    /**
     * This method will be used for Ajax item to load on page
     *
     * @throws InterruptedException
     */


    }


