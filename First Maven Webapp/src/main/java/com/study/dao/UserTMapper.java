package com.study.dao;

import com.study.model.UserT;
import java.util.List;
import java.util.Map;

public interface UserTMapper {
    /**
	 * 新写入数据库记录,user_t
	 * @param userT
	 * @flysky_generated_insertSelective
	 */
	int insert(UserT userT);

	/**
	 * ,user_t
	 * @param id
	 * @flysky_generated_deleteById
	 */
	int deleteById(Integer id);

	/**
	 * ,user_t
	 * @param userT
	 * @flysky_generated_updateById
	 */
	int update(UserT userT);

	/**
	 * ,user_t
	 * @param id
	 * @flysky_generated_selectById
	 */
	UserT selectById(Integer id);

	/**
	 * ,user_t
	 * @param paras
	 * @flysky_generated_selectAll
	 */
	List<UserT> selectAll(Map<String, Object> paras);
}