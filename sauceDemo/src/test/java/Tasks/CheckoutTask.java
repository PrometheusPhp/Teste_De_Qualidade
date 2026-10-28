package Tasks;

import Framework.Utils.FakersGeneration;
import PageObjects.CheckoutPage;
import Validacao.CheckoutValidacao;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private GenericValidacao genericValidacao;
    private CheckoutValidacao checkoutValidacao;
    private FakersGeneration fakersGeneration;

    public CheckoutTask (WebDriver driver){

        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        checkoutValidacao = new CheckoutValidacao(this.driver);
        fakersGeneration = new FakersGeneration();
    }

    public void preencherCheckout() throws InterruptedException {

        genericValidacao.validationTitlePages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys(fakersGeneration.getFisrtName());
        Thread.sleep(1000);
        checkoutPage.getLastNameInput().sendKeys(fakersGeneration.getLastName());
        Thread.sleep(1000);
        checkoutPage.getZipCodeInput().sendKeys(fakersGeneration.getZipCode());
        Thread.sleep(1000);
        checkoutValidacao.validaForm();
        checkoutPage.getContinueButton().click();
        genericValidacao.validationTitlePages("Checkout: Overview");
        genericValidacao.validationProduto();


    }
}
