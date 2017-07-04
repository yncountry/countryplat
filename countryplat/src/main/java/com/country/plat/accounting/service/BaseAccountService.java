package com.country.plat.accounting.service;

import cn.gfire.base.jpa.service.BaseService;
import com.country.plat.accounting.domain.BaseAccount;
import org.springframework.stereotype.Service;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */
@Service
public class BaseAccountService extends BaseService<BaseAccount,Long> {

    private String SUCCESS="success";

    /**
     * 完成资金入账
     * @param account  账户类型
     * @param totalFee 总资金 只做加法
     * @return
     */
    public String fundsCredited(BaseAccount account,Double totalFee){
        BaseAccount baseAccount = findOne(account.getId()).get();
        baseAccount.setTotalfund(baseAccount.getTotalfund()+totalFee);
        save(baseAccount);
        return SUCCESS;
    }
}
