public class Star {
    private ServerNode serverNode;

    public Star() {
        serverNode = new ServerNode();
    }

    public void insertNode(ClientNode node) {
        serverNode.addClientNode(node);
    }

    public void deleteNode(ClientNode node) {
        serverNode.removeClientNode(node);
    }
    
    // Method to get server node (for use in MainClass)
    public ServerNode getServerNode() {
        return serverNode;
    }
}
