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
import com.ruoyi.service.domain.PresentMoneyHis;
import com.ruoyi.service.service.IPresentMoneyHisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 礼金历史记录Controller
 *
 * @author ruoyi
 * @date 2024-06-15
 */
@RestController
@RequestMapping("/service/presentMoneyHis")
public class PresentMoneyHisController extends BaseController {

    @Autowired
    private IPresentMoneyHisService presentMoneyHisService;

    /**
     * 查询礼金历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoneyHis:list')")
    @GetMapping("/list")
    public TableDataInfo list(PresentMoneyHis presentMoneyHis) {
        startPage();
        List<PresentMoneyHis> list = presentMoneyHisService.selectPresentMoneyHisList(presentMoneyHis);
        return getDataTable(list);
    }

    /**
     * 导出礼金历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoneyHis:export')")
    @Log(title = "礼金历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PresentMoneyHis presentMoneyHis) {
        List<PresentMoneyHis> list = presentMoneyHisService.selectPresentMoneyHisList(presentMoneyHis);
        ExcelUtil<PresentMoneyHis> util = new ExcelUtil<PresentMoneyHis>(PresentMoneyHis.class);
        util.exportExcel(response, list, "礼金历史记录数据");
    }

    /**
     * 获取礼金历史记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoneyHis:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(presentMoneyHisService.selectPresentMoneyHisById(id));
    }

    /**
     * 新增礼金历史记录
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoneyHis:add')")
    @Log(title = "礼金历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PresentMoneyHis presentMoneyHis) {
        return toAjax(presentMoneyHisService.insertPresentMoneyHis(presentMoneyHis));
    }

    /**
     * 修改礼金历史记录
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoneyHis:edit')")
    @Log(title = "礼金历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PresentMoneyHis presentMoneyHis) {
        return toAjax(presentMoneyHisService.updatePresentMoneyHis(presentMoneyHis));
    }

    /**
     * 删除礼金历史记录
     */
    @PreAuthorize("@ss.hasPermi('service:presentMoneyHis:remove')")
    @Log(title = "礼金历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(presentMoneyHisService.deletePresentMoneyHisByIds(ids));
    }

}
