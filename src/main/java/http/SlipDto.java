package http;

public class SlipDto {

    private long id;
    private String advice;


    public SlipDto(long id, String advice) {
        this.id = id;
        this.advice = advice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "SlipDto{" +
                "id=" + id +
                ", advice='" + advice + '\'' +
                '}';
    }
}
