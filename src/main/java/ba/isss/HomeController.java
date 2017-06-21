package ba.isss;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(final Model model) {
        return "index";
    }

    @RequestMapping(value = "/prijavnilist", method = RequestMethod.GET)
    public String prijavniList() {
        return "prijavniList";
    }
    @RequestMapping(value = "/upisnilist", method = RequestMethod.GET)
    public String upisniList() {
        return "upisniList";
    }
    @RequestMapping(value = "/semestralnilist", method = RequestMethod.GET)
    public String semestralniList() {
        return "semestralni list";
    }
    @RequestMapping(value = "/statistickilist", method = RequestMethod.GET)
    public String statistickiList() {
        return "statistickiList";
    }

}
