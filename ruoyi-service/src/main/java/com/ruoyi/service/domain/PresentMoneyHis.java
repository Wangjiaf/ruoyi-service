package com.ruoyi.service.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 礼金历史记录对象 present_money_his
 * @author ruoyi
 * @date 2024-06-15
 */
@Data
public class PresentMoneyHis extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @Excel(name = "主键ID")
    private Long id;

    /** 删除标识 */
    private String delFlag;

    /** 办事日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "办事日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eventTime;

    /** 办事名称 */
    @Excel(name = "办事名称")
    private String eventName;

    /** 礼金支付方式 */
    @Excel(name = "礼金支付方式", readConverterExp = "10=微信,20=现金,9999=其它")
    private String presentType;

    /** 礼金人 */
    @Excel(name = "礼金人")
    private String presentUser;

    /** 礼金金额 */
    @Excel(name = "礼金金额")
    private Double presentMoney;

    /** 礼金汇总表ID */
    private String presentMoneyId;

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
                .append("eventTime", getEventTime())
                .append("eventName", getEventName())
                .append("presentType", getPresentType())
                .append("presentUser", getPresentUser())
                .append("presentMoney", getPresentMoney())
                .append("presentMoneyId", getPresentMoneyId())
                .toString();
    }

}
