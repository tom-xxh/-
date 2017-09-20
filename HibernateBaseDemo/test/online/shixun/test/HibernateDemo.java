package online.shixun.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import online.shixun.model.Commodity;

public class HibernateDemo {
	SessionFactory sf = null;
	Session session = null;
	Transaction transaction = null;

	/**
	 * 开启hibernate连接
	 */
	public void init() {
		// 加载配置文件
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		// 注册标准服务
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr = ssrb.applySettings(configuration.getProperties()).build();
		// 通过标准服务加载配置文件后获得会话工厂
		sf = configuration.buildSessionFactory(ssr);// 二级缓存
		// 开启一个会话
		session = sf.openSession();// 一级缓存
		// 开启事物
		transaction = session.beginTransaction();
		// 操作
		System.out.println("连接开启成功");
	}

	/**
	 * 关闭hibernate连接
	 */
	public void destroy() {
		// 提交事物
		transaction.commit();
		// 关闭
		session.close();
		sf.close();
		System.out.println("连接关闭成功");
	}

	/**
	 * 添加
	 */
	public void save() {
		init();
		Commodity commodity = new Commodity("牛奶", new Date(), "保质期一个月", new Date());
		session.save(commodity);
		System.out.println(commodity.toString());
		destroy();
	}

	/**
	 * 查询 get 立即加载
	 */
	public void get() {
		init();
		Commodity commodity = (Commodity) session.get(Commodity.class, 1);
		System.out.println(commodity.toString());
		destroy();
	}

	/**
	 * 删除
	 */
	public void delete() {
		init();
		session.delete(new Commodity(2));
		destroy();
	}

	/**
	 * 查询 load 使用时再加载
	 */
	public void load() {
		init();
		Commodity commodity = (Commodity) session.load(Commodity.class, 1);
		System.out.println(commodity.toString());
		destroy();
	}


	/**
	 * 合并 update--->select update
	 */
	public void merge_update() {
		init();
		Commodity commodity = new Commodity(1, "牛奶", new Date(), "保质期一个月", new Date());
		session.merge(commodity);
		destroy();
	}

	/**
	 * 修改 update
	 */
	public void saveOrUpdate() {
		init();
		Commodity commodity = new Commodity(1, "酸奶", new Date(), "保质期二个月", new Date());
		session.saveOrUpdate(commodity);
		destroy();
	}

	public static void main(String[] args) {
		HibernateDemo hibernateDemo = new HibernateDemo();
		hibernateDemo.merge_update();
	}

}
