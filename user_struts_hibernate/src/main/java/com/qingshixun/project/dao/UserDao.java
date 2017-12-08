package com.qingshixun.project.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.common.BaseDao;
import com.qingshixun.project.model.Page;
import com.qingshixun.project.model.UserModel;

@Repository
public class UserDao<T> {
	@Autowired
	private BaseDao baseDao;

	@SuppressWarnings("unchecked")
	public List<UserModel> getUsers() {
		return (List<UserModel>) baseDao.getHibernateTemplate().find("from  UserModel");
	}

	public Page<T> getPages(int pageNo, int pageSize) {
		int rowCount = baseDao.getHibernateTemplate().find("from UserModel").size();
		// 分页对象
		final Page<T> page = new Page<T>();
		// 页数（第几页）
		page.setPageNo(pageNo);
		// 总记录数
		page.setTotalCount(rowCount);
		// 每页显示的记录条数
		page.setPageSize(pageSize);

		// 根据pageNo取一页数据
		final int startRow = (pageNo - 1) * pageSize;
		if (pageNo * pageSize > rowCount) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) baseDao.getHibernateTemplate().find("from UserModel").subList(startRow, rowCount);
			final List<T> pageItems = page.getResult();
			for (T userModel : list) {
				pageItems.add(userModel);
			}
		} else {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) baseDao.getHibernateTemplate().find("from UserModel").subList(startRow,
					startRow + pageSize);
			final List<T> pageItems = page.getResult();
			for (T userModel : list) {
				pageItems.add(userModel);
			}
		}
		return page;
	}

	public UserModel getUser(UserModel userModel) {
		return baseDao.getHibernateTemplate().get(UserModel.class, userModel.getId());
	}

	public void deleteUserModel(UserModel userModel) {
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseDao.getHibernateTemplate().delete(userModel);
		@SuppressWarnings("unchecked")
		List<UserModel> list = (List<UserModel>) baseDao.getHibernateTemplate().find("from UserModel");
		for (UserModel userModel2 : list) {
			if (userModel2 == userModel) {
				out.print("<script language='javascript'>alert('用户信息删除失败！');window.location='userinfo';</script>");
				out.flush();
				out.close();
				System.out.println("用户信息删除失败！");
			} else {
				out.print("<script language='javascript'>alert('用户信息删除成功！');window.location='userinfo';</script>");
				out.flush();
				out.close();
				System.out.println("用户信息删除成功111！");
			}
		}
	}

	public void updateUserModel(UserModel userModel) {
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseDao.getHibernateTemplate().saveOrUpdate(userModel);
		UserModel userModel1 = baseDao.getHibernateTemplate().get(UserModel.class, userModel.getId());
		if (userModel1.getId() < 0) {
			out.print("<script language='javascript'>alert('用户信息修改失败！');window.location='userinfo';</script>");
			out.flush();
			out.close();
			System.out.println("用户信息修改失败！");
		} else {
			out.print("<script language='javascript'>alert('用户信息修改成功！');window.location='userinfo';</script>");
			out.flush();
			out.close();
			System.out.println("用户信息修改成功！");
		}
	}

	public void addUserModel(UserModel userModel) {
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseDao.getHibernateTemplate().save(userModel);
		UserModel userModel1 = baseDao.getHibernateTemplate().get(UserModel.class, userModel.getId());
		if (userModel1.getId() < 0) {
			out.print("<script language='javascript'>alert('用户信息添加失败！');window.location='userinfo';</script>");
			out.flush();
			out.close();
			System.out.println("用户信息添加失败！");
		} else {
			out.print("<script language='javascript'>alert('用户信息添加成功！');window.location='userinfo';</script>");
			out.flush();
			out.close();
			System.out.println("用户信息添加成功！");
		}
	}
	
	/**
	 * 获取根据性别分组统计数据
	 * 
	 * @return
	 */
	public List getUserGenderNumbers() {
		// 根据 gender 分组统计用户性别人数
		String hql = "select count(*) as number,sex from UserModel group by sex";
		Query query = baseDao.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 获取根据创建日期分组统计数据
	 * 
	 * @return
	 */
	public List getUserCreateDateNumbers() {
		// 根据 createTime 分组统计用户创建日期人数（ 利用 MySQL 提供的 DATE_FORMAT 函数对 createTime
		// 进行格式化）
		String hql = "select count(*) as number,DATE_FORMAT(createTime,'%Y-%m-%d') from UserModel group by DATE_FORMAT(createTime,'%Y-%m-%d')";
		Query query = baseDao.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		return query.list();
	}
	
}
