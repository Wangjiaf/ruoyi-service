package com.ruoyi.service.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.service.domain.PresentMoney;
import com.ruoyi.service.service.IPresentMoneyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 礼金汇总Controller
 * @author ruoyi
 * @date 2024-06-15
 */
@RestController
@RequestMapping("/service/presentMoney")
public class PresentMoneyController extends BaseController {

    @Autowired
    private IPresentMoneyService presentMoneyService;

    /**
     * 查询礼金汇总列表
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoney:list')")
    @GetMapping("/list")
    public TableDataInfo list(PresentMoney presentMoney) {
        startPage();
        List<PresentMoney> list = presentMoneyService.selectPresentMoneyList(presentMoney);
        return getDataTable(list);
    }

    /**
     * 导出礼金汇总列表
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoney:export')")
    @Log(title = "礼金汇总", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PresentMoney presentMoney) {
        List<PresentMoney> list = presentMoneyService.selectPresentMoneyList(presentMoney);
        ExcelUtil<PresentMoney> util = new ExcelUtil<PresentMoney>(PresentMoney.class);
        util.exportExcel(response, list, "礼金汇总数据");
    }

    /**
     * 获取礼金汇总详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoney:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(presentMoneyService.selectPresentMoneyById(id));
    }

    /**
     * 新增礼金汇总
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoney:add')")
    @Log(title = "礼金汇总", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PresentMoney presentMoney) {
        return toAjax(presentMoneyService.insertPresentMoney(presentMoney));
    }

    /**
     * 修改礼金汇总
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoney:edit')")
    @Log(title = "礼金汇总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PresentMoney presentMoney) {
        return toAjax(presentMoneyService.updatePresentMoney(presentMoney));
    }

    /**
     * 删除礼金汇总
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoney:remove')")
    @Log(title = "礼金汇总", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(presentMoneyService.deletePresentMoneyByIds(ids));
    }

}
