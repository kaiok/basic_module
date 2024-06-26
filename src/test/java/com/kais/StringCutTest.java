package com.kais;

import com.kais.stream.User;
import com.kais.stream.UserDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kais
 * @date 2022.05.08. 22:03
 */
public class StringCutTest {

    public static void main(String[] args) {

        String string = "12.0/%(3/889)";

        Integer integer = string.indexOf("%");

        String str = string.substring(0,integer);
        String str2 = string.substring(integer);
        String string2 = null;
        String string3 = null;

        for (int i = 0; i < string.length(); i++) {
            System.out.println(Integer.valueOf(string.charAt(i)));
            Integer index;

            if(string.charAt(i) != 46 && (string.charAt(i) < 48 || string.charAt(i) > 57)){
                index = string.indexOf(string.charAt(i));
                System.out.println("--------");
                System.out.println(string.charAt(i));
                string2 = string.substring(0,index);
                string3 = string.substring(index);
                System.out.println("string2 = " + string2);
                System.out.println("string2 = " + string3);
                return;
            }

        }


        System.out.println(str);
        System.out.println(str2);

        System.out.println("-------------");
        Map<Object, Object> objectObjectMap = new HashMap<>();
        User user = new User(12, "asd", 12, "nan", "sdsd", "sdsa");
        UserDTO sds = new UserDTO(12, "sds", 12);
        objectObjectMap.put("key1",user);
        objectObjectMap.put("key2",sds);
        System.out.println(objectObjectMap.get("key1"));
        System.out.println(objectObjectMap.get("key2"));

    }

}
