package com.qingshixun.project.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.Page;
import com.qingshixun.project.model.UserModel;
import com.qingshixun.project.service.UserService;

@Component("userAction")
public class UserAction {

	@Autowired
	private UserService userService;
	private List<UserModel> list;
	private UserModel userModel;
	private Page<UserModel> userModellist;
	// 用户性别统计数据
	private ChartData userGenderData;

	// 用户创建日期统计数据
	private ChartData userCreateData;
	// 指定默认每页的显示记录条数
	private static final int DEFAULT_PAGE_SIZE = 5;

	public String findUsers() {
		list = userService.getUsers();
		return "list";
	}

	public String index() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageNo = 1;

		// 指定页数（第几页）
		String inputPageNo = request.getParameter("pageNo");
		if (!StringUtils.isEmpty(inputPageNo)) {
			pageNo = Integer.parseInt(inputPageNo);
		}

		// 查询并返回分页数据
		userModellist = userService.findUserModelList(pageNo, DEFAULT_PAGE_SIZE);
		return "index";
	}

	public String searchuserInfo() {
		userModel = userService.getUser(userModel);
		return "succeed";
	}

	public String updateInfo() {
		userService.updateUserModel(userModel);
		return "succeed";
	}

	public String deleteuserinfo() {
		userService.deleteUserModel(userModel);
		return "succeed";
	}

	public String toadd() {
		return "succeed";
	}

	public String toanalyze() {
		// 根据userId，查询用户信息
		userGenderData = userService.getUserGenderData();
		userCreateData = userService.getUserCreateData();
		return "succeed";
	}

	public String adduserInfos() {
		userService.addUserModel(userModel);
		return "succeed";
	}

	public List<UserModel> getList() {
		return list;
	}

	public void setList(List<UserModel> list) {
		this.list = list;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public Page<UserModel> getUserModellist() {
		return userModellist;
	}

	public void setUserModellist(Page<UserModel> userModellist) {
		this.userModellist = userModellist;
	}

	public ChartData getUserGenderData() {
		return userGenderData;
	}

	public void setUserGenderData(ChartData userGenderData) {
		this.userGenderData = userGenderData;
	}

	public ChartData getUserCreateData() {
		return userCreateData;
	}

	public void setUserCreateData(ChartData userCreateData) {
		this.userCreateData = userCreateData;
	}

}
