package com.example.SecKillSys.util;

import com.example.SecKillSys.enums.UserType;
import com.example.SecKillSys.po.BuildingAdmin;
import com.example.SecKillSys.po.StuAdmin;
import com.example.SecKillSys.po.Student;
import com.example.SecKillSys.vo.UserVO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: rich
 * @date: 2022/10/13 20:28
 * @description:
 */
public class BaseUtil {

    /**
     * @param source: 需要被转换的原数据
     * @param tClass: 需要转换成的目标类型
     * @return: E
     * @author: rich
     * @date: 2022/10/13 21:11
     * @description: 当属性类型和名字和source属性相同的情况下，将source的属性赋值给另一个类型，返回新类型的一个对象
     */
    public static <T, E>  E copyProperties(T source, Class<E> tClass) throws Exception {
        if (source == null ) throw new Exception("源类型为空");

        Class<?> sClass = source.getClass();
        Field[] sFields = sClass.getDeclaredFields();
        Field[] tFields = tClass.getDeclaredFields();
        E target;
        try {
            target = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("目标对象创建失败");
        }

        for (Field sField : sFields) {
            for (Field tField : tFields) {
                // 名字和属性都一样的情况下赋值
                if (sField.getName().equals(tField.getName()) && sField.getGenericType().equals(tField.getGenericType())) {
                    try {
                        // 获取源对象的属性名，将属性名首字母大写，拼接如：getUsername、getId的字符串
                        String sName = sField.getName();
                        char[] sChars = sName.toCharArray();
                        sChars[0] -= 32;
                        String sMethodName = "get" + String.valueOf(sChars);
                        // 获得属性的get方法
                        Method sMethod = sClass.getMethod(sMethodName);
                        // 调用get方法
                        Object sFieldValue = sMethod.invoke(source);

                        // 获取目标对象的属性名，将属性名首字母大写，拼接如：setUsername、setId的字符串
                        String tName = tField.getName();
                        char[] tChars = tName.toCharArray();
                        tChars[0] -= 32;
                        String tMethodName = "set" + String.valueOf(tChars);
                        // 获得属性的set方法
                        Method tMethod = tClass.getMethod(tMethodName, tField.getType());
                        // 调用方法，并将源对象get方法返回值作为参数传入
                        tMethod.invoke(target, sFieldValue);

                        break;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        throw new Exception("转换失败");
                    }
                }
            }
        }
        return target;
    }

    /**
     * @param source: 需要被转成User的对象
     * @return: com.example.SecKillSys.vo.UserVO
     * @author: rich
     * @date: 2022/10/13 21:11
     * @description: 将三种类型转换为user类型
     */
    public static UserVO changeToUser(Object source) throws Exception {
        if (source instanceof Student) {
            UserVO userVO = copyProperties(source, UserVO.class);
            userVO.setUserType(UserType.valueOf("1"));
            return userVO;
        }
        else if (source instanceof StuAdmin) {
            UserVO userVO = copyProperties(source, UserVO.class);
            userVO.setUserType(UserType.valueOf("2"));
            return userVO;
        }
        else if (source instanceof BuildingAdmin) {
            UserVO userVO = copyProperties(source, UserVO.class);
            userVO.setUserType(UserType.valueOf("3"));
            return userVO;
        }
        return null;
    }

}
