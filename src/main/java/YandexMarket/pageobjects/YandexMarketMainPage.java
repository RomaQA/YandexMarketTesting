package YandexMarket.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/*
Здесь определяются локаторы для главной страницы яндекс.маркета
 */
public class YandexMarketMainPage extends AbstractPage {
    @NameOfElement("search_button")                  // задаем имя, через которое будет обращаться к локатору в StepDev классе.
    @FindBy(xpath = "//button[@type='submit']")      // сам локатор
    public SelenideElement searchButton;

    @NameOfElement("search_field")
    @FindBy(id = "header-search")
    public SelenideElement searchField;
}