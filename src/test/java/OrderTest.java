import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {

    @Test
    void shouldConfirmOrder() {
        open("http://localhost:9999");
        SelenideElement form = $("form form_size_m form_theme_alfa-on-white");
        form.$("[data-test-id=\"name\"] input").setValue("Василий Петров");
        form.$("[data-test-id=\"phone\"] input").setValue("+79118676755");
        form.$("[data-test-id=\"agreement\"]").click();
        form.$("button button_view_extra button_size_m button_theme_alfa-on-white").click();
        form.$(".order-success").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
