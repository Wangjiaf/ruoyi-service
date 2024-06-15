package com.ruoyi.service.service;

import java.util.List;

import com.ruoyi.service.domain.PresentMoneyHis;

/**
 * 礼金历史记录Service接口
 * @author ruoyi
 * @date 2024-06-15
 */
public interface IPresentMoneyHisService {

    /**
     * 查询礼金历史记录
     * @param id 礼金历史记录主键
     * @return 礼金历史记录
     */
    public PresentMoneyHis selectPresentMoneyHisById(Long id);

    /**
     * 查询礼金历史记录列表
     * @param presentMoneyHis 礼金历史记录
     * @return 礼金历史记录集合
     */
    public List<PresentMoneyHis> selectPresentMoneyHisList(PresentMoneyHis presentMoneyHis);

    /**
     * 新增礼金历史记录
     * @param presentMoneyHis 礼金历史记录
     * @return 结果
     */
    public int insertPresentMoneyHis(PresentMoneyHis presentMoneyHis);

    /**
     * 修改礼金历史记录
     * @param presentMoneyHis 礼金历史记录
     * @return 结果
     */
    public int updatePresentMoneyHis(PresentMoneyHis presentMoneyHis);

    /**
     * 批量删除礼金历史记录
     * @param ids 需要删除的礼金历史记录主键集合
     * @return 结果
     */
    public int deletePresentMoneyHisByIds(Long[] ids);

    /**
     * 删除礼金历史记录信息
     * @param id 礼金历史记录主键
     * @return 结果
     */
    public int deletePresentMoneyHisById(Long id);

}
