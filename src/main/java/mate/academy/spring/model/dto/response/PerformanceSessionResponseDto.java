package mate.academy.spring.model.dto.response;

public class PerformanceSessionResponseDto {
    private Long id;
    private String performanceTitle;
    private String showTime;
    private int cinemaHallCapacity;

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getCinemaHallCapacity() {
        return cinemaHallCapacity;
    }

    public void setCinemaHallCapacity(int cinemaHallCapacity) {
        this.cinemaHallCapacity = cinemaHallCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
