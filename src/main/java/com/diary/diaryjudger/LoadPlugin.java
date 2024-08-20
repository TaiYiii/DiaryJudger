package com.diary.diaryjudger;

import org.bukkit.Bukkit;

import static com.diary.diaryjudger.Main.logo;

public class LoadPlugin {
    private final Main plugin;

    public LoadPlugin(Main plugin) {
        this.plugin = plugin;
    }

    public boolean isLoad() {
        say(logo);
        say("§3DiaryJudgerV"+this.plugin.getDescription().getVersion()+" by Taiyi §a@onLoad");
        say("§8  开始加载配置文件...");
        this.plugin.saveDefaultConfig();
        say("§7  配置文件加载完毕!");
        say("§8  开始注册插件命令...");
        CommandBase commandBase = new CommandBase(this.plugin);
        this.plugin.getCommand("diaryjudger").setExecutor(commandBase);
        say("§7  插件命令注册完毕!");
        say("§8  开始注册命令提示器§7...");
        this.plugin.getCommand("diaryjudger").setTabCompleter(commandBase);
        say("§7  命令提示器注册完毕!");
        say(" ");
        return true;
    }

    public static void say(String... s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
