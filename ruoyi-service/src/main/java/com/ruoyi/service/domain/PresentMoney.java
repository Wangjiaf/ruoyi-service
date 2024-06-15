package com.ruoyi.service.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 礼金汇总对象 present_money
 * @author ruoyi
 * @date 2024-06-15
 */
@Data
public class PresentMoney extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @Excel(name = "主键ID")
    private Long id;

    /** 删除标识 */
    private String delFlag;

    /** 礼金人 */
    @Excel(name = "礼金人")
    private String presentUser;

    /** 礼金(正数为欠礼金人金额，负数为礼金人应返还金额) */
    @Excel(name = "礼金", cellType = Excel.ColumnType.NUMERIC)
    private Double presentMoney;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("presentUser", getPresentUser())
                .append("presentMoney", getPresentMoney())
                .toString();
    }

}
