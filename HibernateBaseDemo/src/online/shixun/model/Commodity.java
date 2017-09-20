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
@Table(name = "commodity")
public class Commodity {
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	// TemporalType.DATE yyyy-MM-dd
	// TemporalType.TIME yyyy-MM-dd hh:mm:ss
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	Date createDate;
	@Column(name = "describeinfo")
	private String describe;
	@Column(name = "modifyDate")
	Date modifyDate;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", createDate=" + createDate + ", describe=" + describe
				+ ", modifyDate=" + modifyDate + "]";
	}
	public Commodity(Integer id, String name, Date createDate, String describe, Date modifyDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.describe = describe;
		this.modifyDate = modifyDate;
	}
	
	public Commodity(Integer id) {
		super();
		this.id = id;
	}
	public Commodity() {
		super();
	}
	public Commodity(String name, Date createDate, String describe, Date modifyDate) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.describe = describe;
		this.modifyDate = modifyDate;
	}
	
	
}
