public class Person {

    private int code;
    private String name;

    public Person(final int code, final String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() { return code; }

    public void setCode(final int code) { this.code = code; }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }
}
