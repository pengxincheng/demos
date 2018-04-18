package hibernateDemo;

import org.aspectj.weaver.ast.Or;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

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
        for (int i = 0; i < 10; i++) {
            OrderEntity o = new OrderEntity();
            o.setOrderSn(String.valueOf(i));
            o.setName("order" + i);
            session.save(o);
        }
        tx.commit();
    }

    @Test
    public void test4() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(OrderEntity.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        OrderEntity o = (OrderEntity) session.load(OrderEntity.class, "40289e815f094d51015f094d53ea0006");
        o.setSearchWord("I am a good boy");
        session.update(o);
        tx.commit();
    }

    @Test
    public void testHibernateSerach() {
       // this.index();
        Configuration config = new Configuration();
        config.addAnnotatedClass(OrderEntity.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        //建立索引
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction tx = fullTextSession.beginTransaction();

        // create native Lucene query using the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(OrderEntity.class).get();
        org.apache.lucene.search.Query query =
                qb.keyword().onFields("searchWord")
                        .matching("am")
                        .createQuery();

        // wrap Lucene query in a org.hibernate.Query
        org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, OrderEntity.class);

    // execute search
        List result = hibQuery.list();
        System.out.println(result.size());
        tx.commit();
        session.close();
    }

    private void index() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(OrderEntity.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //建立索引
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertUser(){
        Configuration config = new Configuration();
        config.addAnnotatedClass(UserEntity.class);      //采用注解时这里需要写

        config.configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        for(int i=0;i<500000;i++){
            UserEntity userEntity = new UserEntity();
            userEntity.setName("里"+Math.random());
            userEntity.setAge((int)Math.random());
            session.save(userEntity);

        }
        tx.commit();
    }
}
