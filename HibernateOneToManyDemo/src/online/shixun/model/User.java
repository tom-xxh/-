package online.shixun.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_user")
public class User {
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增
	@Column(name = "user_id")
	private Long id;
	// TemporalType.DATE yyyy-MM-dd
	// TemporalType.TIME yyyy-MM-dd hh:mm:ss
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	private Date createDate;
	@Column(name = "loginName")
	private String loginName;
	@Column(name = "password")
	private String password;

	// 特殊属性
	// 1：N
	// fetch 控制 查询
	// cascade 控制 添加,删除,修改
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private Set<Order> orders = new HashSet<Order>();

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(Long id, Date createDate, String loginName, String password) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.loginName = loginName;
		this.password = password;
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public User(Date createDate, String loginName, String password) {
		super();
		this.createDate = createDate;
		this.loginName = loginName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", createDate=" + createDate + ", loginName=" + loginName + ", password=" + password
				+ "]";
	}

	public String toStringAndOrder() {
		return "User [id=" + id + ", createDate=" + createDate + ", loginName=" + loginName + ", password=" + password
				+ "  orders=" + orders + "]";
	}
}
