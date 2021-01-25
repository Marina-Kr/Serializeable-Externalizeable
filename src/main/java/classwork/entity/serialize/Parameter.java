package classwork.entity.serialize;

import org.codehaus.jackson.annotate.JsonGetter;

import java.io.Serializable;
import java.util.List;

public class Parameter implements Serializable{
    
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
                       ", path=" + paths +
                       ", type='" + type + '\'' +
                       ", values=" + values +
                       '}';
    }
    

}
