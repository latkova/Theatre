package mate.academy.spring.config;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import mate.academy.spring.model.Performance;
import mate.academy.spring.model.PerformanceSession;
import mate.academy.spring.model.TheatreStage;
import mate.academy.spring.service.PerformanceService;
import mate.academy.spring.service.PerformanceSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.TheatreStageService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {
    private final PerformanceService performanceService;
    private final TheatreStageService theatreStageService;
    private final PerformanceSessionService performanceSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public AppInitializer(PerformanceService performanceService,
                          TheatreStageService theatreStageService,
                          PerformanceSessionService performanceSessionService,
                          ShoppingCartService shoppingCartService,
                          UserService userService) {
        this.performanceService = performanceService;
        this.theatreStageService = theatreStageService;
        this.performanceSessionService = performanceSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostConstruct
    public String initialize() {
        Performance fastAndFurious = new Performance("Fast and Furious");
        fastAndFurious.setDescription("An action performance about street racing, and spies.");
        performanceService.add(fastAndFurious);
        System.out.println(performanceService.get(fastAndFurious.getId()));

        Performance cruella = new Performance("Cruella");
        cruella.setDescription("A new stunning performance with brilliant actress Emma Stone!");
        performanceService.add(cruella);
        System.out.println(performanceService.get(cruella.getId()));

        performanceService.getAll().forEach(System.out::println);

        TheatreStage redTheatreStage = new TheatreStage();
        redTheatreStage.setCapacity(200);
        redTheatreStage.setDescription("red Theatre Stage with capacity 200");

        TheatreStage blueTheatreStage = new TheatreStage();
        blueTheatreStage.setCapacity(100);
        blueTheatreStage.setDescription("blue Theatre Stage with capacity 100");

        theatreStageService.add(redTheatreStage);
        theatreStageService.add(blueTheatreStage);

        PerformanceSession tomorrowPerformanceSession = new PerformanceSession();
        tomorrowPerformanceSession.setTheatreStage(redTheatreStage);
        tomorrowPerformanceSession.setPerformance(fastAndFurious);
        tomorrowPerformanceSession.setShowTime(LocalDateTime.now().plusDays(1L));

        PerformanceSession yesterdayPerformanceSession = new PerformanceSession();
        yesterdayPerformanceSession.setTheatreStage(redTheatreStage);
        yesterdayPerformanceSession.setPerformance(fastAndFurious);
        yesterdayPerformanceSession.setShowTime(LocalDateTime.now().minusDays(1L));

        performanceSessionService.add(tomorrowPerformanceSession);
        performanceSessionService.add(yesterdayPerformanceSession);

        return "Initialized!";
    }
}
