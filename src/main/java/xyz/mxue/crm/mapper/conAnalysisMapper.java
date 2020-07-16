package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.model.conNumberResult;

import java.util.List;

@Mapper
public interface conAnalysisMapper {

    @Select("select con_create as date, count(*) as number from contract group by con_create")
    List<conNumberResult> numberAnalyze();
    @Select("select *  from contract")
    List<Contract> conAmount();
}
