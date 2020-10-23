package targSoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import targSoft.dto.MerchantAndDateDto;
import targSoft.dto.TransactionAvgDto;
import targSoft.dto.TransactionDto;
import targSoft.service.SecondPageService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SecondPageController {

    private SecondPageService secondPageService;

    @Autowired
    public SecondPageController(SecondPageService secondPageService) {
        this.secondPageService = secondPageService;
    }

    @RequestMapping(value = "/secondPage", method = RequestMethod.GET)
    public ModelAndView showSecondPage (ModelAndView modelAndView, MerchantAndDateDto merchantAndDateDto) {
        modelAndView.addObject("merchantAndDateDto", merchantAndDateDto);
        modelAndView.addObject("showTable", false);
        modelAndView.addObject("showNothing", false);
        modelAndView.setViewName("secondPage");
        return modelAndView;
    }

    @RequestMapping(value = "/secondPage", method = RequestMethod.POST)
    public ModelAndView getMerchantAndAvg (ModelAndView modelAndView, @Valid MerchantAndDateDto merchantAndDateDto,
                                           BindingResult bindingResult) {

        modelAndView.setViewName("secondPage");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        TransactionAvgDto transactionAvgDto = secondPageService.getTransactionForSpecificMerchant(merchantAndDateDto.getDate(),
                merchantAndDateDto.getMerchant());

        if (transactionAvgDto.getTransactionDtos() == null) {
            modelAndView.addObject("showNothing", true);
            return modelAndView;
        }

        modelAndView.addObject("transaction", transactionAvgDto.getTransactionDtos());
        modelAndView.addObject("avg", transactionAvgDto.getAvg());
        modelAndView.addObject("showTable", true);
        return modelAndView;
    }
}
