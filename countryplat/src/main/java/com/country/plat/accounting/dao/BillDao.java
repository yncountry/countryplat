package com.country.plat.accounting.dao;

import cn.gfire.base.jpa.dao.BaseRepository;
import com.country.plat.accounting.domain.Bill;
import org.springframework.stereotype.Repository;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */
@Repository
public interface BillDao extends BaseRepository<Bill,Long> {
}
