package hibernateDemo;

import org.aspectj.weaver.ast.Or;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by pxc on 2017/8/21.
 */
public class TestHibernate {

    /**
     * 多的一方保存1的一方
     */
    @Test
    public void test1() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(StuEntity.class);
        config.addAnnotatedClass(ClassesEntity.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        ClassesEntity classesEntity = new ClassesEntity();
        classesEntity.setName("二年级");
        StuEntity stuEntity = new StuEntity();
        stuEntity.setName("pxc123");
        stuEntity.setAge(20);
        stuEntity.setClassesEntity(classesEntity);
        session.save(stuEntity);
        tx.commit();
    }

    /**
     * 一的一方保存多的一方
     */
    @Test
    public void test2() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(StuEntity.class);      //采用注解时这里需要写
        config.addAnnotatedClass(ClassesEntity.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        ClassesEntity classesEntity = new ClassesEntity();
        classesEntity.setName("一年级");

        StuEntity stuEntity = new StuEntity();
        stuEntity.setName("pxc");
        stuEntity.setAge(20);
        stuEntity.setClassesEntity(classesEntity);

        StuEntity stuEntity1 = new StuEntity();
        stuEntity1.setName("qwe");
        stuEntity1.setAge(22);
        stuEntity1.setClassesEntity(classesEntity);


        classesEntity.getStuEntities().add(stuEntity);
        classesEntity.getStuEntities().add(stuEntity1);

        session.save(classesEntity);
        tx.commit();
    }

    @Test
    public void test3() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(OrderEntity.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        for (int i = 0; i < 100000; i++) {
            OrderEntity o = new OrderEntity();
            o.setOrderSn(String.valueOf(i));
            o.setName("order" + i);
            session.save(o);
        }
        tx.commit();
    }


    @Test
    public void test111(){
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDae);
        for(Calendar i = startCalendar;; i.add(Calendar.DAY_OF_MONTH,1)){

        }
    }

}
