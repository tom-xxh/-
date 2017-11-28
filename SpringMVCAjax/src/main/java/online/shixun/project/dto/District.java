package online.shixun.project.dto;

//区
public class District {
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

	public District(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public District() {
		super();
	}

	@Override
	public String toString() {
		return "District [code=" + code + ", name=" + name + "]";
	}

}
