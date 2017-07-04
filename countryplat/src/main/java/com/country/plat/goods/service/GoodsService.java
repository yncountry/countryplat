package com.country.plat.goods.service;

import cn.gfire.base.jpa.service.BaseService;
import com.country.plat.goods.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wust
 * @date 2017/5/24
 * @vsrsion
 * @desc
 */
@Service
public class GoodsService extends BaseService<Goods,Long> {

    public List<Goods> queryGoodsByIds(Long[] goodsIds) {
        List<Goods> list =  new ArrayList<>();
        for (Long id:goodsIds){
            list.add(findOne(id).get());
        }
        return list;
    }
}
