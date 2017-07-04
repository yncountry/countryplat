package com.country.plat.goods.query;

import cn.gfire.base.jpa.dao.query.BaseWordQuery;
import cn.gfire.base.jpa.dao.query.MatchType;
import cn.gfire.base.jpa.dao.query.QueryWord;
import com.country.plat.goods.domain.Goods;

/**
 * @author wust
 * @date 2017/5/24
 * @vsrsion
 * @desc
 */

public class GoodsQuery extends BaseWordQuery<Goods> {

    @QueryWord(matchType = MatchType.like)
    private String goodstitle;

    public String getGoodstitle() {
        return goodstitle;
    }

    public void setGoodstitle(String goodstitle) {
        this.goodstitle = goodstitle;
    }
}
