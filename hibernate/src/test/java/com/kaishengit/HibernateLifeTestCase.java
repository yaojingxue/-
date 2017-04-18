package com.kaishengit;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by acer on 2017/4/17.
 */
public class HibernateLifeTestCase {
    @Test
    public void testSave() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = new User();
        user.setPassword("098");
        user.setUsername("小李");
        session.persist(user);
        System.out.println(user.getId());
        session.getTransaction().commit();
    }

    @Test
    public void testFindByLoad() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
//延迟加载用的时候才取数据库中查询才有sql语句，不用的时候不进行查询
        User user = (User) session.load(User.class, 9);
        //System.out.println(user.getUsername());

        System.out.println(user == null);
        session.getTransaction().commit();
    }

    @Test
    public void testSaveOrUpdate() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("李斯");
        user.setPassword("334455");

        session.saveOrUpdate(user);

        session.getTransaction().commit();

        user.setPassword("0987654321");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        session2.saveOrUpdate(user);

        session2.getTransaction().commit();

    }

    @Test
    public void testMerge() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

                        /*User user = new User();
        user.setPassword("334455");

         session.merge(user);*/
        User user = (User) session.get(User.class, 11);


        session.getTransaction().commit();

        //-----------------------------------------

        user.setPassword("987654321");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        session2.merge(user);

        session2.getTransaction().commit();

    }

    @Test
    public void testDelete() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class, 11);
//        session.delete(user);
       session.getTransaction().commit();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        session2.delete(user);

        session2.getTransaction().commit();
    }


}
