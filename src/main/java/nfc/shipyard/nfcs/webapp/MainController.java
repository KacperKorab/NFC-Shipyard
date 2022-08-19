package nfc.shipyard.nfcs.webapp;

import nfc.shipyard.nfcs.Classes.Component;
import nfc.shipyard.nfcs.Classes.Fleet;
import nfc.shipyard.nfcs.Classes.Ship;
import nfc.shipyard.nfcs.database.FleetDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static nfc.shipyard.nfcs.Classes.Fleet.saveFleet;
import static nfc.shipyard.nfcs.Classes.Ship.fillShip;

@Controller
@SessionAttributes("shipChoice")
public class MainController {

//    private final List<Component> allComponents = new ArrayList<>(Component.getComponents());
    //DB
    private final FleetDao fleetDao;
    private Fleet fleet;

    public MainController(FleetDao fleetDao, Fleet fleet) {
        this.fleetDao = fleetDao;
        this.fleet = fleet;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("fleet", fleet);
    }

    @GetMapping("/")
    public String index() {
        return "index2";
    }

    @GetMapping("/resetFleet")
    public RedirectView resetFleet() {
        fleet = new Fleet();
        return new RedirectView("/");
    }

    @GetMapping("/nameFleet")
    public String nameFleetForm(Model model) {
        Fleet fleet = new Fleet();
        model.addAttribute("fleet", fleet);
        return "nameFleet";
    }

    @PostMapping("/nameFleet")
    public RedirectView nameFleetSubmit(Fleet fleet, Model model) {
        model.addAttribute("fleet", fleet);
        return new RedirectView("/");
    }

    @GetMapping("/addSprinter2")
    public ModelAndView addSprinterForm() {
        return new ModelAndView("addSprinter2", "ship", new Ship());
    }

    @PostMapping("/addSprinter2")
    public String addSprinterSubmit(@ModelAttribute("ship") Ship ship,
                                    BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        fillShip(ship, "Stock/Sprinter Corvette");
        model.addAttribute("name", ship.getName());
        fleet.getShips().add(ship);
        return "addSprinter2";
    }

    @GetMapping("/shipList")
    public String addSprinterSubmit(Model model) {
        model.addAttribute("fleet", fleet);
        return "shipList";
    }

    @GetMapping("/shipList/socketList")
    public String socketList(Model model, @RequestParam int shipId) {
        model.addAttribute("ship", fleet.getShips().get(shipId - 1));
        model.addAttribute("shipId", shipId);
        return "socketList";
    }

    @GetMapping("/shipList/socketList/socket")
    public String socketForm(Model model) {
        Component component = new Component();
        model.addAttribute("component", component);
        return "socket";
    }

    @PostMapping("/shipList/socketList/socket")
    public String socketSubmit(Model model, @ModelAttribute Component component,
                               @RequestParam int shipId, @RequestParam int socketId) {
        model.addAttribute("component", component);
        fleet.getShips().get(shipId - 1).getSockets().get(socketId - 1)
                .setComponentName(component.getComponentName());
        return "socket";
    }
    // Save Fleet to database
    @RequestMapping("/saveToDB")
    @ResponseBody
    public String saveFleetToDB() {
        fleetDao.saveFleetToDB(fleet);
        return "Added fleet to database:\n"
                + fleet.getName();
    }

    // Download fleet
    @RequestMapping("/download/{fileName:.+}")
    public void downloadFleet(HttpServletRequest request,
                              HttpServletResponse response,
                              @PathVariable("fileName") String fileName) {

        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/fleets/");
        saveFleet(fleet, dataDirectory);
        Path file = Paths.get(dataDirectory, fileName);
        System.out.println("Path file: " + file);
        if (Files.exists(file)) {
            response.setContentType("application/txt");
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
