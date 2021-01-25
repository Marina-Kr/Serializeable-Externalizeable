package classwork.entity.externalize;

import org.codehaus.jackson.annotate.JsonGetter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class Parameter implements Externalizable {

    private static final long serialVersionUID = 1L;

    private String name;
    List<Path> paths;
    String type;
    List<String> values;


    public String getName() {
        return name;
    }
    @JsonGetter("name")
    public void setName(String name) {
        this.name = name;
    }

    public List<Path> getPaths() {
        return paths;
    }
    @JsonGetter("paths")
    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }


    @Override
    public String toString() {
        return "Parameter{" +
                       "name='" + name + '\'' +
                       ", paths=" + paths +
                       ", type='" + type + '\'' +
                       ", values=" + values +
                       '}' + "\n";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println(
                "Имя параметра: " + this.getName() +
                        ". Путь к параметру " + this.getPaths() +
                        ". Тип параметра " + this.getType() +
                        ". Значения параметра + " + this.getValues());
        out.writeObject(this.getName());
        out.writeObject(this.getPaths());
        out.writeObject(this.getType());
        out.writeObject(this.getValues());
    
    }
    
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.setPaths((List<Path>)in.readObject());
        this.setType((String)in.readObject());
        this.setValues((List<String>)in.readObject());
        
    }
}
