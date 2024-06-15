package com.ruoyi.service.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.PresentMoneyMapper;
import com.ruoyi.service.domain.PresentMoney;
import com.ruoyi.service.service.IPresentMoneyService;

/**
 * 礼金汇总Service业务层处理
 * @author ruoyi
 * @date 2024-06-15
 */
@Service
public class PresentMoneyServiceImpl implements IPresentMoneyService {

    @Autowired
    private PresentMoneyMapper presentMoneyMapper;

    /**
     * 查询礼金汇总
     * @param id 礼金汇总主键
     * @return 礼金汇总
     */
    @Override
    public PresentMoney selectPresentMoneyById(Long id) {
        return presentMoneyMapper.selectPresentMoneyById(id);
    }

    /**
     * 查询礼金汇总列表
     * @param presentMoney 礼金汇总
     * @return 礼金汇总
     */
    @Override
    public List<PresentMoney> selectPresentMoneyList(PresentMoney presentMoney) {
        return presentMoneyMapper.selectPresentMoneyList(presentMoney);
    }

    /**
     * 新增礼金汇总
     * @param presentMoney 礼金汇总
     * @return 结果
     */
    @Override
    public int insertPresentMoney(PresentMoney presentMoney) {
        Date nowDate = DateUtils.getNowDate();
        String user = SecurityUtils.getUser();
        presentMoney.setCreateBy(user);
        presentMoney.setCreateTime(nowDate);
        presentMoney.setUpdateBy(user);
        presentMoney.setUpdateTime(nowDate);
        return presentMoneyMapper.insertPresentMoney(presentMoney);
    }

    /**
     * 修改礼金汇总
     * @param presentMoney 礼金汇总
     * @return 结果
     */
    @Override
    public int updatePresentMoney(PresentMoney presentMoney) {
        presentMoney.setUpdateBy(SecurityUtils.getUser());
        presentMoney.setUpdateTime(DateUtils.getNowDate());
        return presentMoneyMapper.updatePresentMoney(presentMoney);
    }

    /**
     * 批量删除礼金汇总
     * @param ids 需要删除的礼金汇总主键
     * @return 结果
     */
    @Override
    public int deletePresentMoneyByIds(Long[] ids) {
        return presentMoneyMapper.deletePresentMoneyByIds(ids);
    }

    /**
     * 删除礼金汇总信息
     * @param id 礼金汇总主键
     * @return 结果
     */
    @Override
    public int deletePresentMoneyById(Long id) {
        return presentMoneyMapper.deletePresentMoneyById(id);
    }

}
