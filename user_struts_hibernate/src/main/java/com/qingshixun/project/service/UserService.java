package com.qingshixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.dao.UserDao;
import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.Page;
import com.qingshixun.project.model.UserModel;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<UserModel> getUsers() {
		return userDao.getUsers();
	}

	public UserModel getUser(UserModel userModel) {
		return userDao.getUser(userModel);
	}

	public void deleteUserModel(UserModel userModel) {
		userDao.deleteUserModel(userModel);
	}

	public void updateUserModel(UserModel userModel) {
		userDao.updateUserModel(userModel);
	}

	public void addUserModel(UserModel userModel) {
		userDao.addUserModel(userModel);
	}

	// 分页查询列表
	public Page<UserModel> findUserModelList(int pageNo, int pageSize) {
		return userDao.getPages(pageNo, pageSize);
	}

	/**
	 * 获取用户性别统计数据
	 * 
	 * @return
	 */
	public ChartData getUserGenderData() {
		// 获取根据性别分组统计数据
		List genderNumberList = userDao.getUserGenderNumbers();
		int genderNumberCount = genderNumberList.size();
		String[] names = new String[genderNumberCount];
		String[] values = new String[genderNumberCount];
		// 遍历统计数据，转换成 Chart.js 所需要的数据格式
		for (int i = 0, n = genderNumberCount; i < n; i++) {
			Object[] genderNumbers = (Object[]) genderNumberList.get(i);
			// 性别标签名称，如：male、female
			names[i] = "\"" + String.valueOf(genderNumbers[1]) + "\"";
			// 性别对应的用户数据
			values[i] = String.valueOf(genderNumbers[0]);
		}
		ChartData userGenderData = new ChartData();
		userGenderData.setNames("[" + String.join(",", names) + "]");
		userGenderData.setValues("[" + String.join(",", values) + "]");

		return userGenderData;
	}

	/**
	 * 获取用户创建日期统计数据
	 * 
	 * @return
	 */
	public ChartData getUserCreateData() {
		// 获取根据创建日期分组统计数据
		List createDateNumberList = userDao.getUserCreateDateNumbers();
		int createDateNumberCount = createDateNumberList.size();
		String[] names = new String[createDateNumberCount];
		String[] values = new String[createDateNumberCount];

		// 遍历统计数据，转换成 Chart.js 所需要的数据格式
		for (int i = 0, n = createDateNumberCount; i < n; i++) {
			Object[] createDateNumbers = (Object[]) createDateNumberList.get(i);
			// 日期标签，如：2017-03-21
			names[i] = "\"" + String.valueOf(createDateNumbers[1]) + "\"";
			// 日期对应的创建用户数量
			values[i] = String.valueOf(createDateNumbers[0]);
		}
		ChartData userCreateDateData = new ChartData();
		userCreateDateData.setNames("[" + String.join(",", names) + "]");
		userCreateDateData.setValues("[" + String.join(",", values) + "]");

		return userCreateDateData;
	}

}
