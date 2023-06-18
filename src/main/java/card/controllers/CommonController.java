package card.controllers;
import card.services.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    @Autowired
    private MailSendService mailSendService;

    @GetMapping(path = "/main")
    public String card(){
        return"card";
    }

    @GetMapping(path = "/about")
    public String about(){
        return"about";
    }

    @GetMapping(path = "/contact")
    public String contact(){
        return"contact";
    }

    @PostMapping(path = "/contact")
    public String processContactForm(@RequestParam("pattern") String message) {
        mailSendService.sendMail(message);
        return "redirect:/contact";
    }
}
