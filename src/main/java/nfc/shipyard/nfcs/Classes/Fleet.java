package nfc.shipyard.nfcs.Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;
import nfc.shipyard.nfcs.xmlSerialization.XmlFormatter;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    public static void saveFleet(Fleet fleet, String savePath) {
        //remove sockets with no components
        List<Ship> shipList = fleet.getShips();
        for (Ship ship : shipList) {
//            fleet.setTotalPoints(fleet.getTotalPoints() + ship.getCost());
            List<HullSocket> socketList = ship.getSockets();
            List<HullSocket> filledSockets = new ArrayList<>();
            for (HullSocket socket : socketList) {
                if (socket.getComponentName() != null) {
                    filledSockets.add(socket);
                }
            }
            ship.setSockets(filledSockets);
        }
        fleet.setShips(shipList);

        XmlMapper xmlMapper = new XmlMapper();
        String filename = savePath + fleet.getName() + ".fleet";
        try {
            String formattedFleet = new XmlFormatter().format(xmlMapper.writeValueAsString(fleet));
            formattedFleet = "<?xml version=\"1.0\"?>\n" + formattedFleet;
            formattedFleet = formattedFleet.replaceFirst("<Fleet>",
                    "<Fleet xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
            formattedFleet = formattedFleet.replaceFirst("<SaveID/>", "<SaveID xsi:nil=\"true\" />");
            File file = new File(filename);
            FileUtils.writeStringToFile(file, formattedFleet, StandardCharsets.UTF_8);
//            file.renameTo(new File(savePath + fleet.getName() + ".fleet")); //doesn't work
            System.out.println(formattedFleet);
            System.out.println("Created file: " + file.getName() +
                    "\nFile location: " + file.getAbsolutePath());


        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "name='" + name + '\'' +
                ", totalPoints=" + totalPoints +
                ", ships=" + ships +
                '}';
    }

    //    private int fleetCost;
    public Ship createShip(String hullType) {
        Ship ship = new Ship();
        ship.setKey(generateShipKey());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ship's name:");
        ship.setName(scanner.nextLine());

        Random random = new Random();
        ship.setNumber(random.nextInt(999 - 1));

        if (hullType.equals("Stock/Sprinter Corvette")) {
            ship.setCost(100);
            ship.setHullType(hullType);
            ship.setSockets(generateSocketMap(hullType));
            return ship;
        } else System.out.println("Invalid hull type");
        return ship;
    }
}




