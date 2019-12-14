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
        //SelenideElement form = $("form form_size_m form_theme_alfa-on-white");
        $("[data-test-id=\"name\"] input").setValue("Василий Петров");
        $("[data-test-id=\"phone\"] input").setValue("+79118676755");
        $("[data-test-id=\"agreement\"]").click();
        $(byText("Продолжить")).click();
        $(byText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.")).shouldBe(visible);
    }
}
