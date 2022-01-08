package com.xppty.testbotproject;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        String token = "TOKEN";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // İnvite bot
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!invite")) {
                EmbedBuilder embed1 = new EmbedBuilder()
                        .setDescription("Beni sunucuna çağır!\n" + "İşte link : " + api.createBotInvite())
                        .setColor(Color.BLUE);

                event.getChannel().sendMessage(embed1);
                event.addReactionToMessage("👍");
            }
        });

        // Welcome message.
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("Selam")) {
                event.getChannel().sendMessage("Selam, hoşgeldin!");
            }
        });

        System.out.println("Bot aktifleştirildi!");
    }

