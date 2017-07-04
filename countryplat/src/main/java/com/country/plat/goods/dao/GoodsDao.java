package com.country.plat.goods.dao;

import cn.gfire.base.jpa.dao.BaseRepository;
import com.country.plat.goods.domain.Goods;
import org.springframework.stereotype.Repository;

/**
 * @author wust
 * @date 2017/5/24
 * @vsrsion
 * @desc
 */
@Repository
public interface GoodsDao extends BaseRepository<Goods,Long> {
}
