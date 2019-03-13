package automation.todo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MVCTest {
	

	private static FirefoxDriver driver;
	WebElement element;
    public static String Url = "http://todomvc.com/examples/angularjs/#/";
	@BeforeClass
	public static void openBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();



			driver.get(Url);

		} catch (Exception e) {
			System.out.println("Exception Unable to load driver\n" + e.getMessage());
		}
	}

	@Test
	public void Case1_EnterInfoAndDelete_Test() throws InterruptedException {

	    System.out.println("Test Case 1 : Provide simple information and Remove");

		Thread.sleep(3000);
		WebElement textfield = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
		textfield.sendKeys("New Entry");
		textfield.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(By.className("main"));
        WebElement elem1 = elem.findElement(By.className("todo-list"));
        WebElement elem2 = elem1.findElement(By.cssSelector("input[ng-model='todo.completed']"));
		//action.click(elem2).build().perform();
        elem2.click();
        Thread.sleep(4000);

        WebElement crossBtn = elem1.findElement(By.className("destroy"));
        action.moveToElement(crossBtn).click().build().perform();
        Thread.sleep(4000);

        System.out.println("Test Case 1 : Test Case Passed");


    }
	@Test
	public void Case2_ClearCompleted_Test() throws InterruptedException
	{
        //driver.get(Url);

        System.out.println("Test Case 2 : Clear Completed To Do list");

        WebElement textfield = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry1");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement textfield1 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry2");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement textfield2 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry3");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement elem = driver.findElement(By.className("main"));
        WebElement elem1 = elem.findElement(By.className("todo-list"));

        List<WebElement> lstTodo = elem1.findElements(By.cssSelector("input[ng-model='todo.completed']"));

        lstTodo.get(0).click();
        lstTodo.get(2).click();

        Thread.sleep(2000);
        driver.findElement(By.className("clear-completed")).click();
        Thread.sleep(1000);

        System.out.println("Test Case 2 : Test Case Passed");
        this.FlushTodoList();


    }
	@Test
	public void Case3_FindCompleted_Test() throws InterruptedException
	{
        System.out.println("Test Case 3 : Find Completed To do list Items");

       // driver.get(Url);

        WebElement textfield = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry1");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement textfield1 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry2");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement textfield2 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry3");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement elem = driver.findElement(By.className("main"));
        WebElement elem1 = elem.findElement(By.className("todo-list"));

        List<WebElement> lstTodo = elem1.findElements(By.cssSelector("input[ng-model='todo.completed']"));

        lstTodo.get(1).click();
        lstTodo.get(2).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Completed")).click();
        Thread.sleep(1000);

        System.out.println("Test Case 3 : Test Case Passed");

        this.FlushTodoList();


    }


    @Test
    public void Case4_FindCompleted_Test() throws InterruptedException
    {
        //driver.get(Url);

        System.out.println("Test Case 4 : Find And Validate Completed to Do List");

        driver.navigate().refresh();
        WebElement textfield = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry1");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement textfield1 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry2");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement textfield2 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry3");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement textfield4 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry4");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement textfield5 = driver.findElement(By.xpath("/html/body/ng-view/section/header/form/input"));
        textfield.sendKeys("New Entry5");
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement elem = driver.findElement(By.className("main"));
        WebElement elem1 = elem.findElement(By.className("todo-list"));

        List<WebElement> lstTodo = elem1.findElements(By.cssSelector("input[ng-model='todo.completed']"));

        lstTodo.get(0).click();
        lstTodo.get(1).click();
        lstTodo.get(3).click();
        lstTodo.get(4).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Active")).click();
        Thread.sleep(1000);

        elem = driver.findElement(By.className("main"));

        elem1 = elem.findElement(By.className("todo-list"));
        List<WebElement> lstTodoRead = elem1.findElements(By.cssSelector("input[ng-model='todo.completed']"));
        int nmberOfTodos = lstTodoRead.size();
        Assert.assertEquals(1, nmberOfTodos);

        System.out.println("Test Case 4 : Test Case Passed");
        this.FlushTodoList();


    }

    private void FlushTodoList() throws InterruptedException {
        driver.findElement(By.linkText("All")).click();
        Thread.sleep(1000);
        //WebElement elem = driver.findElement(By.className("main"));
        //WebElement elem1 = elem.findElement(By.className("todo-list"));

        //List<WebElement>  LstCrossBtn = elem1.findElements(By.className("destroy"));

        WebElement main = driver.findElement(By.className("main"));
        WebElement toggle = main.findElement(By.cssSelector("label[for='toggle-all']"));
        toggle.click();
        Thread.sleep(1000);

        driver.findElement(By.className("clear-completed")).click();
        Thread.sleep(1000);






    }


    @AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}

/*
 * import junit.framework.TestCase;
 * 
 * public class MVCTest extends TestCase {
 * 
 * }
 */
