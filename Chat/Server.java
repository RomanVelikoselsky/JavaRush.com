package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by v.roman on 12.07.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не доставлено: " + clientName);
            }
        }
    }

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String clientName = null;

            // Запускаем логику
            try (Connection connection = new Connection(socket)) {
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while communicating");
            } finally {
                if (clientName != null) {
                    connectionMap.remove(clientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");
                }
            }
        }

        // Рукопожатие
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                // Запрос и получение имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                // Проверка на отсутсвии с списке подключений и null, добавляем в map
                if (message.getType() == MessageType.USER_NAME) {
                    if (!(message.getData().isEmpty())) {
                        if (!(connectionMap.containsKey(message.getData()))) {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        // Отправляем юзеру инфу об остальных участниках
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String user : connectionMap.keySet()) {
                if (!(userName.equals(user))) {
                    connection.send(new Message(MessageType.USER_ADDED, user));
                }
            }
        }

        // Обработка сообщений сервером
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message clientMessage = connection.receive();

                if (clientMessage.getType() == MessageType.TEXT) {
                    String s = userName + ": " + clientMessage.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, s));
                } else {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            ConsoleHelper.writeMessage("Сервер запущен.");

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
