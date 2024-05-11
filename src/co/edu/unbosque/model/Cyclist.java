/**
 *
 */
package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsCyclist;
import co.edu.unbosque.interfaces.CyclistInterface;

import java.time.LocalTime;
import java.util.UUID;

/**
 *
 */
public abstract class Cyclist extends User implements CyclistInterface {

    private UUID id;

    private String name;

    private LocalTime timeRice;

    private String bodyStructure;

    private String cadencePedaling;

    public Cyclist(String name,
                   String bodyStructure,
                   String cadencePedaling,
                   long cedula,
                   int experience,
                   String email,
                   String password) {
        super(cedula, experience, email, password);
        ValidationsCyclist.verifyName(name);
        this.name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1);

        id = UUID.randomUUID();
        timeRice = LocalTime.of(0, 0, 0);

        this.bodyStructure = bodyStructure;
        this.cadencePedaling = cadencePedaling;
    }

    @Override
    abstract public void specialty();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationsCyclist.verifyName(name);
        this.name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1);
    }

    public LocalTime getTimeRice() {
        return timeRice;
    }

    public void setTimeRice(LocalTime timeRice) {
        this.timeRice = timeRice;
    }

    public String getBodyStructure() {
        return bodyStructure;
    }

    public void setBodyStructure(String bodyStructure) {
        this.bodyStructure = bodyStructure;
    }

    public String getCadencePedaling() {
        return cadencePedaling;
    }

    public void setCadencePedaling(String cadencePedaling) {
        this.cadencePedaling = cadencePedaling;
    }
}
