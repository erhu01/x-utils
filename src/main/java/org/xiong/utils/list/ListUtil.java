package org.xiong.utils.list;

import org.xiong.others.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：ZhangYiXiong
 * @date ：Created in 2022/4/7 星期四 14:13
 * @description：
 * @modified By：
 * @version:
 */
public class ListUtil <T>{

    private List<T> list = new ArrayList<>();
    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ list是不是空的
     * create time: 2022/4/7 14:30
     * @params
     * @return
     */
    public static boolean isNull(List list){
        if (null == list){
            return true;
        }else {
            return false;
        }

    }

    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ list是不是空的
     * create time: 2022/4/7 14:30
     * @params
     * @return
     */
    public static boolean isNotNull(List list){
        if (null == list){
            return false;
        }else {
            return true;
        }
    }

    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ list是不是空的
     * create time: 2022/4/7 14:30
     * @params
     * @return
     */
    public static boolean isEmpty(List list){
        if (isNull(list)){
            return true;
        }
        if (list.size()<=0){
            return true;
        }
        return false;
    }

    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ list是不是空的
     * create time: 2022/4/7 14:30
     * @params
     * @return
     */
    public static boolean isNotEmpty(List list){
        if (isNull(list)){
            return false;
        }
        if (list.size()<=0){
            return false;
        }
        return true;
    }


    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ 第二个list中有些是list里面有的
     * 如果是基本数据类型或者string,比较的数值,如果是其他的自定义类型,比较的是两元素的地址,如果想要改变对比规则,需要重写equals方法
     * create time: 2022/4/7 14:29
     * @params 
     * @return 
     */
    public static<T> List<T> filter(List<T>list1,List<T> list2){
        return list1.stream().filter(word -> !list2.contains(word)).collect(Collectors.toList());
    }

    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ 两个list取交集
     * 如果是基本数据类型或者string,比较的数值,如果是其他的自定义类型,比较的是两元素的地址,如果想要改变对比规则,需要重写equals方法
     * create time: 2022/4/7 14:29
     * @params
     * @return
     */
    public static<T> List<T> intersection(List<T>list1,List<T> list2){
        return list1.stream().filter(word -> list2.contains(word)).collect(Collectors.toList());
    }

    /**
     * create by: ZhangYiXiong
     * description: 功能说明→ 两个list之间的差集
     * 如果是基本数据类型或者string,比较的数值,如果是其他的自定义类型,比较的是两元素的地址,如果想要改变对比规则,需要重写equals方法
     * create time: 2022/4/7 14:54
     * @params 
     * @return 
     */
    public static<T> List<T> difference(List<T>list1,List<T> list2){
        List<T> l1 = list1.stream().filter(word -> !list2.contains(word)).collect(Collectors.toList());
        List<T> l2 = list2.stream().filter(word -> !list1.contains(word)).collect(Collectors.toList());
        if (isEmpty(l1)){
            return l2;
        }
        l1.addAll(l2);
        return l1;
    }



    public static void main(String[] args) {
        //List<> list = new ArrayList<>();
        /*List<Integer> list = new ArrayList<>();
        System.out.println(ListUtil.isEmpty(list));
        System.out.println(ListUtil.isNotNull(list));
        System.out.println(ListUtil.isNull(list));
        list.add(12);
        System.out.println(ListUtil.isNotEmpty(list));*/

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list = filter(list1,list2);
        List<Integer> list4 = filter(list2,list1);
        System.out.println(list4);
        System.out.println(list);
        List<Integer> list3 = intersection(list1,list2);
        System.out.println(list3);

        List<Integer> difference = difference(list1, list2);
        System.out.println(difference);

        Person person1 = new Person();
        person1.setId(1);
        Person person2 = new Person();
        person2.setId(2);
        Person person3 = new Person();
        person3.setId(3);
        List<Person> lp1 = new ArrayList<>();

        Person person4 = new Person();
        person4.setId(4);

        lp1.add(person1);
        lp1.add(person2);
        lp1.add(person3);

        List<Person> lp2 = new ArrayList<>();
        lp2.add(person1);
        lp2.add(person2);
        lp2.add(person4);

        Person person5 = new Person();
        person5.setId(1);
        person5.setName("asdfa");
        lp2.add(person5);
        // List<Person> difference1 = difference(lp1, lp2);
        // System.out.println(difference1);
        //System.out.println(intersection(lp1, lp2));
        //System.out.println(difference(lp2, lp1));
        System.out.println(intersection(lp2, lp1));
        System.out.println(difference(lp2, lp1));

    }



}
