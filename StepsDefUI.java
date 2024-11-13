package TMSStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import TMSPageObjects.TMSPage;


public class StepsDefUI extends PageObject {


    @Steps

    TMSPage tmsPage;





    @Given("Driver has launched TMS Platform")
    public void driver_has_launched_tms_platform() {
        tmsPage.TMSWebsite();
    }

    @When("Driver Captures UserName and Password")
    public void driver_captures_user_name_and_password() {
        tmsPage.LogIn("ishmael.direro@korridor.com", "WjZKlhrA");
    }

    @When("Driver click Login")
    public void driver_click_login() {
        tmsPage.Click();
    }

    @When("Click Order Button")
    public void click_order_button() throws InterruptedException {
        tmsPage.Order();
    }

    @When("Click Create Order Button")
    public void click_create_order_button() throws InterruptedException {
        tmsPage.CreateOrder();
    }
    @When("Enter {string} and {string}")
    public void enter_and(String string01, String string2) {
        tmsPage.EnterOrderId(string01);
        tmsPage.EnterPONumber(string2);
    }
    @When("Select {string}, {string}, {string}, Capture {string}, select {string} and Capture {string}")
    public void select_capture_select_and_capture(String stringD, String stringW, String string3, String string4, String string5, String string6) throws InterruptedException {
        tmsPage.SelectCustomer();
        tmsPage.SelectRoute();
        tmsPage.SelectProduct(string3);
        tmsPage.EnterProductDesc(string4);
        tmsPage.SelectDeliveryType(string5);
        tmsPage.EnterQuantity(string6);
    }
    @When("Enter {string}")
    public void enter_and(String string9 ){
//        tmsPage.EnterCollDate(string7);
//        tmsPage.EnterDeliveryDate(string8);
        tmsPage.EnterSlotTime(string9);
    }
    @Then("Click SaveButton")
    public void click_save_button() {
        tmsPage.ClickSaveButton();
    }
//    @And("clickeditbutton")
//    public void edit(){
//        tmsPage.Click();
//    }


    @And("Click Edit Button")
    public void clickEditButton() {
        tmsPage.CLICKEDIT();
    }
//    @Then("Authorize")
//    public void Authorize(){
//
//    }

    @And("Click Auth Button")
    public void clickAuthButton() {
        tmsPage.AuthClick();
    }
}
