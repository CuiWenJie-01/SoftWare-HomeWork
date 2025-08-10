package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MyStudent;

/**
 * 学生信息管理Service接口
 * 
 * @author cwj
 * @date 2025-08-09
 */
public interface IMyStudentService 
{
    /**
     * 查询学生信息管理
     * 
     * @param id 学生信息管理主键
     * @return 学生信息管理
     */
    public MyStudent selectMyStudentById(Long id);

    /**
     * 查询学生信息管理列表
     * 
     * @param myStudent 学生信息管理
     * @return 学生信息管理集合
     */
    public List<MyStudent> selectMyStudentList(MyStudent myStudent);

    /**
     * 新增学生信息管理
     * 
     * @param myStudent 学生信息管理
     * @return 结果
     */
    public int insertMyStudent(MyStudent myStudent);

    /**
     * 修改学生信息管理
     * 
     * @param myStudent 学生信息管理
     * @return 结果
     */
    public int updateMyStudent(MyStudent myStudent);

    /**
     * 批量删除学生信息管理
     * 
     * @param ids 需要删除的学生信息管理主键集合
     * @return 结果
     */
    public int deleteMyStudentByIds(Long[] ids);

    /**
     * 删除学生信息管理信息
     * 
     * @param id 学生信息管理主键
     * @return 结果
     */
    public int deleteMyStudentById(Long id);
}
