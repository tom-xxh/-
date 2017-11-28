package online.shixun.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import online.shixun.project.dto.City;
import online.shixun.project.dto.District;
import online.shixun.project.dto.Province;

@Controller
@RequestMapping(value = "/select")
public class SelectRegionController {
	// 省份数据List
	private static List<Province> provinceList = new ArrayList<>();

	// 城市数据Map：key=provinceCode;value=cities
	private static Map<String, List<City>> cityMap = new HashMap<>();

	// 区数据Map：key=cityCode;value=districts
	private static Map<String, List<District>> districtMap = new HashMap<>();

	static {
		// 初始化省、市、区数据
		provinceList.add(new Province("hubei", "湖北省"));
		provinceList.add(new Province("jilin", "吉林省"));

		List<City> cities1 = new ArrayList<>();
		cities1.add(new City("wuhan", "武汉市"));
		cities1.add(new City("suizhou", "随州市"));
		cityMap.put("hubei", cities1);

		List<City> cities2 = new ArrayList<>();
		cities2.add(new City("changchun", "长春市"));
		cities2.add(new City("jilin", "吉林市"));
		cityMap.put("jilin", cities2);

		List<District> district1 = new ArrayList<>();
		district1.add(new District("hongshan", "洪山区"));
		district1.add(new District("jiangxia", "江夏区"));
		districtMap.put("wuhan", district1);

		List<District> district2 = new ArrayList<>();
		district2.add(new District("hongshan", "曾都区"));
		district2.add(new District("jiangxia", "广水区"));
		districtMap.put("suizhou", district2);

		List<District> district3 = new ArrayList<>();
		district3.add(new District("chaoyang", "朝阳区"));
		district3.add(new District("nanguan", "南关区"));
		districtMap.put("changchun", district3);

		List<District> district4 = new ArrayList<>();
		district4.add(new District("chaoyang", "船营区"));
		district4.add(new District("nanguan", "龙潭区"));
		districtMap.put("jilin", district4);
	}

	/**
	 * 访问select页面
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String selectPage() {
		return "select";
	}

	/**
	 * TODO 选择省份
	 */
	@ResponseBody
	@RequestMapping(value = "province", method = RequestMethod.POST)
	public String province() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("province", provinceList);
		return jsonObject.toJSONString();
	}

	/**
	 * TODO 选择市
	 */
	@ResponseBody
	@RequestMapping(value = "city", method = RequestMethod.POST)
	public String city(Province province) {
		String code = province.getCode();
		System.out.println(code);
		JSONObject jsonObject = new JSONObject();
		List<City> cities = new ArrayList<>();
		cities.addAll(cityMap.get(code));
		jsonObject.put("cities", cities);
		return jsonObject.toJSONString();
	}

	/**
	 * TODO 选择区
	 */
	@ResponseBody
	@RequestMapping(value = "district", method = RequestMethod.POST)
	public String district(City city) {
		String code = city.getCode();
		System.out.println(code);
		JSONObject jsonObject = new JSONObject();
		List<District> district = new ArrayList<>();
		district.addAll(districtMap.get(code));
		jsonObject.put("district", district);
		return jsonObject.toJSONString();
	}
}
