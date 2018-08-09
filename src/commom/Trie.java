package commom;

/**
 * 普通——字典树
 *
 * @author gzs11641
 */
public class Trie {
    private static final int SIZE = 10;
    private static final char FIRST_CAHR = '0';
    private static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //字典树的根
    private TrieNode root;

    //初始化字典树
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 字典树节点
     */
    private static class TrieNode {
        //有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
        private long num;
        //所有的儿子节点
        private TrieNode[] son;
        //是不是最后一个节点
        private boolean isEnd;
        //节点的值
        private char val;

        //记录从根节点到本节点的所有 char 组成的序列
        private String totalVal = "";

        public TrieNode(char c) {
            this.num = 1;
            this.son = new TrieNode[SIZE];
            this.val = c;
            this.isEnd = false;
        }
        public TrieNode() {
            this.num = 1;
            this.son = new TrieNode[SIZE];
            this.isEnd = false;
        }
    }

    //建立字典树

    /**
     * 重要：在字典树中插入一个单词
     *
     * @param str
     */
    public void insert(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int pos = letters[i] - FIRST_CAHR;
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode(letters[i]);
                node.son[pos].totalVal = node.totalVal + letters[i];
            } else {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    /**
     * 重要：在字典树中查找一个完全匹配的单词
     */
    public boolean has(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (int i = 0, len = str.length(); i < len; i++) {
            int pos = letters[i] - FIRST_CAHR;
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * 核心：前序遍历字典树
     */
    public void preTraverse(TrieNode node) {
        if (node != null) {
            System.out.print(node.val + "-");
            for (TrieNode child : node.son) {
                preTraverse(child);
            }
        }
    }

    //============================================================

    /**
     * 计算单词前缀的数量
     */
    public long countPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return -1;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0, len = prefix.length(); i < len; i++) {
            int pos = letters[i] - FIRST_CAHR;
            if (node.son[pos] == null) {
                return 0;
            } else {
                node = node.son[pos];
            }
        }
        return node.num;
    }


    /**
     * 前序遍历经过此节点的单词.
     *
     * @param node
     * @param prefix
     */
    public void preTraverse(TrieNode node, String prefix) {
        if (!node.isEnd) {
            for (TrieNode child : node.son) {
                if (child != null) {
                    preTraverse(child, prefix + child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }


    private int count = 0;

    public String get(long position) {
        return "";
//        StringBuilder prefix = new StringBuilder();
//        if (position < 0 || position > root.num) {
//            return "";
//        }
//
//        TrieNode node = root;
//        int count = 0;
//        while (count < position) {
//            for (TrieNode child : node.son) {
//                if (child != null) {
//                    if (count + child.num < position) {
//                        count += child.num;
//                    } else {
//
//                    }
//
//                }
//            }
//        }


    }


    public static void main(String[] args) {
        Trie tree = new Trie();
        for (int i = 1; i <= 11; i++) {
            tree.insert(i + "");
        }
        System.out.println();
//        String[] strs = {"banana", "band", "bee", "absolute", "acm"};
//        String[] prefix = {"ba", "b", "band", "abc"};
//        for (String str : strs) {
//            tree.insert(str);
//        }
//        System.out.println(tree.has("abc"));
//        tree.preTraverse(tree.getRoot());
//        System.out.println();
////tree.printAllWords();
//        for (String pre : prefix) {
//            int num = tree.countPrefix(pre);
//            System.out.println(pre + " " + num);
//        }

    }
}
