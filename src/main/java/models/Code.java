package models;

import java.util.List;

public class Code {
    String code;
    String name;

    public Code(){

    }
    public Code(List<String> strings ){
        code = strings.get(0);
        name= strings.get(1);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +" - "+ code;
    }
}
