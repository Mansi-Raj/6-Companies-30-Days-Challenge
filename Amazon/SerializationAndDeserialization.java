package Amazon;

public class SerializationAndDeserialization {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("null,");
        } else {
            result.append(node.val).append(","); // Append the value of the node
            serializeHelper(node.left, result);
            serializeHelper(node.right, result);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        return deserializeHelper(dataArr, new int[] { 0 });
    }

    private TreeNode deserializeHelper(String[] dataArray, int[] index) {
        if (index[0] >= dataArray.length || dataArray[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataArray[index[0]]));
        index[0]++;
        node.left = deserializeHelper(dataArray, index);
        node.right = deserializeHelper(dataArray, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root)); {
