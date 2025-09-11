package model;

public class Data {
    private int id;
    private String fileName;
    private String path;
    private String email;

    public Data(int id, String fileName, String path) {

        this.fileName = fileName;
        this.id = id;
        this.path = path;
    }

    public Data(int id, String fileName, String path, String email) {
        this.email = email;
        this.fileName = fileName;
        this.id = id;
        this.path = path;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
