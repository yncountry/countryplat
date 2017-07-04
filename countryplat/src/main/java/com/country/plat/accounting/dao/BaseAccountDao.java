package com.country.plat.accounting.dao;

import cn.gfire.base.jpa.dao.BaseRepository;
import com.country.plat.accounting.domain.BaseAccount;
import org.springframework.stereotype.Repository;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */
@Repository
public interface BaseAccountDao extends BaseRepository<BaseAccount,Long> {
}
