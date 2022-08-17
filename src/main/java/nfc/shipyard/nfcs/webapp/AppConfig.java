package nfc.shipyard.nfcs.webapp;

import nfc.shipyard.nfcs.Classes.Component;
import nfc.shipyard.nfcs.Classes.Fleet;
import nfc.shipyard.nfcs.Classes.Ship;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public Fleet fleet(){
        return new Fleet();
    }

    @Bean
    public Ship ship(){
        return new Ship();
    }
    @Bean
    public Component component(){
        return new Component();
    }
}
