package com.diary.diaryjudger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {
    public static Main diaryjudger;
    List<String> requsetlist = new ArrayList<>();
    public static final String[] logo = new String[]{
            "",
            "§3   ___      ___      ___      ___      ___      ___   ",
            "§3  /\\  \\    /\\__\\    /\\  \\    /\\  \\    /\\  \\    /\\  \\  ",
            "§3 _\\:\\  \\  /:/ _/_  /::\\  \\  /::\\  \\  /::\\  \\  /::\\  \\ ",
            "§3/\\/::\\__\\/:/_/\\__\\/:/\\:\\__\\/:/\\:\\__\\/::\\:\\__\\/::\\:\\__\\",
            "§3\\::/\\/__/\\:\\/:/  /\\:\\/:/  /\\:\\:\\/__/\\:\\:\\/  /\\;:::/  /",
            "§3 \\/__/    \\::/  /  \\::/  /  \\::/  /  \\:\\/  /  |:\\/__/ ",
            "§3           \\/__/    \\/__/    \\/__/    \\/__/    \\|__|",
            ""
    };

    public Main() {
    }

    @Override
    public void onEnable() {
        diaryjudger = this;
        LoadPlugin loadPlugin = new LoadPlugin(this);
        if (!loadPlugin.isLoad()) {
            say(" ");
            say("§3DiaryJudgerV"+this.getDescription().getVersion()+" by Taiyi §a@onError");
            say("§4  Code: 插件加载错误!");
            say(" ");
            this.getServer().getPluginManager().disablePlugin(this);
        }
        this.initRequest();
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        say(logo);
        say("§3DiaryJudgerV"+this.getDescription().getVersion()+" by Taiyi §a@onDisable");
        say("§7  Code: 插件卸载成功,感谢使用!");
        say(" ");
    }

    /**
     * 初始化请求列表
     */
    public void initRequest(){
        this.reloadConfig();
        this.requsetlist.clear();
        this.requsetlist.addAll(this.getConfig().getConfigurationSection("Request").getKeys(false));
    }

    public static void say(String... s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
