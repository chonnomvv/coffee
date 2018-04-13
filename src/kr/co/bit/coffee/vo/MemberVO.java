package kr.co.bit.coffee.vo;

public class MemberVO {
    private String id;
    private String name;
    private String pw;
    private String birth;
    private String zipcode;
    private String lang;
    private String tool;

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                ", birth='" + birth + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", lang='" + lang + '\'' +
                ", tool='" + tool + '\'' +
                '}';
    }

    public MemberVO() {

    }
}
