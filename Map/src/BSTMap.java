import jdk.jshell.EvalException;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V>implements MapDemo<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }

    }
    private Node root;
    private int size;
    public BSTMap(){
        root=null;
        size=0;
    }

    @Override
    public void add(K key, V value) {
        root=add(root,key,value);
    }
    private Node add(Node node,K key,V value){
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else{
            node.value=value;
        }
        return node;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maxmum(Node node){
        if(node.right==null)
            return node;
        return minimum(node.right);
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }

        node.left=removeMin(node.left);
        return node;
    }

    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }

        node.right=removeMax(node.right);
        return node;
    }
    @Override
    public V remove(K key) {
        Node node=getNode(root,key);
        if(node!=null){
            root=remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if(node==null)
            return null;
        if(key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }
        if(key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }
        else{

            //待删除结点左子树为空的情况
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除结点右子树为空的情况
            if(node.right==null){
                Node leftNode=node.right;
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除结点左右子树均不为空的情况
            //找到比待删除结点大的最小节点，即将删除节点右子树的最小节点
            //用这个节点顶替待删除结点的位置
            Node successor= minimum(node.right);
            successor.right=removeMin(node.right);
            size++;
            successor.left=node.left;
            node.left=node.right=null;
            size--;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    private Node getNode(Node node,K key){
        if(node==null)
            return null;
        if(key.compareTo(node.key)==0)
            return node;
        else if(key.compareTo(node.key)<0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }

    @Override
    public V get(K key) {
        Node node =getNode(root,key);
        return node==null? null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if(node==null)
            throw new IllegalArgumentException(key+"doesn't exist");
        node.value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    public static void main(String[] args) {
        System.out.println("Test");
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){
            System.out.println("Total words"+words.size());

            BSTMap<String,Integer> map=new BSTMap<>();
            for(String word:words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words:"+map.getSize());
            System.out.println("Frequency of PRIDE: "+map.get("pride"));
            System.out.println("Frequency of PRIEJUDICE: "+map.get("prejudice"));


        }
    }

}
