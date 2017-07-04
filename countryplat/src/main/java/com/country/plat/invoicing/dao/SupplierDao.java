package com.country.plat.invoicing.dao;


import cn.gfire.base.jpa.dao.BaseRepository;
import com.country.plat.invoicing.domain.Supplier;
import org.springframework.stereotype.Repository;

/**
 * @author wust
 * @date 2017/5/26
 * @vsrsion
 * @desc
 */
@Repository
public interface SupplierDao extends BaseRepository<Supplier,Long> {
}
