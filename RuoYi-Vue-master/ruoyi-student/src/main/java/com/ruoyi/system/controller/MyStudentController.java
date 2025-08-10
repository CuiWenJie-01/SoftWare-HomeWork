package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.MyStudent;
import com.ruoyi.system.service.IMyStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生信息管理Controller
 * 
 * @author cwj
 * @date 2025-08-09
 */
@RestController
@RequestMapping("/system/student")
public class MyStudentController extends BaseController
{
    @Autowired
    private IMyStudentService myStudentService;

    /**
     * 查询学生信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyStudent myStudent)
    {
        startPage();
        List<MyStudent> list = myStudentService.selectMyStudentList(myStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "学生信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyStudent myStudent)
    {
        List<MyStudent> list = myStudentService.selectMyStudentList(myStudent);
        ExcelUtil<MyStudent> util = new ExcelUtil<MyStudent>(MyStudent.class);
        util.exportExcel(response, list, "学生信息管理数据");
    }

    /**
     * 获取学生信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(myStudentService.selectMyStudentById(id));
    }

    /**
     * 新增学生信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "学生信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyStudent myStudent)
    {
        return toAjax(myStudentService.insertMyStudent(myStudent));
    }

    /**
     * 修改学生信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "学生信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyStudent myStudent)
    {
        return toAjax(myStudentService.updateMyStudent(myStudent));
    }

    /**
     * 删除学生信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "学生信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(myStudentService.deleteMyStudentByIds(ids));
    }
}
