package nfc.shipyard.nfcs.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SocketSize {
    /*
    TODO
        Compounding costs and berthing/magazine values
     */
    private int x;
    private int y;
    private int z;

    public static boolean doesComponentFit(HullSocket socket, Component component) {
        return socket.getSocketSize().getX() >= component.getComponentSize().getX() &&
                socket.getSocketSize().getY() >= component.getComponentSize().getY() &&
                socket.getSocketSize().getZ() >= component.getComponentSize().getZ();
    }
}
