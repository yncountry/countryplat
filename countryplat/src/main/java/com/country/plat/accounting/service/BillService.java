package com.country.plat.accounting.service;

import cn.gfire.base.jpa.service.BaseService;
import com.country.plat.accounting.domain.BaseAccount;
import com.country.plat.accounting.domain.Bill;
import com.country.plat.utils.UUIDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */

@Service
public class BillService extends BaseService<Bill,Long> {


    public String SUCCESS ="SUCCESS";

    @Resource
    private BaseAccountService baseAccountService;

    /**
     * 完成一笔记账功能
     * @param desc 账单描述
     * @param type 类型 支出，收入
     * @param baseAccount 账户类型
     * @param totalFee  交易金额
     * @return
     */
    @Transactional
    public String createBill(String desc, Integer type, BaseAccount baseAccount, Double totalFee, Integer state){
            //完成一笔记账
            Bill bill = new Bill();
            bill.setBillDesc(desc);
            bill.setBillNum(UUIDGenerator.getNumUUID());
            if(state!=null){
                bill.setBillState(state);
            }else {
                bill.setBillState(1);
            }
            bill.setBillType(type);
            bill.setBaseAccount(baseAccount);
            bill.setSumTotal(totalFee);
            Bill newBill = save(bill).get();
            Double fundCried = type==0?0.0-newBill.getSumTotal():0+newBill.getSumTotal();
            baseAccountService.fundsCredited(newBill.getBaseAccount(),fundCried);
            return SUCCESS;
    }
}
