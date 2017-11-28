package online.shixun.project.dto;

//省
public class Province {
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

	public Province(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Province() {
		super();
	}

	@Override
	public String toString() {
		return "Province [code=" + code + ", name=" + name + "]";
	}

}
