package com.lsp.helloworld.dao;

import com.lsp.helloworld.entity.LOrderInfo;
import com.lsp.helloworld.entity.LOrderInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LOrderInfoDao {
    int countByExample(LOrderInfoExample example);

    int deleteByExample(LOrderInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LOrderInfo record);

    int insertSelective(LOrderInfo record);

    List<LOrderInfo> selectByExampleWithBLOBs(LOrderInfoExample example);

    List<LOrderInfo> selectByExample(LOrderInfoExample example);

    LOrderInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LOrderInfo record, @Param("example") LOrderInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") LOrderInfo record, @Param("example") LOrderInfoExample example);

    int updateByExample(@Param("record") LOrderInfo record, @Param("example") LOrderInfoExample example);

    int updateByPrimaryKeySelective(LOrderInfo record);

    int updateByPrimaryKeyWithBLOBs(LOrderInfo record);

    int updateByPrimaryKey(LOrderInfo record);
}