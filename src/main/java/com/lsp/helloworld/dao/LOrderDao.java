package com.lsp.helloworld.dao;

import com.lsp.helloworld.entity.LOrder;
import com.lsp.helloworld.entity.LOrderExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LOrderDao {
    int countByExample(LOrderExample example);

    int deleteByExample(LOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LOrder record);

    int insertSelective(LOrder record);

    List<LOrder> selectByExample(LOrderExample example);

    LOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LOrder record, @Param("example") LOrderExample example);

    int updateByExample(@Param("record") LOrder record, @Param("example") LOrderExample example);

    int updateByPrimaryKeySelective(LOrder record);

    int updateByPrimaryKey(LOrder record);
}