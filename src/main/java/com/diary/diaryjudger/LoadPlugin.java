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
        say("��3DiaryJudgerV"+this.plugin.getDescription().getVersion()+" by Taiyi ��a@onLoad");
        say("��8  ��ʼ���������ļ�...");
        this.plugin.saveDefaultConfig();
        say("��7  �����ļ��������!");
        say("��8  ��ʼע��������...");
        CommandBase commandBase = new CommandBase(this.plugin);
        this.plugin.getCommand("diaryjudger").setExecutor(commandBase);
        say("��7  �������ע�����!");
        say("��8  ��ʼע��������ʾ����7...");
        this.plugin.getCommand("diaryjudger").setTabCompleter(commandBase);
        say("��7  ������ʾ��ע�����!");
        say(" ");
        return true;
    }

    public static void say(String... s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
