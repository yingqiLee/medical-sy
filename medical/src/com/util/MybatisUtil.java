package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
    static {
        try {
            InputStream is =  Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSqlSession() {
        return factory.openSession();
    }

}
