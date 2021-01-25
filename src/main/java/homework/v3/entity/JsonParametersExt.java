package homework.v3.entity;

        import org.codehaus.jackson.annotate.JsonPropertyOrder;

        import java.io.*;
        import java.util.List;

@JsonPropertyOrder({"name", "description", "isList", "roles", "type", "bundle"})
public class JsonParametersExt implements Serializable, Externalizable {

    public static final long SerialVersionUID = 1L;

    private String name;
    private String description = "";
    private boolean isList;
    private List<String> roles;
    private String type;
    private List<Bundle> bundle;

    public JsonParametersExt() {}

    public JsonParametersExt(String name, String description, boolean isList, List<String> roles, String type, List<Bundle> bundle) {
        this.name = name;
        this.description = description;
        this.isList = isList;
        this.roles = roles;
        this.type = type;
        this.bundle = bundle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getisList() {
        return isList;
    }

    public void setList(boolean isList) {
        this.isList = isList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Bundle> getBundle() {
        return bundle;
    }

    public void setBundle(List<Bundle> bundle) {
        this.bundle = bundle;
    }

    @Override
    public String toString() {

        String s = "";
        for (String s1 : roles) {
            s += s1;
        }

        return name + "\n" +
                description + "\n" +
                isList + "\n" +
                type + "\n" +
                bundle + "\n" +
                s;

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getDescription());
        out.writeObject(this.getisList());
        out.writeObject(this.getType());
        out.writeObject(this.getBundle());
        out.writeObject(this.getRoles());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        description = (String) in.readObject();
        isList = (boolean) in.readObject();
        type = (String) in.readObject();
        bundle = (List<Bundle>) in.readObject();
        roles = (List<String>) in.readObject();

    }

}
