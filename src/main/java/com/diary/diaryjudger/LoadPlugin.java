package com.diary.diaryjudger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class LoadPlugin {
    private final Main plugin;

    public LoadPlugin(Main plugin) {
        this.plugin = plugin;
    }

    public boolean isLoad() {
        say(" ");
        say("��3   ___      ___      ___      ___      ___      ___   ");
        say("��3  /\\  \\    /\\__\\    /\\  \\    /\\  \\    /\\  \\    /\\  \\  ");
        say("��3 _\\:\\  \\  /:/ _/_  /::\\  \\  /::\\  \\  /::\\  \\  /::\\  \\ ");
        say("��3/\\/::\\__\\/:/_/\\__\\/:/\\:\\__\\/:/\\:\\__\\/::\\:\\__\\/::\\:\\__\\");
        say("��3\\::/\\/__/\\:\\/:/  /\\:\\/:/  /\\:\\:\\/__/\\:\\:\\/  /\\;:::/  /");
        say("��3 \\/__/    \\::/  /  \\::/  /  \\::/  /  \\:\\/  /  |:\\/__/ ");
        say("��3           \\/__/    \\/__/    \\/__/    \\/__/    \\|__|");
        say(" ");
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

    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
