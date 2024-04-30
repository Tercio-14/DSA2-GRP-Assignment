import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // Create a Star instance
        Star network = new Star();
        ServerNode serverNode = network.getServerNode();
        List<ClientNode> clientNodes = serverNode.getClientNodes();

        // Test adding client nodes
        ClientNode client1 = new ClientNode("Client1", serverNode);
        ClientNode client2 = new ClientNode("Client2", serverNode);
        ClientNode client3 = new ClientNode("Client3", serverNode);

        // Check if client nodes were added correctly
        System.out.println("Initially added clients: " + clientNodes);

        // Test removing a client node
        network.deleteNode(client2);
        System.out.println("After removing Client2: " + clientNodes);

        // Test sending messages
        client1.send("Hello from Client1", "Client3");
        client3.send("Hi Client1, this is Client3", "Client1");

        // Test adding a new client node after removing one
        ClientNode client4 = new ClientNode("Client4", serverNode);
        System.out.println("After adding Client4: " + clientNodes);
    }
}

//Code in our main class, creates a Star network, get the ServerNode instance from it, 
//and then manipulates the network by adding/removing client nodes and testing message exchange between them.
