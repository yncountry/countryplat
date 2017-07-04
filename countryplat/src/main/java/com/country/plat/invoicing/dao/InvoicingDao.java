package com.country.plat.invoicing.dao;

import cn.gfire.base.jpa.dao.BaseRepository;
import com.country.plat.invoicing.domain.Invoicing;
import org.springframework.stereotype.Repository;

/**
 * @author wust
 * @date 2017/5/29
 * @vsrsion
 * @desc
 */
@Repository
public interface InvoicingDao extends BaseRepository<Invoicing,Long> {
}
