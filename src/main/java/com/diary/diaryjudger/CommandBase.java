package com.diary.diaryjudger;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CommandBase implements TabExecutor {
    private final Main plugin;

    public CommandBase(Main plugin) {
        this.plugin = plugin;
    }

    //����ʵ��
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length) {
            case 0:
                commandSender.sendMessage(" ");
                commandSender.sendMessage("��3@" + commandSender.getName() + "��8 ��ӭʹ��DiaryJudger!");
                commandSender.sendMessage(" ");
                commandSender.sendMessage(" ");
                commandSender.sendMessage("��7[����]:��f/DiaryJudger:diajdg ��8[...]");
                commandSender.sendMessage("  ��7- ��fexcute <request> <player>");
                commandSender.sendMessage("    ��7Ϊָ�����ִ��ָ����");
                commandSender.sendMessage("  ��7- ��freload");
                commandSender.sendMessage("    ��7���ز��");
                commandSender.sendMessage(" ");
                return true;
            case 1:
                if (strings[0].equalsIgnoreCase("reload") && commandSender.hasPermission("diaryjudger.reload")) {
                    this.plugin.initRequest();
                    commandSender.sendMessage("");
                    commandSender.sendMessage("��3������سɹ�");
                    commandSender.sendMessage("");
                }
                return true;
            case 2:
                if (strings[0].equalsIgnoreCase("excute") && commandSender.hasPermission("diaryjudger.excute")) {
                    if (this.plugin.requsetlist.contains(strings[1])) {
                        String papi = PlaceholderAPI.setPlaceholders(Bukkit.getPlayer(commandSender.getName()), this.plugin.getConfig().getString("Request." + strings[1] + ".papi"));
                        for (String t : this.plugin.getConfig().getConfigurationSection("Request." + strings[1] + ".case").getKeys(false)) {
                            if (papi.equals(t)) {
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), this.plugin.getConfig().getString("Request." + strings[1] + ".case." + t).replace("%player%", commandSender.getName()));
                            }
                        }
                    } else {
                        commandSender.sendMessage("");
                        commandSender.sendMessage("��3��ָ���鲻����!");
                        commandSender.sendMessage("");
                    }
                }
                return true;
            case 3:
                if (strings[0].equalsIgnoreCase("excute") && commandSender.hasPermission("diaryjudger.excuteother")) {
                    if (this.plugin.requsetlist.contains(strings[1])) {
                        String papi = PlaceholderAPI.setPlaceholders(Bukkit.getPlayer(strings[2]), this.plugin.getConfig().getString("Request." + strings[1] + ".papi"));
                        for (String t : this.plugin.getConfig().getConfigurationSection("Request." + strings[1] + ".case").getKeys(false)) {
                            if (papi.equals(t)) {
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), this.plugin.getConfig().getString("Request." + strings[1] + ".case." + t).replace("%player%", strings[2]));
                            }
                        }
                    } else {
                        commandSender.sendMessage("");
                        commandSender.sendMessage("��3��ָ���鲻����!");
                        commandSender.sendMessage("");
                    }
                }
                return true;
        }
        commandSender.sendMessage(" ");
        commandSender.sendMessage("��3@" + commandSender.getName() + "��8 ��ӭʹ��DiaryJudger!");
        commandSender.sendMessage(" ");
        commandSender.sendMessage(" ");
        commandSender.sendMessage("��7[����]:��f/DiaryJudger:diajdg ��8[...]");
        commandSender.sendMessage("  ��7- ��fexcute <request>");
        commandSender.sendMessage("    ��7ִ��ָ����");
        commandSender.sendMessage("  ��7- ��fexcute <request> <player>");
        commandSender.sendMessage("    ��7Ϊָ�����ִ��ָ����");
        commandSender.sendMessage("  ��7- ��freload");
        commandSender.sendMessage("    ��7���ز��");
        commandSender.sendMessage(" ");
        return false;
    }

    //������ʾ
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length) {
            case 1:
                List<String> list = new ArrayList<>();
                list.add("reload");
                list.add("excute");
                return list;
            case 2:
                if (!Objects.equals(strings[0], "reload")) {
                    return this.plugin.requsetlist;
                }
            default:
                return null;
        }
    }

}
