package com.itheima.demo8test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    //4.准备一个集合容器:存储全部上架的电影数据
    private static List<Movie> movies = new ArrayList<>();//静态成员变量
    private static Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            //3.准备操作界面
            System.out.println("---------电影上架系统---------");
            System.out.println("1.上架电影");
            System.out.println("2.下架电影");
            System.out.println("3.查询电影");
            System.out.println("4.封杀电影明星");
            System.out.println("5.退出系统");
            System.out.println("请你输入操作");
            String command = sc.next();
            switch (command) {
                case "1":
                    addMovie();
                    //上架电影
                    break;
                case "2":
                    //下架电影
                    break;
                case "3":
                    //查询电影
                    qyeryMovie();
                    break;
                case "4":
                    //封杀电影明星
                    break;
                case "5":
                    System.out.println("欢迎下次光临");
                    return;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
    }

    private void qyeryMovie() {
        System.out.println("=========查询电影============");
        System.out.println("请输入电影名称:");
        String name = sc.next();
        Movie movie = queryMovie(name);
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("没有找到该电影");
        }
    }
    //根据电影名称查询电影对象返回
    public Movie queryMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;//找到
            }
        }
        return null;//没有找到
    }

    private void addMovie() {
        System.out.println("请输入电影名称:");
        String name = sc.next();
        System.out.println("请输入电影评分:");
        double score = sc.nextDouble();
        System.out.println("请输入电影主演:");
        String actor = sc.next();
        System.out.println("请输入电影价格:");
        double price = sc.nextDouble();
        Movie movie = new Movie(name, score, actor, price);
        movies.add(movie);
        System.out.println("添加成功");
    }
}
