package com.youn.have;

public class EnumTest {

    public static void main(String[] args) {
        Bank bk = Bank.valueOf("ICBC");
        System.out.println(bk.getName());
    }

}

enum Bank {
    ICBC("中国工商银行"), BC("不存");

    private String name;

    private Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
