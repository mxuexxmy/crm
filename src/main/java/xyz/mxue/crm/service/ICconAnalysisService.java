package xyz.mxue.crm.service;

import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.model.conNumberResult;

import java.util.List;

public interface ICconAnalysisService {
    List<conNumberResult> numberAnalyze();

    List<Contract> conAmount();
}
