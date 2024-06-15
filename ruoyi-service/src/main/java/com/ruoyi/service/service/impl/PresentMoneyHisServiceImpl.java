package com.ruoyi.service.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.service.domain.PresentMoney;
import com.ruoyi.service.service.IPresentMoneyHisService;
import com.ruoyi.service.service.IPresentMoneyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.PresentMoneyHisMapper;
import com.ruoyi.service.domain.PresentMoneyHis;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;

/**
 * 礼金历史记录Service业务层处理
 * @author ruoyi
 * @date 2024-06-15
 */
@Service
public class PresentMoneyHisServiceImpl implements IPresentMoneyHisService {

    @Autowired
    private PresentMoneyHisMapper presentMoneyHisMapper;

    @Autowired
    private IPresentMoneyService presentMoneyService;

    private PresentMoneyHisServiceImpl thisBean;

    @PostConstruct
    private void init() {
        thisBean = SpringUtils.getBean(PresentMoneyHisServiceImpl.class);
    }

    /**
     * 查询礼金历史记录
     * @param id 礼金历史记录主键
     * @return 礼金历史记录
     */
    @Override
    public PresentMoneyHis selectPresentMoneyHisById(Long id) {
        return presentMoneyHisMapper.selectPresentMoneyHisById(id);
    }

    /**
     * 查询礼金历史记录列表
     * @param presentMoneyHis 礼金历史记录
     * @return 礼金历史记录
     */
    @Override
    public List<PresentMoneyHis> selectPresentMoneyHisList(PresentMoneyHis presentMoneyHis) {
        return presentMoneyHisMapper.selectPresentMoneyHisList(presentMoneyHis);
    }

    /**
     * 新增礼金历史记录
     * @param presentMoneyHis 礼金历史记录
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPresentMoneyHis(PresentMoneyHis presentMoneyHis) {
        Date nowDate = DateUtils.getNowDate();
        String user = SecurityUtils.getUser();
        presentMoneyHis.setCreateBy(user);
        presentMoneyHis.setCreateTime(nowDate);
        presentMoneyHis.setUpdateBy(user);
        presentMoneyHis.setUpdateTime(nowDate);
        thisBean.calculatePresentMoney(presentMoneyHis);
        return presentMoneyHisMapper.insertPresentMoneyHis(presentMoneyHis);
    }

    /**
     * 修改礼金历史记录
     * @param presentMoneyHis 礼金历史记录
     * @return 结果
     */
    @Override
    public int updatePresentMoneyHis(PresentMoneyHis presentMoneyHis) {
        presentMoneyHis.setUpdateBy(SecurityUtils.getUser());
        presentMoneyHis.setUpdateTime(DateUtils.getNowDate());
        return presentMoneyHisMapper.updatePresentMoneyHis(presentMoneyHis);
    }

    /**
     * 批量删除礼金历史记录
     * @param ids 需要删除的礼金历史记录主键
     * @return 结果
     */
    @Override
    public int deletePresentMoneyHisByIds(Long[] ids) {
        return presentMoneyHisMapper.deletePresentMoneyHisByIds(ids);
    }

    /**
     * 删除礼金历史记录信息
     * @param id 礼金历史记录主键
     * @return 结果
     */
    @Override
    public int deletePresentMoneyHisById(Long id) {
        return presentMoneyHisMapper.deletePresentMoneyHisById(id);
    }

    /**
     * 自动计算汇总金额
     * @param presentMoneyHis
     */
    public void calculatePresentMoney(PresentMoneyHis presentMoneyHis) {
        PresentMoney presentMoney = new PresentMoney();
        presentMoney.setPresentUser(presentMoneyHis.getPresentUser());
        List<PresentMoney> presentMoneyList = presentMoneyService.selectPresentMoneyList(presentMoney);
        if (CollectionUtils.isEmpty(presentMoneyList)) {
            BeanUtils.copyProperties(presentMoneyHis, presentMoney);
            presentMoney.setId(null);
            presentMoneyService.insertPresentMoney(presentMoney);
            return;
        }
        presentMoney = presentMoneyList.get(0);
        presentMoney.setPresentMoney(presentMoney.getPresentMoney() + presentMoneyHis.getPresentMoney());
        presentMoneyService.updatePresentMoney(presentMoney);
    }

}
