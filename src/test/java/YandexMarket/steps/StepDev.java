package YandexMarket.steps;

import YandexMarket.pageobjects.*;
import YandexMarket.pageobjects.YandexMarketMainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.FileWriter;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class StepDev {

    YandexMarketMainPage yandexMarketMainPage =page(YandexMarketMainPage.class);
    ResultPage resultPage = page(ResultPage.class);


    @Given("^open Yandex Market$")
    public void openYandexMarket() {
        open("https://market.yandex.ru/");

    }
    @When("^input to the search field \"([^\"]*)\"$")
    public void input_to_the_search_field(String searchModel) {
        yandexMarketMainPage.get("search_field").shouldBe(visible);
        yandexMarketMainPage.get("search_field").sendKeys(searchModel);

    }

    @And("^press on the search button$")
    public void press_on_the_search_button() {
        yandexMarketMainPage.get("search_button").shouldBe(visible);
        yandexMarketMainPage.get("search_button").click();

    }

    @Then("^number of models \"([^\"]*)\" should be displayed$")
    public void number_of_models_should_be_displayed(String searchModel)  {
        String[] tmp;
        if(resultPage.get("shownTheOneCategory").isDisplayed()){  // Если нам отобразилась одна категория товара, нажимаем на ссылку "все результаты поиска"
            resultPage.get("linkToAllResults").click();
        }
        resultPage.get("result_number").shouldBe(visible);
        String number = resultPage.get("result_number").getText(); //Извлекаем текст с результатом
        if(number.contains("найден " )){
            tmp = number.split("найден");   // Добавляем текст в массив tmp и делим текст пополам по ключевому слову "найден"
            System.out.println(searchModel + " найден"+ tmp[1] + "\n" );  // Выводим на экран текст, который расположен после слова "найден"

        }else if(number.contains("найдено " )){
            tmp = number.split("найдено");   // Добавляем текст в массив tmp и делим текст пополам по ключевому слову "найдено"
            System.out.println(searchModel + " найдено"+ tmp[1]+ "\n" );  // Выводим на экран текст, который расположен после слова "найдено"
        }else if(number.contains("Найдено " )){
            tmp = number.split("Найдено");   // Добавляем текст в массив tmp и делим текст пополам по ключевому слову "Найдено"
            System.out.println(searchModel + " найдено"+ tmp[1]+ "\n" );  // Выводим на экран текст, который расположен после слова "Найдено"
        }else{
            tmp = number.split("Найден");   // Добавляем текст в массив tmp и делим текст пополам по ключевому слову "Найден"
            System.out.println(searchModel + " найден"+ tmp[1]+ "\n" );  // // Выводим на экран текст, который расположен после слова "Найден"
        }
        try(FileWriter writer = new FileWriter("Result.txt", true))
        {
            // запись всей строки

            writer.write(searchModel + " найден"+tmp[1]+"\r\n");
            writer.close();

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
