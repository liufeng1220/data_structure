package 非线性结构.哈希表;

import org.testng.annotations.Test;
import 排序算法.CommonUtils;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * 当一个任意数取模一个数时，取模得到的值只会小于那个数。
 * 如 n%5 = 结果只会是 0,1,2,3,4中产生
 * <p>
 * 介绍：
 * 散列表（Hash table，也叫哈希表），是根据关键码值(Key value)而直接进行访问的数据结构。也就是说，它通
 * 过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组
 * 叫做散列表。
 * <p>
 * 思路：
 * 使用多条链表存储数据
 * 通过HashTable类的 链表数组 来管理多条链表，每次通过 散列函数 来判断当前数据该存入哪一条链表，以此来加快存储，读取 速度。
 * 读取也是通过 散列函数来判断该去哪一条链表去读取数据
 * <p>
 * <p>
 * <p>
 * Created by liufeng on 2020/7/3 9:32
 */
public class HashTabDemo {
    @Test
    public void test1() {
        HashTable hashTable = new HashTable(7);
        hashTable.list();
        hashTable.add(new Employee(34, "张三"));
        hashTable.add(new Employee(21, "李四"));
        hashTable.add(new Employee(271, "王五"));
        System.out.println("=====================");
        hashTable.list();
        hashTable.findEmployee(271);
    }

}

//创建HashTable管理多条链表
class HashTable {
    private EmployeeLinkedList[] employeeLinkedList;
    //表示有多少条链表
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.employeeLinkedList = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedList[i] = new EmployeeLinkedList();
        }
    }

    /**
     * 添加雇员的方法
     *
     * @param employee
     */
    public void add(Employee employee) {
        int hashId = hashFun(employee.id);

        employeeLinkedList[hashId].add(employee);
    }

    /**
     * 遍历链表
     */
    public void list() {
        for (int i = 0; i < employeeLinkedList.length; i++) {
            employeeLinkedList[i].list(i);
        }
    }

    /**
     * 通过雇员id查找雇员所在位置
     *
     * @param id
     */
    public void findEmployee(int id) {
        int i = hashFun(id);
        employeeLinkedList[i].findEmployee(i, id);
    }

    /**
     * 散列函数，简单取模法
     * function:
     * n%5 取模的结果为 0,1,2,3，4
     * 故此取模得到的结果一定是在数组链表范围内
     *
     * @param id 要添加雇员的id
     * @return
     */
    public int hashFun(int id) {
        return id % this.size;
    }
}

//链表类
class EmployeeLinkedList {
    //默认null,指向第一个emp节点
    private Employee head;

    /**
     * 通过员工id查找雇员
     *
     * @param hashId 链表号
     * @param id     员工id
     */
    public void findEmployee(int hashId, int id) {
        if (head == null) {
            System.out.println("没有这个员工");
            return;
        }
        Employee temp = this.head;
        while (true) {
            if (temp.id == id) {
                System.out.println("找到了，在第" + hashId + "条链表中找到了id为" + id + "的" + temp.name);
                break;
            }
            if (temp.next == null) {
                System.out.println("没有这个员工");
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 添加雇员
     *
     * @param employee
     */
    public void add(Employee employee) {
        //是否是第一个雇员
        if (head == null) {
            this.head = employee;
            return;
        }
        Employee curEmployee = head;
        while (true) {
            if (curEmployee.next == null) {
                curEmployee.next = employee;
                break;
            }
            curEmployee = curEmployee.next;
        }
    }


    /**
     * 遍历雇员信息
     *
     * @param i 第几条链表
     */
    public void list(int i) {
        if (head == null) {
            System.out.println("当前集合是空第" + i + "链表的没有雇员");
            return;
        }
        Employee employee = head;
        while (true) {
            System.out.printf("当前第%d条链表雇员信息id=%d,name=%s\n", i, employee.id, employee.name);
            if (employee.next == null) {
                break;
            }
            employee = employee.next;
        }
    }
}

//雇员类
class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
