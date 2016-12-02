package edu.school.test;

/**
 * Clase POJO que define el requerimiento que se está realizando
 *
 * @author jgcastillo
 */
public class Request {

    private int days;

    public Request(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
