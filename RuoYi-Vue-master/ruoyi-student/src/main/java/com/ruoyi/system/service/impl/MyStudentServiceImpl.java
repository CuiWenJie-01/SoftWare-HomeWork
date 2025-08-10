package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MyStudentMapper;
import com.ruoyi.system.domain.MyStudent;
import com.ruoyi.system.service.IMyStudentService;

/**
 * 学生信息管理Service业务层处理
 * 
 * @author cwj
 * @date 2025-08-09
 */
@Service
public class MyStudentServiceImpl implements IMyStudentService 
{
    @Autowired
    private MyStudentMapper myStudentMapper;

    /**
     * 查询学生信息管理
     * 
     * @param id 学生信息管理主键
     * @return 学生信息管理
     */
    @Override
    public MyStudent selectMyStudentById(Long id)
    {
        return myStudentMapper.selectMyStudentById(id);
    }

    /**
     * 查询学生信息管理列表
     * 
     * @param myStudent 学生信息管理
     * @return 学生信息管理
     */
    @Override
    public List<MyStudent> selectMyStudentList(MyStudent myStudent)
    {
        return myStudentMapper.selectMyStudentList(myStudent);
    }

    /**
     * 新增学生信息管理
     * 
     * @param myStudent 学生信息管理
     * @return 结果
     */
    @Override
    public int insertMyStudent(MyStudent myStudent)
    {
        return myStudentMapper.insertMyStudent(myStudent);
    }

    /**
     * 修改学生信息管理
     * 
     * @param myStudent 学生信息管理
     * @return 结果
     */
    @Override
    public int updateMyStudent(MyStudent myStudent)
    {
        return myStudentMapper.updateMyStudent(myStudent);
    }

    /**
     * 批量删除学生信息管理
     * 
     * @param ids 需要删除的学生信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMyStudentByIds(Long[] ids)
    {
        return myStudentMapper.deleteMyStudentByIds(ids);
    }

    /**
     * 删除学生信息管理信息
     * 
     * @param id 学生信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMyStudentById(Long id)
    {
        return myStudentMapper.deleteMyStudentById(id);
    }
}
