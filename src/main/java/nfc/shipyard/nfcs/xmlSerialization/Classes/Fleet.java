package nfc.shipyard.nfcs.xmlSerialization.Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fleet {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Ships")
    private List<Ship> ships = new ArrayList<>();

//    private int fleetCost;
}




