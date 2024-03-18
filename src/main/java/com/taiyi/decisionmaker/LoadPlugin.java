package com.taiyi.decisionmaker;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class LoadPlugin {
    private final DecisionMaker plugin;

    public LoadPlugin(DecisionMaker plugin) {
        this.plugin = plugin;
    }

    public boolean isLoad() {
        say(" ");
        say("��3DecisionMaker by Taiyi @onLoad");
        say("��7  ���ڼ��������ļ�...");
        say("��7  �����ļ��������!");
        say(" ");
        this.plugin.getCommand("decisionmaker").setExecutor(new CommandBase(this.plugin));
        this.plugin.getCommand("decisionmaker").setTabCompleter(new CommandBase(this.plugin));
        return true;
    }

    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
