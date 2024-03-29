package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// 演示 Gson 的用法
public class TestGson {
    static class Student {
        private String name;
        private int id;
        private double score;

        public Student(String name, int id, double score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }
    }

    static class Test {
        private String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // 1. 实例化 Gson 对象 (工厂模式)
        Gson gson = new GsonBuilder().create();
        // 2. 把一个对象转成 JSON 字符串.
//        Student student = new Student("张三", 33, 59.5);
//        String jsonString = gson.toJson(student);
//        System.out.println(jsonString);
        // 3. 把一个 JSON 字符串转回成一个对象
        String str = "{\"name\":\"张三\",\"id\":33,\"score\":59.5}";
        Student s = gson.fromJson(str, Student.class);
        System.out.println(s.id + ", " + s.name + ", " + s.score);
    }
}
