package targSoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import targSoft.dto.TransactionDto;
import targSoft.service.HomePageService;

import java.util.List;

@Controller
public class HomePageController {

    private HomePageService homePageService;

    @Autowired
    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public ModelAndView showHomePage (ModelAndView modelAndView) {
        List<TransactionDto> transactionDtos = homePageService.getAllTransaction();
        modelAndView.addObject("transaction", transactionDtos);
        modelAndView.setViewName("homePage");
        return modelAndView;
    }
}
