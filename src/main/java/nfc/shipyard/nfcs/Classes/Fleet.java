package nfc.shipyard.nfcs.Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static nfc.shipyard.nfcs.Classes.Ship.generateShipKey;
import static nfc.shipyard.nfcs.Classes.Ship.generateSocketMap;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Fleet {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Version")
    private int version = 2;
    @JsonProperty("TotalPoints")
    private int totalPoints = 0;
    @JsonProperty("FactionKey")
    private String factionKey = "Stock/Alliance";
    @JsonProperty("Ship")
    @JacksonXmlElementWrapper(localName = "Ships")
    private List<Ship> ships = new ArrayList<>();

    @Override
    public String toString() {
        return "Fleet{" +
                "name='" + name + '\'' +
                ", totalPoints=" + totalPoints +
                ", ships=" + ships +
                '}';
    }

    //    private int fleetCost;
public Ship createShip(String hullType){
    Ship ship = new Ship();
    ship.setKey(generateShipKey());

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ship's name:");
    ship.setName(scanner.nextLine());

    Random random = new Random();
    ship.setNumber(random.nextInt(999-1));

    if (hullType.equals("Stock/Sprinter Corvette")){
        ship.setCost(100);
        ship.setHullType(hullType);
        ship.setSockets(generateSocketMap(hullType));
        return ship;
    } else System.out.println("Invalid hull type");
    return ship;
}
}




