package TMSPageObjects;



import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TMSPage<ByXPath> extends PageObject{


    public WebDriver driver;

    // elements

    String Url = "https://korridor.crownsoftware.co.za/";
    String UserNameXpath = "//input[@id='Input_Email']";
    String PasswordXpath = "//input[@id='Input_Password']";
    String LoginButtonXpath = "//button[normalize-space()='Log In']";

   // Landing Page Elements

   String TenantDropXpath = "//*[@id=\"dropdownTenant\"]";

   // New Order Elements

    String OrderIdXpath = "//input[@placeholder='Order Id...']";
    String PONumberXpath = "//input[@placeholder='PO Number...']";
    String OrderXpath = "/html/body/div[2]/aside/section/ul/li[3]/a";
    String editOrder = "//*[@id=\"edit\"]";
    String authButton = "//*[@id=\"devextreme0\"]/div[1]/div[1]";
    String SelectCustomerDropListXpath1 = "//*[@id=\"devextreme0\"]";
    String ClickDropListRouteXpath = "(//div[@role='combobox'])[2]";
    String SelectRouteXpath = "//*[@id=\"routesLookup\"]/div[1]/div[1]";
    String ClickDropListProductXpath = "//*[@id=\"uberForm\"]/section[2]/div[2]/div/div[3]/div[1]/select";
    String SelectProductXpath = "(//select[@title='Product'])[1]";
    String ProductDesXpath = "//input[@placeholder='Product Desc...']";
    String ClickDelTypeDropListXpath = "//*[@id=\"uberForm\"]/section[2]/div[2]/div/div[4]/div/select";
    String SelectDelTypeXpath = "//*[@id=\"uberForm\"]/section[2]/div[2]/div/div[4]/div/select";
    String QTYXpath = "//*[@id=\"uberForm\"]/section[2]/div[2]/div/div[5]/div/input";
    String CollectionDAteXpath = "//*[@id=\"ExpectedOn\"]";
    String DeliveryDateXpath = "//*[@id=\"PlannedOn\"]";
    String SlotTimeXpath = "//*[@id=\"SlotTime\"]";
    String SaveButtonXpath = "//input[@value='Save']";


    // Action Login Tests

  @Step("Launched TMS Website")
    public void TMSWebsite(){
      getDriver().get(Url);
      getDriver().manage().window().maximize();
  }

  @Step("Driver Captures UserName and Password")
    public void LogIn(String UserName, String Password) {

      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(0));
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(UserNameXpath))).sendKeys(UserName);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PasswordXpath))).sendKeys(Password);

  }

  @Step("CLick LogIn Button")
    public void Click(){
      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(0));
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginButtonXpath))).click();
  }

  @Step("Click on Tenant and select Demo from drop list")
    public void SelectDemo() throws InterruptedException {
      //Thread.sleep(1000);
      WebElement dropList = $(By.xpath(TenantDropXpath));
      Select selectObject = new Select(dropList);
      selectObject.selectByValue("2");
  }

  @Step("Click Order")
    public void Order() throws InterruptedException {
//      Thread.sleep(1000);
      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OrderXpath))).click();


//      WebElement button = $(By.xpath(OrderXpath));
//      button.click();
  }
    public void CreateOrder() throws InterruptedException {
     // Thread.sleep(1000);

      WebElement button = $(By.linkText("Create Order"));
      button.click();
  }

    public void EnterOrderId(String OrderId){
        $(By.xpath(OrderIdXpath)).sendKeys("TMS001");
    }

    public void EnterPONumber(String PONumber){
        $(By.xpath(PONumberXpath)).sendKeys("TMS002");

    }



    public void SelectCustomer() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement txtfield = $(By.xpath("//div[@id='devextreme0']//div[@role='combobox'][normalize-space()='Select...']"));
        txtfield.click();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"devextreme0\"]/div/div[1]")));
        WebElement customerOption = $(By.xpath("//div[@class='dx-item-content dx-list-item-content'][normalize-space()='000001 - Customer 1']")); // Replace 'Customer Name' with the actual name
        customerOption.click();
    }

    public void SelectRoute() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        WebElement txtfield = $(By.xpath("//div[contains(text(),'Select...')]"));
        txtfield.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dx-item-content dx-list-item-content'][normalize-space()='0000001 - Josh']")));
        WebElement routeOption = $(By.xpath("//div[@class='dx-item-content dx-list-item-content'][normalize-space()='0000001 - Josh']")); // Replace 'Customer Name' with the actual name
        routeOption.click();

    }
    public void SelectProduct(String Product) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//
//        WebElement ClicktxtProduct = $(By.xpath("//select[@title='Product']"));
//        ClicktxtProduct.click();Thread.sleep(1000);


        Thread.sleep(1000);
        WebElement ClicktxtProduct = $(By.xpath("//select[@title='Product']"));
        // //select[@title='DeliveryType']
//        WebElement dropList1 = $(By.xpath(ClickDropListRouteXpath));
        Select selectObjectP = new Select(ClicktxtProduct);
        selectObjectP.selectByValue("5");;
    }

    public void EnterProductDesc(String ProductDesc) throws InterruptedException {
       // Thread.sleep(1000);
        $(By.xpath(ProductDesXpath)).sendKeys("CleanTests");
    }

    public void SelectDeliveryType(String DelType) throws InterruptedException {
        //Thread.sleep(1000);
        WebElement dropList1 = $(By.xpath(SelectDelTypeXpath));
        Select selectObjectD = new Select(dropList1);
        selectObjectD.selectByValue("6");;
    }

    public void EnterQuantity(String qty) throws InterruptedException {
        //Thread.sleep(1000);
        WebElement textField = $(By.xpath(QTYXpath)); // replace with the actual locator

        // Click on the text field
        textField.click();

        // Clear any existing text in the field
        textField.clear();

        // Send keys to the textfield3

        textField.sendKeys("20");

//        $(By.xpath(QTYXpath)).sendKeys("20");
    }

//    public void EnterCollDate(String CollDate){
//        $(By.xpath(CollectionDAteXpath)).sendKeys("2024-11-08");
//    }
//
//    public void EnterDeliveryDate(String DelDate){
//        $(By.xpath(DeliveryDateXpath)).sendKeys("2024-11-09");
//    }

    public void EnterSlotTime(String SlotTime){
       Web $(By.xpath(SlotTimeXpath)).sendKeys("00:00");
    }

    public void ClickSaveButton(){
       WebElement SaveButton01 =  $(By.xpath(SaveButtonXpath));
       SaveButton01.click();
    }
    public void CLICKEDIT(){
      WebElement clicedit01 = $(By.xpath(editOrder));
      clicedit01.click();
    }

    public void AuthClick(){
        $(By.xpath("//*[@id=\"uberForm\"]/section[1]/div/input[1]")).click();
    }





}

