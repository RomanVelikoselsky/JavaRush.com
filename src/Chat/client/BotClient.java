package Chat.client;

import Chat.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by v.roman on 12.07.2017.
 */
public class BotClient extends Client {
    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            SimpleDateFormat simpleDateFormat = null;
            String messageName = "";
            String messageData;

            if (message.contains(": ")) {
                String[] splitMessage = message.split(": ", 2);
                messageName = splitMessage[0];
                messageData = splitMessage[1];

                if (messageData.equals("дата")) simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                else if (messageData.equals("день")) simpleDateFormat = new SimpleDateFormat("d");
                else if (messageData.equals("месяц")) simpleDateFormat = new SimpleDateFormat("MMMM");
                else if (messageData.equals("год")) simpleDateFormat = new SimpleDateFormat("YYYY");
                else if (messageData.equals("время")) simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                else if (messageData.equals("час")) simpleDateFormat = new SimpleDateFormat("H");
                else if (messageData.equals("минуты")) simpleDateFormat = new SimpleDateFormat("m");
                else if (messageData.equals("секунды")) simpleDateFormat = new SimpleDateFormat("s");
            }

            if (simpleDateFormat != null) {
                sendTextMessage("Информация для " + messageName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
            }

        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
