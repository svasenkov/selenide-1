package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import resources.Credentials;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class BuyDellParts {
    @Test
    void buySomePartsForDellLaptop() throws Exception {
        //open dell.com
        open("https://www.dell.com/en-us");

        //find search field, and fill with laptop model
        $(By.className("mh-search-input"))
                .setValue(Credentials.getNoteBookModel());
        $(By.className("mh-search-button-label")).click();

        // we can select needeed parts, depending on request input
        if (Credentials.getNoteBooksNeededPart()
                .equals("Battery")) { selectCheckboxBattery();
        } else if (Credentials.getNoteBooksNeededPart()
                .equals("Power Adapter")) { selectCheckboxPowerAdapter();
        } else {
            throw new Exception(Credentials.getNoteBooksNeededPart() + " wasn't find");
        }
    }

    //method which select battery checkbox
    static void selectCheckboxBattery() {
        try {
            $(By.xpath("//span[contains(text(),'Notebook Battery')]")).shouldBe(visible).click();
            $(By.partialLinkText("Battery")).click();
            $(By.partialLinkText("Add to Ca")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Credentials.getNoteBooksNeededPart() +
                    " part for laptop is absent");
        }
    }

    //method which select AC power adapter checkbox
    static void selectCheckboxPowerAdapter() {
        try {
            $(By.xpath("//span[contains(text(),'Power Adapter')]")).shouldBe(visible).click();
            $(By.partialLinkText("AC Adapter")).click();
            $(By.partialLinkText("Add to Ca")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Credentials.getNoteBooksNeededPart() +
                    " part for laptop is absent");
        }
    }
}
