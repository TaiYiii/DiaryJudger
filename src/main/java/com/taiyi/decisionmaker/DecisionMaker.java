package com.taiyi.decisionmaker;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class DecisionMaker extends JavaPlugin {
    public static DecisionMaker decisionMaker;
    List<String> requsetlist = new ArrayList<>();

    public DecisionMaker() {
    }

    @Override
    public void onEnable() {
        decisionMaker = this;
        this.saveDefaultConfig();
        LoadPlugin loadPlugin = new LoadPlugin(this);
        if (!loadPlugin.isLoad()) {
            say(" ");
            say("§3DecisionMaker by Taiyi @onDisable");
            say("§4  加载错误!");
            say(" ");
            this.getServer().getPluginManager().disablePlugin(this);
        }
        this.initRequest();
    }

    public void initRequest(){
        this.reloadConfig();
        this.requsetlist.clear();
        this.requsetlist.addAll(this.getConfig().getConfigurationSection("Request").getKeys(false));
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        say(" ");
        say("§3DecisionMaker by Taiyi @onDisable");
        say("§7  感谢使用!");
        say(" ");
    }

    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
