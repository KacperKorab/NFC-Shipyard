package nfc.shipyard.nfcs.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@org.springframework.stereotype.Component
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class HullSocket {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("ComponentName")
    private String componentName;

    @JsonIgnore
    private int hullSocketType;
    // 0-Mounting, 1-Compartment, 2-Module
    @JsonIgnore
    private SocketSize socketSize;
    @JsonIgnore
    private String socketName;
    @JsonIgnore
    private Component component;
    @JsonIgnore
    private List<Component> allComponents = Component.getComponents();

    public HullSocket(String key, int hullSocketType, SocketSize socketSize, String socketName) {
        this.key = key;
        this.hullSocketType = hullSocketType;
        this.socketSize = socketSize;
        this.socketName = socketName;
    }

    public static boolean doesComponentFit(HullSocket socket, Component component) {
        return socket.getHullSocketType() == component.getComponentSocketType()
                && socket.getSocketSize().getX() >= component.getComponentSize().getX()
                && socket.getSocketSize().getY() >= component.getComponentSize().getY()
                && socket.getSocketSize().getZ() >= component.getComponentSize().getZ();
    }

    @Override
    public String toString() {
        return "\nHullSocket{" +
                "key='" + key + '\'' +
                ", componentName='" + componentName + '\'' +
                '}';
    }

}
