package online.shixun.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import online.shixun.model.Order;
import online.shixun.model.User;

public class HibernateOneToManyDemo {
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
	 * 保存用户及其关联的订单数据
	 */
	public void saveUser() {
		init();
		User user = new User(new Date(), "李四", "654321");
		user.getOrders().add(new Order("555", new Date()));
		user.getOrders().add(new Order("666", new Date()));
		user.getOrders().add(new Order("777", new Date()));
		user.getOrders().add(new Order("888", new Date()));
		session.save(user);
		System.out.println(user.toStringAndOrder());
		destroy();
	}

	/**
	 * 查询用户及其关联的订单数据
	 */
	public void getUser() {
		init();
		User user = (User) session.get(User.class, 3L);
		System.out.println(user.toStringAndOrder());
		destroy();
	}

	public static void main(String[] args) {
		HibernateOneToManyDemo hibernateOneToManyDemo = new HibernateOneToManyDemo();
		hibernateOneToManyDemo.getUser();
	}

}
