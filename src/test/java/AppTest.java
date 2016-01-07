import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Let's play Rock, Paper, Scissors!");
  }

  @Test
    public void selectWinner() {
      goTo("http://localhost:4567");
      fillSelect("#PlayerOne").withText("Paper");
      submit(".btn");
      assertThat(pageSource()).contains("First player wins!");
    }

  @Test
    public void selectWinnerPlayer2() {
      goTo("http://localhost:4567");
      fillSelect("#PlayerOne").withText("Paper");
      fillSelect("#PlayerTwo").withText("Scissors");
      submit(".btn");
      assertThat(pageSource()).contains("Second player wins!");
    }

    @Test
      public void sameSelection() {
        goTo("http://localhost:4567");
        fillSelect("#PlayerOne").withText("Rock");
        fillSelect("#PlayerTwo").withText("Rock");
        submit(".btn");
        assertThat(pageSource()).contains("You both lose!");
      }
}
