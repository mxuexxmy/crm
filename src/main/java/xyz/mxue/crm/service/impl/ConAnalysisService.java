package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.mapper.conAnalysisMapper;
import xyz.mxue.crm.model.conNumberResult;
import xyz.mxue.crm.service.ICconAnalysisService;

import java.util.List;

@Service
public class ConAnalysisService implements ICconAnalysisService {
    @Autowired
    private conAnalysisMapper mapper;

    @Override
    public List<conNumberResult> numberAnalyze() {
        return mapper.numberAnalyze();
    }

    @Override
    public List<Contract> conAmount() {
        return mapper.conAmount();
    }
}
