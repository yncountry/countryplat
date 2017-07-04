package com.country.plat.goods.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseDataResponse;
import cn.gfire.base.mvc.form.BaseForm;
import cn.gfire.base.mvc.utils.OptionalUtils;
import com.country.common.emmun.UnitType;
import com.country.plat.goods.domain.Goods;
import com.country.plat.goods.form.GoodsForm;
import com.country.plat.goods.query.GoodsQuery;
import com.country.utils.FileOpUtils;
import com.country.utils.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;

/**
 * @author wust
 * @date 2017/5/24
 * @vsrsion
 * @desc
 */
@Controller
@RequestMapping("goods")
@ConfigurationProperties(prefix = "com.country")
public class GoodsController extends CrudController<Goods,Long> {

    private String ADD_URL ="goods/add";
    private String LIST_URL="goods/list";
    private String DETIAL_URL="goods/detial";
    private String gooImgePaht;

    @GetMapping("add")
    public String add(Model model) {
        super.add(model);
        model.addAttribute("UnitType", OptionalUtils.getOptional(UnitType.class));
       return  ADD_URL;
    }

    @PostMapping("add")
    @ResponseBody
    public BaseDataResponse add(@Valid GoodsForm form, BindingResult bindingResult) {
        form.setGoodImages(getGoodImages());
        super.add(form, bindingResult);
        return BaseDataResponse.ok().jumpUrl(LIST_URL);
    }

    @GetMapping("edit")
    public String edit(Model model,Long id){
       model.addAttribute("form",service.findOne(id).get());
        model.addAttribute("UnitType", OptionalUtils.getOptional(UnitType.class));
        return ADD_URL;
    }

    @PostMapping("edit")
    @ResponseBody
    public BaseDataResponse edit(Model model,GoodsForm form){
        Goods goods = service.findOne(form.getId()).get();
        form.setGoodImages(getGoodImages());
        Goods newGoods = form.as();
        if(StringUtils.isNullData(newGoods.getMainImage_1())){
            newGoods.setMainImage_1(goods.getMainImage_1());
        }
        if(StringUtils.isNullData(newGoods.getMainImage_2())){
            newGoods.setMainImage_2(goods.getMainImage_2());
        }
        if(StringUtils.isNullData(newGoods.getMainImage_3())){
            newGoods.setMainImage_3(goods.getMainImage_3());
        }
//        newGoods.setSuppliers(goods.getSuppliers());
        service.save(newGoods);

        return BaseDataResponse.ok().jumpUrl(LIST_URL);
    }

    @RequestMapping("list")
    public String list(Model model, GoodsQuery query) {
        String list = super.list(model, query);
        return list;
    }

    @GetMapping("detial")
    public String detial(Model model,Long goodsId,Integer page){
      model.addAttribute("form",service.findOne(goodsId).get());
      model.addAttribute("page",page);
      return DETIAL_URL;
    }

   @RequestMapping("showGoodsPhoto")
    public  void showGoodsPhoto(HttpServletResponse response,Long goodsId,String type) throws Exception{
       Goods goods=null;
        if(goodsId!=null){
             goods= service.findOne(goodsId).get();
        }
        File noFile = new File(gooImgePaht+"/main/noimg.jpg");
        switch (type){
            case "main":
                if(goods!=null &&!StringUtils.isNullData(goods.getMainImage_1())){
                    FileOpUtils.downFile(response,new File(goods.getMainImage_1()),"demo");
                }else {
                    FileOpUtils.downFile(response,noFile,"demo");
                };break;
            case "guige":
                if(goods!=null &&!StringUtils.isNullData(goods.getMainImage_2())){
                    FileOpUtils.downFile(response,new File(goods.getMainImage_2()),"demo");
                }else {
                    FileOpUtils.downFile(response,noFile,"demo");
                };break;
            case "detial":
                if(goods!=null &&!StringUtils.isNullData(goods.getMainImage_3())){
                    FileOpUtils.downFile(response,new File(goods.getMainImage_3()),"demo");
                }else {
                    FileOpUtils.downFile(response,noFile,"demo");
                };break;
        }
    }


    public String getGoodImages() {
        return gooImgePaht+"/main";
    }

    public String getGooImgePaht() {
        return gooImgePaht;
    }

    public void setGooImgePaht(String gooImgePaht) {
        this.gooImgePaht = gooImgePaht;
    }

    @Override
    protected String getListUrl() {
        return LIST_URL;
    }

    @Override
    protected String getFormUrl() {
        return LIST_URL;
    }

    @Override
    protected BaseForm<Goods, Long> getBlankForm() {
        return new GoodsForm();
    }

    @Override
    protected BaseForm<Goods, Long> getForm(Goods goods) {
        return new GoodsForm();
    }
}

