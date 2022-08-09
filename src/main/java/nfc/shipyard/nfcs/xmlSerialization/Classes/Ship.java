package nfc.shipyard.nfcs.xmlSerialization.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import com.mifmif.common.regex.Generex;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ship {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Number")
    private int number;
    @JsonProperty("HullType")
    private String hullType;
    @JsonProperty("SocketMap")
    private List<HullSocket> sockets = new ArrayList<>();

    @JsonIgnore
    private int shipCost;
    @JsonIgnore
    private int crewBalance;
    @JsonIgnore
    private int powerBalance;

    public static String generateShipKey() {
        Generex generex = new Generex("([0-9]|[a-f])");
        StringBuilder randomShipKey = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            randomShipKey.append(generex.random());
        }
        randomShipKey.append("-");
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                randomShipKey.append(generex.random());
            }
            randomShipKey.append("-");
        }
        for (int i = 0; i < 12; i++) {
            randomShipKey.append(generex.random());
        }
        return randomShipKey.toString();
    }
    @Override
    public String toString() {
        return "\nShip{" +
                "name='" + name + '\'' +
                "hull type='" + hullType + '\'' +
                ", sockets: " + sockets +
                '}';
    }
    public List<HullSocket> generateSocketMap(String hullType){
        List<HullSocket> socketMap = new ArrayList<>();
        if (hullType.equals("Sprinter")){
            //Mountings
            socketMap.add(new HullSocket("wDsRnL5nKkyYvKgD6VcPHg", 0,
                    new SocketSize(3,4,5), "Amidships Bottom"));
            socketMap.add(new HullSocket("Z48ot_dQfkWb6AVYjaM_gA", 0,
                    new SocketSize(3,4,3), "Bow Bottom"));
            socketMap.add(new HullSocket("IUdNSVZm2Eu9n3F5HnSAng", 0,
                    new SocketSize(2,2,2), "Amidships Starboard"));
            socketMap.add(new HullSocket("ZxY9ONYz80SiLNSObvjNzQ", 0,
                    new SocketSize(2,2,2), "Amidships Port"));
            //Compartments
            socketMap.add(new HullSocket("XPaYCjBqdEqBxEIsVLP0oA", 1,
                    new SocketSize(4,1,6), "Deck 0"));
            socketMap.add(new HullSocket("xRYIkvssd0mPY3VIgrnQ5A", 1,
                    new SocketSize(4,1,6), "Deck 1"));
            socketMap.add(new HullSocket("rXO8xwG1MkqzI_2pU", 1,
                    new SocketSize(3,1,3), "Deck 2 Front"));
            socketMap.add(new HullSocket("GefqwCQzg0qXA3EFRmDtPw", 1,
                    new SocketSize(3,1,3), "Deck 2 Back"));
            //Modules
            socketMap.add(new HullSocket("4WpJyiOKVEqCwR99l47MkA", 2,
                    new SocketSize(3,3,3), "Amidships"));
            socketMap.add(new HullSocket("4EHx4mQhNUi-WuuQtQF5fA", 2,
                    new SocketSize(8,3,6), "Stern"));
            socketMap.add(new HullSocket("TSPPW9ECe06-MGzR1i0WvQ", 2,
                    new SocketSize(2, 2, 2), "Starboard"));
            socketMap.add(new HullSocket("MBOvGazj6UWpt2OOy44s7w", 2,
                    new SocketSize(2, 2, 2), "Port"));
        } else System.out.println("Invalid hull type: " + hullType);
        return socketMap;
    }
}
