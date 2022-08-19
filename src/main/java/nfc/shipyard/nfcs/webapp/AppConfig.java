package nfc.shipyard.nfcs.webapp;

import nfc.shipyard.nfcs.Classes.Component;
import nfc.shipyard.nfcs.Classes.Fleet;
import nfc.shipyard.nfcs.Classes.HullSocket;
import nfc.shipyard.nfcs.Classes.Ship;
import nfc.shipyard.nfcs.database.FleetDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "nfc.shipyard.nfcs")
@EnableTransactionManagement
//@EnableJpaRepositories
public class AppConfig implements WebMvcConfigurer {

//    @Bean
//    public Fleet fleet() {
//        return new Fleet();
//    }
//
//    @Bean
//    public Ship ship() {
//        return new Ship();
//    }
//
//    @Bean
//    public Component component() {
//        return new Component();
//    }
//
//    @Bean
//    HullSocket hullSocket() {
//        return new HullSocket();
//    }
//
//    @Bean
//    FleetDao fleetDao(){
//        return new FleetDao();
//    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("NFCSPersistenceUnit");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
