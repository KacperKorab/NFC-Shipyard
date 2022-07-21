package project;

import java.util.Arrays;
import java.util.List;

public class HullSocket {
    final List<String> validComponentNames = Arrays.asList(
            "Stock/Basic CIC",
            "Stock/FR4800 Reactor",
            "Stock/FM200 Drive",
            "Stock/RS35 'Frontline' Radar",
            "");
    private String socketKey;
    private String componentName;

    public HullSocket(String socketKey, String componentName) {
        this.socketKey = socketKey;
        this.componentName = componentName;
    }

    @Override
    public String toString() {
        if (!validComponentNames.contains(componentName)) {
            try {
                throw new Exception("no such component name");
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return
                "<HullSocket>\n" +
                "<Key>" + socketKey + "</Key>\n" +
                "<ComponentName>" + componentName + "</ComponentName>\n" +
                "</HullSocket>\n";
    }

    public String getSocketKey() {
        return socketKey;
    }

    public void setSocketKey(String socketKey) {
        this.socketKey = socketKey;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
}
