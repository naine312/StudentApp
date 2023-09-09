public class Student {
    private int Sid;
    private String Name;
    private int Sphone;
    private String Area;


    public Student() {

    }

    public Student(int sid, String name, int sphone, String area) {
        super();
        Sid = sid;
        Name = name;
        Sphone = sphone;
        Area = area;
    }
    public Student(String name, int sphone, String area) {
        super();
        Name = name;
        Sphone = sphone;
        Area = area;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSphone() {
        return Sphone;
    }

    public void setSphone(int sphone) {
        Sphone = sphone;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sid=" + Sid +
                ", Name='" + Name + '\'' +
                ", Sphone=" + Sphone +
                ", Area='" + Area + '\'' +
                '}';
    }
}
