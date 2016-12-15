package cn.dayu.slmap.bean;

import android.util.Log;

import cn.dayu.slmap.common.ConStant;

/**
 * Created by chuan on 16/12/15.
 */

public class Person implements Comparable<Person> {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person another) {
        String msg = "name:" + name + "another.name:" + another.name;
        int i = name.compareTo(another.name); //比较名字字符串
        msg += i;
        if (i == 0) { //如果名字一样，则继续比较年龄
            msg += "age:" + name + "another.age:" + another.age;
            i = age - another.age;
            msg += i;
        }
        Log.e(ConStant.tag, "listcompareTo"+msg);
        return i;
    }
}