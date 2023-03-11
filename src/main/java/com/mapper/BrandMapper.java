package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * SELECT ALL
     * @return List
     */
    List<Brand> selectAll();

    /**
     * SELECT BY ID
     * @return Brand
     */
    Brand selectById(int id);

    /**
     * select by condition
     * @return List
     */
    List<Brand> selectByCondition(@Param("status") Integer status, @Param("companyName") String companyName,
                                         @Param("brandName") String brandName);
    List<Brand> selectByConditionSingle(Brand brand);
    void insertAll (Brand brand);
    int update (Brand brand);
    int deleteById(int id);
    int deleteByIds(int[] id);


}
