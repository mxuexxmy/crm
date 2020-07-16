package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.model.ConMoneyResult;
import xyz.mxue.crm.model.conNumberResult;
import xyz.mxue.crm.service.ICconAnalysisService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ConNumberController")
public class ConAnalysisController {

    @Autowired
    private ICconAnalysisService service;


    @RequestMapping("/tonumberanalyze")
    public String toNumberAnalyze(){
        return "conanalysis/numberanalyze";
    }

    @RequestMapping("/numberanalyze")
    @ResponseBody
    public List<conNumberResult> numberAnalyze(){
        List<conNumberResult> results =  service.numberAnalyze();
        return results;
    }


    @RequestMapping("/toconamount")
    public String toconamount(){
        return "conanalysis/conamount";
    }


    @RequestMapping(value = "/conamount", method = RequestMethod.GET)
    @ResponseBody
    public List<ConMoneyResult> conAmount(){
        List<Contract> list =  service.conAmount();
        Integer[] money = new Integer[10];
        for (int i = 0; i < 10; i++) money[i] = 0;
        String[] moneyName = {"10万以下", "10万至20万", "20万至30万", "30万至40万", "40万至50万", "50万以上"};

        for (Contract contract : list) {
            double d  = contract.getConAmount();
            if (d < 100000.0) {
                money[0] = money[0] + 1;
            } else if(d < 200000.0) {
                money[1] = money[1] + 1;
            } else if (d < 300000.0) {
                money[2] = money[2] + 1;
            } else if(d < 400000.0) {
                money[3] = money[3] + 1;
            } else if (d < 500000.) {
                money[4] = money[4] + 1;
            } else {
                money[5] = money[5] + 1;
            }
        }

        List<ConMoneyResult> results = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ConMoneyResult conMoneyResult = new ConMoneyResult();
            if (money[i] != 0) {
                conMoneyResult.setValue(money[i]);
                conMoneyResult.setName(moneyName[i]);
                results.add(conMoneyResult);
            }
        }


        return results;
    }
}
