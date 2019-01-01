package com.myproject.example.configure;

import com.myproject.example.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ubuntu on 29/12/18.
 */
public class HibernateConfiguration {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/shopping?createDatabaseIfNotExist=true";
    private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private final static String DATABASE_USERNAME = "root";
    private final static String DATABASE_PASSWORD = "root";
    private final static String CREATE_HB = "create";


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder =
                        new StandardServiceRegistryBuilder();
                Map<String, String> settings = new HashMap();
                settings.put(Environment.DRIVER, DATABASE_DRIVER);
                settings.put(Environment.URL, DATABASE_URL);
                settings.put(Environment.USER, DATABASE_USERNAME);
                settings.put(Environment.PASS, DATABASE_PASSWORD);
                settings.put(Environment.DIALECT, DATABASE_DIALECT);
//                settings.put(Environment.HBM2DDL_AUTO, CREATE_HB);
//                settings.put(Environment.SHOW_SQL,"true");

                registryBuilder.applySettings(settings);

                registry = registryBuilder.build();

                MetadataSources sources = new MetadataSources(registry)
                        .addAnnotatedClass(EmployeeVO.class)
                        .addAnnotatedClass(Account.class)
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(OrderDetail.class)
                        .addAnnotatedClass(Product.class)
                        .addAnnotatedClass(Review.class)
                        .addAnnotatedClass(Address.class)
                        .addAnnotatedClass(Course.class);

                Metadata metaData = sources.getMetadataBuilder().build();
                sessionFactory = metaData.getSessionFactoryBuilder().build();


            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;

    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}
