package online.shixun.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_order")
public class Order {
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增
	@Column(name = "order_id")
	private Long id;
	@Column(name = "order_code")
	private String code;
	// TemporalType.DATE yyyy-MM-dd
	// TemporalType.TIME yyyy-MM-dd hh:mm:ss
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", createDate=" + createDate + "]";
	}

	public Order() {
		super();
	}

	public Order(Long id, String code, Date createDate) {
		super();
		this.id = id;
		this.code = code;
		this.createDate = createDate;
	}

	public Order(String code, Date createDate) {
		super();
		this.code = code;
		this.createDate = createDate;
	}

	public Order(Long id) {
		super();
		this.id = id;
	}

}
