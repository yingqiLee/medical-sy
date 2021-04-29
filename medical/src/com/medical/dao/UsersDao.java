package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.aliyuncs.ram.model.v20150501.CreateUserResponse.User;
import com.medical.entity.Users;



@Repository
public class UsersDao {

	@Resource
	private SessionFactory sessionFactory;
	public void saveUser(Users user) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	//登录和注册
	public String signUser(String phone,String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users where uPhone=?");
		query.setParameter(0, phone);
		List<Users> userlist=query.list();
		if(userlist.size() == 0) {
			Users u = new Users(phone,password,0);
			int id = (int)session.save(u);
			return ""+id;
		}
		else {
			Users u2 =userlist.get(0) ;
			if(u2.getUpassword().equals(password)) {
				return ""+u2.getuId();
			}
			else
				return "账号或密码错误"; 
			
		}
		
	}
	
	//根据id查找user
	public Users findUserById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select * from Users where uId=?");
		query.setParameter(0,id);
		List<Users> userlist=query.list();
		Users u = userlist.get(0);
		return u;
	}
	
	
	//个人中心更改user信息
	public void update(Users u) {
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
	}
	
	
	
}
