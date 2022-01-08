package com.xppty.testbotproject;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.Messageable;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        String token = "TOKEN";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // İnvite bot
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!invite")) {
                EmbedBuilder embed1 = new EmbedBuilder()
                        .setDescription("My invite your server!!\n" + "This link : " + api.createBotInvite())
                        .setColor(Color.BLUE);

                User user = event.getMessageAuthor().asUser().get();
                user.sendMessage(embed1);
                event.getChannel().sendMessage("Davet linki özel mesaj kutunuza gönderilmiştir.");
                event.addReactionToMessage("👍");
            }
        });

        // Welcome message.
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("Selam")) {
                event.getChannel().sendMessage("Selam, hoşgeldin!");
            }
        });

        api.addMessageCreateListener(event -> {
             if (event.getMessageContent().equalsIgnoreCase("")) {}
        });

        System.out.println("Bot aktifleştirildi!");
    }

}
