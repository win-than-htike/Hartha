package xyz.winthan.hartha.data.vos;

import java.io.Serializable;

/**
 * Created by winthanhtike on 10/2/17.
 */

public class CategoryVO implements Serializable {

    private String desc;

    private String name;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
