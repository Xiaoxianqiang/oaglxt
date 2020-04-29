/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SupplierMapper
 * Author:   abc
 * Date:     2020/4/14 15:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/14
 * @since 1.0.0
 */
@Mapper
public interface SupplierMapper {
List<Supplier> selectPage(Supplier supplier);
int deleteSupplierId(String[] array);
int insertSupplier(Supplier supplier);
int updateSupplier(Supplier supplier);
}