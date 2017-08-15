package ru.igrey.dev.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Created by sanasov on 28.11.2016.
 * В данном классе находятся настройки для подключения к бд
 */
@Configuration
@MapperScan({"ru.igrey.dev.dao"})
@EnableTransactionManagement
public class DaoSpringConfig {
    /**
     * @return источник данных
     */
    @Bean
    public DataSource dataSource() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            return (DataSource) envContext.lookup("jdbc/member_dashboard");
        } catch (Exception e) {
            throw new RuntimeException("Cannot resolve datasource! Details: ", e);
        }
    }

    /**
     * @return менеджер транзакций
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * @return фабрика сессий
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        try {
            return sessionFactory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
