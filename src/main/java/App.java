import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/resume", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Resume> resumes = request.session().attribute("resumes");
      if (resumes == null) {
        resumes = new ArrayList<Resume>();
        request.session().attribute("resumes", resumes);
      }
      String position = request.queryParams("position");
      String company = request.queryParams("company");
      String location = request.queryParams("location");
      String description = request.queryParams("description");
      String date = request.queryParams("date");
      Resume newResume = new Resume(position, company, location, description, date);
      resumes.add(newResume);
      model.put("resumes", request.session().attribute("resumes"));
      model.put("template", "templates/resumeList.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
