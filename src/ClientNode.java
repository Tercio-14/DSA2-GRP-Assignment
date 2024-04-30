import java.util.Base64;

public class ClientNode {
    private String id;
    private ServerNode serverNode;

    public ClientNode(String id, ServerNode serverNode) {
        this.id = id;
        this.serverNode = serverNode;
        serverNode.addClientNode(this);
    }

    public String getId() {
        return id;
    }

    public void send(String message, String recipientId) {
        // Compress the message before sending
        byte[] compressedMessage = CompressionUtils.compress(message);
        String compressedMessageString = Base64.getEncoder().encodeToString(compressedMessage);

        System.out.println("Client " + id + " sent a compressed message: " + compressedMessageString);
        serverNode.broadcastMessage(compressedMessageString, id);
    }

    public void receive(String compressedMessageString, String senderId) {
        System.out.println("Client " + id + " received a compressed message: " + compressedMessageString);

        // Decompress the received message
        String decompressedMessage = CompressionUtils.decompress(compressedMessageString);
        System.out.println("Client " + id + " received message from " + senderId + ": " + decompressedMessage);
    }
}