package models;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class SuperObject {
    public SuperObject() {
    }

    public SuperObject(LinkedHashMap<Field,Object> inputs) {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.getName() != "id") {
                    field.set(this, inputs.get(field));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
