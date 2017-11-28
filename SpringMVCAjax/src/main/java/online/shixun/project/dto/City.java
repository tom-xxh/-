package online.shixun.project.dto;

//市
public class City {
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public City() {
		super();
	}

	@Override
	public String toString() {
		return "City [code=" + code + ", name=" + name + "]";
	}

}
