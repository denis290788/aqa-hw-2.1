import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {

    @Test
    void shouldConfirmOrder() {
        open("http://localhost:9999");
        $("[data-test-id=\"name\"] input").setValue("Василий Петров");
        $("[data-test-id=\"phone\"] input").setValue("+79118676755");
        $("[data-test-id=\"agreement\"]").click();
        $(byText("Продолжить")).click();
        $(byText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.")).shouldBe(visible);
    }

    @Test
    void shouldShowErrorMessage() {
        open("http://localhost:9999");
        $("[data-test-id=\"name\"] input").setValue("Иван Петров");
        $("[data-test-id=\"phone\"] input").setValue("79118676755");
        $("[data-test-id=\"agreement\"]").click();
        $(byText("Продолжить")).click();
        $(".input_invalid").shouldBe(visible);
    }
}
