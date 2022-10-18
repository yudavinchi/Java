public class User {
    private String name;
    private int id;
    private boolean isActivated;

    public User(String name, int id, boolean isActivated)
    {
        this.name = name;
        this.id = id;
        this.isActivated = isActivated;
    }

    public int getId(){
        return id;
    }

    public boolean isActivated(){
        return isActivated;
    }

}
