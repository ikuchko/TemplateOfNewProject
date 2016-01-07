import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class RPSGame {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String playerOneChoice = request.queryParams("PlayerOne");
      String playerTwoChoice = request.queryParams("PlayerTwo");

      int gameResult = checkWinner(playerOneChoice, playerTwoChoice);

      model.put("res", gameResult);
      return new ModelAndView(model, layout);

      }, new VelocityTemplateEngine());
  }

  public static int checkWinner(String firstPlayerChoice, String secondPlayerChoice) {
    if (secondPlayerChoice.equals("Random!")) {
      secondPlayerChoice = randomChoice();
    }

    if ((firstPlayerChoice.equals("Rock")) && (secondPlayerChoice.equals("Scissors"))) {
      return 1;
    } else if ((firstPlayerChoice.equals("Scissors")) && (secondPlayerChoice.equals("Rock"))) {
      return 2;
    } else if ((firstPlayerChoice.equals("Rock")) && (secondPlayerChoice.equals("Paper"))) {
      return 2;
    } else if ((firstPlayerChoice.equals("Paper")) && (secondPlayerChoice.equals("Rock"))) {
      return 1;
    } else if ((firstPlayerChoice.equals("Scissors")) && (secondPlayerChoice.equals("Paper"))) {
      return 1;
    } else if ((firstPlayerChoice.equals("Paper")) && (secondPlayerChoice.equals("Scissors"))) {
      return 2;
    } else {
      return 0;
    }
  }
  public static String randomChoice() {
    Random randomChoice = new Random();
    switch (randomChoice.nextInt(3)) {
      case 0: return "Rock";
      case 1: return "Paper";
      case 2: return "Scissors";
    }
    return "";
  }
}
