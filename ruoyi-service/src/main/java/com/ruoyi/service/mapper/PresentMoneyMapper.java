package com.ruoyi.service.mapper;

import java.util.List;

import com.ruoyi.service.domain.PresentMoney;
import org.apache.ibatis.annotations.Mapper;

/**
 * 礼金汇总Mapper接口
 * @author ruoyi
 * @date 2024-06-15
 */
@Mapper
public interface PresentMoneyMapper {

    /**
     * 查询礼金汇总
     * @param id 礼金汇总主键
     * @return 礼金汇总
     */
    public PresentMoney selectPresentMoneyById(Long id);

    /**
     * 查询礼金汇总列表
     * @param presentMoney 礼金汇总
     * @return 礼金汇总集合
     */
    public List<PresentMoney> selectPresentMoneyList(PresentMoney presentMoney);

    /**
     * 新增礼金汇总
     * @param presentMoney 礼金汇总
     * @return 结果
     */
    public int insertPresentMoney(PresentMoney presentMoney);

    /**
     * 修改礼金汇总
     * @param presentMoney 礼金汇总
     * @return 结果
     */
    public int updatePresentMoney(PresentMoney presentMoney);

    /**
     * 删除礼金汇总
     * @param id 礼金汇总主键
     * @return 结果
     */
    public int deletePresentMoneyById(Long id);

    /**
     * 批量删除礼金汇总
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePresentMoneyByIds(Long[] ids);

}
