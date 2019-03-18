package YandexMarket.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/*
Здесь определяются локаторы для страницы на которой отображуются результаты поиска
 */
public class ResultPage extends AbstractPage {
    @NameOfElement("result_number")        // задаем имя, через которое будет обращаться к локатору в StepDev классе.
    @FindBy(css = "._2RLgCXPGjS")          // сам локатор
    public SelenideElement resultNumber;

    @NameOfElement("linkToAllResults")
    @FindBy(linkText = "все результаты поиска")
    public SelenideElement linkToAllResults;

    @NameOfElement("shownTheOneCategory")
    @FindBy(css = ".n-search-preciser__text")
    public SelenideElement shownTheOneCategory;

}
