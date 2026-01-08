package com.kuaiyukuaikuai.demo4proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star implements StarService {
    private String name;

    @Override
    public void sing(String songname) {
        System.out.println(this.name + "正在唱歌"+ songname);
    }

    @Override
    public String dance(String wudaoname) {
        System.out.println(name + "正在跳舞...");
        return "跳舞成功";
    }
}
