/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class SlackMessage {

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

    public SlackMessage() {
    }

    public static String getHostnameURL() {
        return HostnameURL;
    }

    public static void setHostnameURL(String HostnameURL) {
        SlackMessage.HostnameURL = HostnameURL;
    }

    public static String getPedidoURL() {
        return PedidoURL;
    }

    public static void setPedidoURL(String PedidoURL) {
        SlackMessage.PedidoURL = PedidoURL;
    }

    public static String getAlertaURL() {
        return AlertaURL;
    }

    public static void setAlertaURL(String AlertaURL) {
        SlackMessage.AlertaURL = AlertaURL;
    }

    public static String getSlackChannel() {
        return slackChannel;
    }

    public static void setSlackChannel(String slackChannel) {
        SlackMessage.slackChannel = slackChannel;
    }
    
    
}
