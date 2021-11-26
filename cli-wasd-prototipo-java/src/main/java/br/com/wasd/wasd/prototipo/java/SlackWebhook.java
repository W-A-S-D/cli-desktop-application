package br.com.wasd.wasd.prototipo.java;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class SlackWebhook {

    private static String HostnameURL = "";
    private static String PedidoURL = "";
    private static String AlertaURL = "";

    private static String slackChannel = "";

    public static void sendMessageToSlackHostnameURL(String message) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);

            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(HostnameURL, payload);

            //System.exit(0);  // MATA A APLICACAO;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendMessageToSlackAlertaURL(String message) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);

            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(AlertaURL, payload);

            //System.exit(0);  // MATA A APLICACAO;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendMessageToSlackPedidoURL(String message) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);

            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(PedidoURL, payload);

            //System.exit(0);  // MATA A APLICACAO;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
