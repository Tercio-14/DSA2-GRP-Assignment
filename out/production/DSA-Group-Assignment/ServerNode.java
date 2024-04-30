import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ServerNode {
    private List<ClientNode> clientNodes;

    public ServerNode() {
        clientNodes = new ArrayList<>();
    }

    public void addClientNode(ClientNode node) {
        clientNodes.add(node);
    }

    public void removeClientNode(ClientNode node) {
        clientNodes.remove(node);
    }

    public void broadcastMessage(String message, String senderId) {
        // Compress the message before sending
        byte[] compressedMessage = CompressionUtils.compress(message);
        String compressedMessageString = Base64.getEncoder().encodeToString(compressedMessage);
        for (ClientNode node : clientNodes) {
            if (!node.getId().equals(senderId)) {
                node.receive(message, senderId);
            }
        }
    }
    
    // Method to get client nodes (for use in MainClass)
    public List<ClientNode> getClientNodes() {
        return clientNodes;
    }
}
