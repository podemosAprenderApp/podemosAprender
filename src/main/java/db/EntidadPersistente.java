package db;

import com.google.gson.annotations.Expose;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadPersistente {
    @Id @Expose
    @GeneratedValue
    private int id;

    public EntidadPersistente(){}

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}